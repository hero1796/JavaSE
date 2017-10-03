/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import java.awt.*;
import java.awt.geom.GeneralPath;
import javax.swing.*;

/**
 *
 * @author HungVu
 */
public class Test1 {

	public static void main(String[] args) {
		JFrame test1 = new JFrame();
		test1.setSize(800, 600);
		test1.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		test1.setResizable(false);
		test1.setLocationRelativeTo(null);
		test1.setVisible(true);
		MyPanel1 panel1 = new MyPanel1();
		test1.add(panel1);

	}

	static class MyPanel1 extends JPanel {

		@Override
		protected void paintComponent(Graphics g) {
			super.paintComponent(g);
			doDrawing(g);
		}

		private void doDrawing(Graphics g) {
			Graphics2D g2 = (Graphics2D) g;
			g2.setColor(Color.BLACK);
			g2.setStroke(new BasicStroke(5));
			g2.drawRect(50, 400, 500, 30);

			g2.drawRect(50 + 10, 400 - 60, 40, 60);
			g2.drawRect(50 + 500 - 10 - 40, 400 - 60, 40, 60);

			g2.drawOval(50 + 10, 400 - 60 - 40, 40, 40);
			g2.drawOval(50 + 500 - 10 - 40, 400 - 60 - 40, 40, 40);

			g2.drawPolygon(new int[] { 50 + 10 + 40 + 150, 50 + 10 + 40 + 40 + 150, 50 + 10 + 40 + 40 + 40 + 150 },
					new int[] { 400, 350, 400 }, 3);

			g2.drawRect(50 + 10 + 40 + 40 + 150 - 50, 400 - 50 - 100, 100, 100);

			Font font = new Font("arial", Font.ITALIC, 20);
			FontMetrics fm = g2.getFontMetrics(font);
			String s = new String("Bai 1");
			fm.stringWidth(s);
		}
	}
}
