package view;

import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

import controller.TCPClientController;
import ptit.hungvu.model.Student;

public class AddStudentFrm extends JFrame implements ActionListener {

	private static final long serialVersionUID = 1L;
	private JTextField tfId;
	private JTextField tfName;
	private JTextField tfdOb;
	private JTextField tfAddress;
	private JButton btnAdd;
	private JButton btnReset;
	public JTextField getTfId() {
		return tfId;
	}
	public void setTfId(JTextField tfId) {
		this.tfId = tfId;
	}
	public JTextField getTfName() {
		return tfName;
	}
	public void setTfName(JTextField tfName) {
		this.tfName = tfName;
	}
	public JTextField getTfdOb() {
		return tfdOb;
	}
	public void setTfdOb(JTextField tfdOb) {
		this.tfdOb = tfdOb;
	}
	public JTextField getTfAddress() {
		return tfAddress;
	}
	public void setTfAddress(JTextField tfAddress) {
		this.tfAddress = tfAddress;
	}
	public JButton getBtnAdd() {
		return btnAdd;
	}
	public void setBtnAdd(JButton btnAdd) {
		this.btnAdd = btnAdd;
	}
	public JButton getBtnReset() {
		return btnReset;
	}
	public void setBtnReset(JButton btnReset) {
		this.btnReset = btnReset;
	}
	
	public AddStudentFrm() {
		tfId = new JTextField(15);
		tfName = new JTextField(15);
		tfdOb = new JTextField(15);
		tfAddress = new JTextField(15);
		btnAdd = new JButton("Add");
		btnReset = new JButton("Reset");
		JPanel panel = new JPanel();
		panel.setLayout(new GridLayout(5, 2));
		panel.add(new JLabel("id: ")); panel.add(tfId);
		panel.add(new JLabel("Name: ")); panel.add(tfName);
		panel.add(new JLabel("Date of birth: ")); panel.add(tfdOb);
		panel.add(new JLabel("Address: ")); panel.add(tfAddress);
		panel.add(btnAdd); panel.add(btnReset);
		btnAdd.addActionListener(this);
		btnReset.addActionListener(this);
		this.setContentPane(panel);
		this.pack();
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		JButton btnClicked = (JButton) e.getSource();
		if(btnClicked.equals(btnAdd)) {
			clickBtnAdd();
		} else if(btnClicked.equals(btnReset)) {
			clickBtnReset();
		}
	}
	
	public void clickBtnAdd() {
		TCPClientController tcpClientCtr = new TCPClientController();
		tcpClientCtr.connect(1796, "localhost");
		DateFormat df = new SimpleDateFormat("MM/dd/yyyy");
		Date dob = null;
		try {
			dob = df.parse(tfdOb.getText());
		} catch (ParseException e) {
			e.printStackTrace();
		}
		Student st = new Student(Integer.parseInt(tfId.getText()), tfName.getText(), dob, tfAddress.getText());     
		tcpClientCtr.sendStudent(st);
		System.out.println(tcpClientCtr.receiveObject());
		tcpClientCtr.closeConnection();
	}
	
	public void clickBtnReset() {
		tfId.setText("");
		tfName.setText("");
		tfdOb.setText("");
		tfAddress.setText("");
	}
	
}
