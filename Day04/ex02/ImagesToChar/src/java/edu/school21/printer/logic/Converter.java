package edu.school21.printer.logic;

import java.awt.*;
import java.awt.image.BufferedImage;

import com.diogonunes.jcdp.color.ColoredPrinter;
import com.diogonunes.jcdp.color.api.Ansi.Attribute;
import com.diogonunes.jcdp.color.api.Ansi.BColor;
import com.diogonunes.jcdp.color.api.Ansi.FColor;
import com.diogonunes.jcdp.color.api.Ansi;

public class Converter {

    private String White;
    private String Black;
    private BufferedImage image;

    public Converter(String white, String black, BufferedImage image) {

        this.Black = black;
        this.White = white;
        this.image = image;
    }

    public void Print() {

        ColoredPrinter cp = new ColoredPrinter.Builder(1, false).build();

        for (int i = 0; i < image.getHeight(); i++) {
            for (int j = 0; j < image.getWidth(); j++) {

                Color color = new Color(image.getRGB(j, i));
                int red = color.getRed();
                int green = color.getGreen();
                int blue = color.getBlue();
                BColor cl;

                if (red == 255 && green == 255 && blue == 255) {
                    cp.print(" ", Attribute.NONE, FColor.NONE, Ansi.BColor.valueOf(this.White));
                } else {
                    cp.print(" ", Attribute.NONE, FColor.NONE, Ansi.BColor.valueOf(this.Black));
                }
            }
            System.out.println();
        }
    }
}
