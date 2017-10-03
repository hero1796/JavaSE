
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import javax.swing.*;

public class Test2 {
    
    public static void main(String[] args) {

        JFrame frame = new JFrame();
        frame.setLayout(new CardLayout());
        frame.setSize(800, 800);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setVisible(true);
        final Panel2 panel2 = new Panel2();
        frame.add(panel2);
        JRadioButton rd = new JRadioButton("Show", false);
        rd.setBounds(100, 10, 100,30 );
        rd.addItemListener(new ItemListener() {
            @Override
            public void itemStateChanged(ItemEvent e) {
                System.out.println("OKOK");
                Graphics2D gg = (Graphics2D) panel2.getGraphics();
                panel2.veChu(gg);
            }
        });
        JRadioButton rd2 = new JRadioButton("Show tiep", false);
        rd2.setBounds(200, 10, 100,30 );
        rd2.addItemListener(new ItemListener() {
            @Override
            public void itemStateChanged(ItemEvent e) {
                System.out.println("OKOK2");
                Graphics2D g2d = (Graphics2D) panel2.getGraphics();
                g2d.translate(300, -80);
            g2d.scale(0.5, 0.5);
            panel2.veThuyen(g2d);
            g2d.scale(2, 2);
            g2d.translate(-300, 80);
            }
        });
        JButton button = new JButton("Button");
        button.setBounds(200, 50, 100, 30);
        button.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                System.out.println("Button clicked");
            }
        });
        ButtonGroup group = new ButtonGroup();
        group.add(rd); group.add(rd2); group.add(button);
        panel2.add(rd);
        panel2.add(rd2);
        panel2.add(button);
     }
    
     static class Panel2 extends JPanel {
        
        /**
		 * 
		 */
		private static final long serialVersionUID = 1L;
		protected void paintComponent(Graphics g) {
            doDraw(g);
          
        } 
        public void doDraw(Graphics g) {
            Graphics2D g2d = (Graphics2D) g;
            g2d.setStroke(new BasicStroke(5));
            g2d.setColor(Color.GREEN);
            
            g2d.fillArc(0, 0, 110, 110, 0, 180);
            
            g2d.fillOval(300, 300, 200, 100);
            g2d.fillPolygon(new int[] {50, 100, 150}, new int[] {300, 230, 300}, 3);
            g2d.translate(50, -35);
            g2d.fillPolygon(new int[] {50, 100, 150}, new int[] {300, 230, 300}, 3);
            g2d.translate(50, -35);
            g2d.fillPolygon(new int[] {50, 100, 150}, new int[] {300, 230, 300}, 3);
            g2d.translate(-50*2, 35*2);
            g2d.drawLine(0, 405, 579, 0);
            //thuyen
            veThuyen(g2d);
            
            
           
            //g2d.drawArc(0, 0, WIDTH, HEIGHT, ABORT, HEIGHT);
        } 
        public void veChu(Graphics2D g2d) {
             Font font = new Font("Times new roman", Font.BOLD, 40);
            g2d.setFont(font);
            
//            g2d.drawString("PTIT", 150 , 540);
            String s = "Hoc vien";
            Color[] c = {Color.BLACK, Color.RED};
             FontMetrics fm = g2d.getFontMetrics(font);
             g2d.rotate(-Math.PI / 4, 250 + fm.stringWidth(s) / 2, 250 - fm.getHeight() / 2);
                g2d.drawString(s, 250 , 250);
//            for (int i = 0; i < 8; i++) {
//                g2d.setColor(c[i%2]);
//                g2d.rotate(-Math.PI / 4, 250 + fm.stringWidth(s) / 2, 250 - fm.getHeight() / 2);
//                g2d.drawString(s, 250 , 250);
//            }
        }
        public void veThuyen(Graphics2D g2d) {
            Font font = new Font("arial", Font.BOLD, 30);
            FontMetrics fm = g2d.getFontMetrics(font);
            g2d.setFont(font);
            
            g2d.fillPolygon(new int[] {100, 300, 250, 150}, new int[] {500, 500, 560, 560}, 4);
            g2d.setColor(Color.BLACK);
            g2d.drawPolygon(new int[] {100, 300, 250, 150}, new int[] {500, 500, 560, 560}, 4);
            g2d.fillArc(200, 460, 200, 80, -45, 90);
            
            g2d.drawLine(195, 500, 195, 500 - 100);
            g2d.fillPolygon(new int[] {195, 195, 195 - 30}, new int[] {500 - 20, 500 - 100, 500 - 20}, 3);
            g2d.drawPolygon(new int[] {195, 195, 195 - 30}, new int[] {500 - 20, 500 - 100, 500 - 20}, 3);
            g2d.drawLine(195, 500, 195, 500 - 100);
            // buom 2
            g2d.setColor(Color.red);
            g2d.fillPolygon(new int[] {205, 205, 205 + 30}, new int[] {500 - 20, 500 - 100, 500 - 20}, 3);
            g2d.drawPolygon(new int[] {205, 205, 205 + 30}, new int[] {500 - 20, 500 - 100, 500 - 20}, 3);
            g2d.drawLine(205, 500, 205, 500 - 100); 
        }
    }
}
