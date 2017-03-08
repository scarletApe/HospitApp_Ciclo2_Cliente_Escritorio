package com.multixsoft.hospitapp.gui;

import com.jhlabs.image.BrushedMetalFilter;
import com.jhlabs.image.WoodFilter;
import java.awt.Color;
import java.awt.Component;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Insets;
import java.awt.LinearGradientPaint;
import java.awt.image.BufferedImage;
import javax.swing.border.Border;

public class BorderBackImage implements Border {

    private BufferedImage backgroundImg;
//    private boolean rescale = false;
    private int ow, oh;

    public BorderBackImage() {
//        try {
//            URL imagePath = new URL(getClass().getResource("/com/multixsoft/hospitapp/imagenes/desk.png").toString());
//            backgroundImg = ImageIO.read(imagePath);
//        } catch (Exception ex) { 
//            System.out.println("Error: "+ex);
//        }
    }

    @Override
    public void paintBorder(Component c, Graphics g, int x, int y, int width, int height) {
        //make the background image from one of the new filters.
        if (backgroundImg == null) {
            backgroundImg = new BufferedImage(width, height, BufferedImage.TYPE_INT_ARGB);
        }

        if (ow != width || oh != height) {
            ow = width;
            oh = height;
            backgroundImg = new BufferedImage(width, height, BufferedImage.TYPE_INT_ARGB);
            
            BrushedMetalFilter bmf = new BrushedMetalFilter();
            bmf.filter(backgroundImg, backgroundImg);
            
            //apply a wood filter
//            WoodFilter wf = new WoodFilter();
//            wf.filter(backgroundImg, backgroundImg);
        }

//        if (rescale) {
//            ScaleFilter sf = new ScaleFilter(width, height);
//            sf.filter(backgroundImg, backgroundImg);
//        } else {
//        Random ran = new Random();

//            PlasmaFilter pf = new PlasmaFilter();
//            pf.setSeed(ran.nextInt(6));
//            pf.filter(backgroundImg, backgroundImg);
        
//        apply a brushed metal filter
//            NoiseFilter nf = new NoiseFilter();
//            nf.filter(backgroundImg, backgroundImg);
//        backgroundImg = BorderBackImage.createGradientImg(width, height);
//        }
//        }
        g.drawImage(backgroundImg, 0, 0, null);
    }

    @Override
    public Insets getBorderInsets(Component c) {
        return new Insets(0, 0, 0, 0);
    }

    @Override
    public boolean isBorderOpaque() {
        return false;
    }

//    public void rescale() {
//        this.rescale = true;
//    }
    public static BufferedImage createGradientImg(int width, int height) {
        BufferedImage image = new BufferedImage(width, height, BufferedImage.TYPE_INT_RGB);
        /// background gradient paint, linear gradient paint for the background
        /// Gradient paint rendering could be made more optimized
        LinearGradientPaint lgrPaint = new LinearGradientPaint(0.0f, 0.0f, width, height,
                new float[]{0.0f, 0.5f, 0.6f, 1.0f},
                new Color[]{new Color(0x002AFF),
                    new Color(0x0CAAF9),
                    new Color(0x0CAAF9),
                    new Color(0x002AFF)});
//        LinearGradientPaint lgrPaint = new LinearGradientPaint(0.0f, 0.0f, width, height,
//                new float[]{0.0f, 0.5f, 0.6f, 1.0f},
//                new Color[]{ Color.green,
//                     Color.white,
//                     Color.white,
//                     Color.green});

        Graphics2D g2d = (Graphics2D) image.getGraphics();
        g2d.setPaint(lgrPaint);
        //g2d.shear(0.2, 0);
        g2d.fillRect(0, 0, width, height);

        g2d.dispose();
        //g2d.drawImage(textureImg, 0, 0, getWidth(), getHeight(), null);
        return image;
    }
}
