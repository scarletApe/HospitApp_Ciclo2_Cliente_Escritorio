package com.multixsoft.hospitapp.gui;
import java.awt.Component;
import java.awt.Graphics;
import java.awt.Insets;
import java.awt.image.BufferedImage;
import java.net.URL;
import javax.imageio.ImageIO;
import javax.swing.border.Border;
 

public class BorderBackImage implements Border {
    public BufferedImage backgroundImg;
 
    public BorderBackImage(){
        try {
            URL imagePath = new URL(getClass().getResource("/com/multixsoft/hospitapp/imagenes/desk.png").toString());
            backgroundImg = ImageIO.read(imagePath);
        } catch (Exception ex) { 
            System.out.println("Error: "+ex);
        }
    }

    @Override
    public void paintBorder(Component c, Graphics g, int x, int y, int width, int height) {
        g.drawImage(backgroundImg, (x + (width - backgroundImg.getWidth())/2),(y + (height - backgroundImg.getHeight())/2), null);
    }
 
    @Override
    public Insets getBorderInsets(Component c) {
        return new Insets(0,0,0,0);
    }
 
    @Override
    public boolean isBorderOpaque() {
        return false;
    }
 
}
