package view;

import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;

import controller.RMIClientController;
import java.rmi.RemoteException;
import java.util.logging.Level;
import java.util.logging.Logger;
import ptit.hungvu.karaoke.Phong;

public class RMILoginClientFrm extends JFrame implements ActionListener {

    private static final long serialVersionUID = 5086760931196902476L;
    private JTextField tfMa = new JTextField();
    private JTextField tfTen = new JTextField();
    private JButton btnLogin = new JButton("Login");
    private JLabel lblResult = new JLabel("");

    public void setLblResult(JLabel lblResult) {
        this.lblResult = lblResult;
    }

    public static long getSerialversionuid() {
        return serialVersionUID;
    }

    public RMILoginClientFrm() {
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setLayout(null);
        tfMa.setBounds(30, 20, 100, 30);
        tfTen.setBounds(30, 60, 100, 30);
        btnLogin.setBounds(30, 100, 100, 30);
        lblResult.setBounds(30, 140, 200, 30);
        add(tfMa);
        add(tfTen);
        add(btnLogin);
        add(lblResult);
        setPreferredSize(new Dimension(800, 600));
        pack();
        btnLogin.addActionListener(this);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        JButton btn = (JButton) e.getSource();
        if (btnLogin.equals(btn)) {
            clickLogin();
        }
    }

    public void clickLogin() {
        Phong user = new Phong(Integer.parseInt(tfMa.getText()), tfTen.getText(), null, 50000);
        RMIClientController clientCtr = new RMIClientController();
        try {
            if (clientCtr.remoteCheckLogin(user)) {
                lblResult.setText("Login success");
            } else {
                lblResult.setText("Login fail");
            }
        } catch (RemoteException ex) {
            ex.printStackTrace();
        }
    }
}
