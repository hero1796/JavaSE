/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ptit.hungvu.cardgame;

import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import javax.imageio.ImageIO;
import javax.swing.JButton;

/**
 *
 * @author HungVu
 */
public class Card extends JButton {

    private int value;
    private int type;
    private BufferedImage cardImage;

    public int getValue() {
        return value;
    }

    public void setValue(int value) {
        this.value = value;
    }

    public int getType() {
        return type;
    }

    public void setType(int type) {
        this.type = type;
    }

    public BufferedImage getCardImage() {
        return cardImage;
    }

    public void setCardImage(BufferedImage cardImage) {
        this.cardImage = cardImage;
    }

    public Card(int type, int value) {
        this.value = value;
        this.type = type;
        try {
            cardImage = ImageIO.read(new File("resource" + File.separator + type + "-" + value + ".PNG"));
        } catch (IOException ex) {
            ex.printStackTrace();
        }
    }

    @Override
    public Dimension getPreferredSize() {
        return new Dimension(78, 99);
    }

    @Override
    protected void paintComponent(Graphics g) {
        Graphics2D g2d = (Graphics2D) g;
        drawCard(g2d);
    }

    public void drawCard(Graphics2D g) {
        g.drawImage(cardImage, 0, 0, this.getWidth(), this.getHeight(), this);
    }

    @Override
    public String toString() {
        return type + "-" + value;
    }

    public int comparePower(Card other) {
        int value1 = this.value;
        int value2 = other.getValue();
        if (value1 == value2) {
            return 0;
        } else if (value1 == 2 && value2 != 2) {
            return 1;
        } else if (value1 != 2 && value2 == 2) {
            return -1;
        } else if (value1 == 1 && value2 != 1) {
            return 1;
        } else if (value1 != 1 && value2 == 1) {
            return -1;
        } else if (value1 != 2 && value1 != 1 && value2 != 2 && value2 != 1) {
            if (value1 < value2) {
                return -1;
            } else if (value1 > value2) {
                return 1;
            }
        }
        return 2;
    }

    public boolean isSameType(Card other) {
        return this.type == other.getType();
    }
}
