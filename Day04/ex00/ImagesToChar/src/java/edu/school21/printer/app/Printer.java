package edu.school21.printer.app;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import edu.school21.printer.logic.*;

public class Printer {

    public static void main(String[] Args) throws IOException {

        if (Args.length < 3) {
            throw new IllegalArgumentException("Invalid number of arguments");
        }

        String[] split1 = Args[0].split("=");
        String[] split2 = Args[1].split("=");

        if (!split1[0].equals("--white") || !split2[0].equals("--black")) {
            throw new IllegalArgumentException("--white=/input symbol for white/ --black=/input symbol for black/ " +
                    "/input image path/");
        }

        File file = new File(Args[2]);
        BufferedImage image = ImageIO.read(file);
        Converter converter = new Converter(split1[1].charAt(0), split2[1].charAt(0), image);
        converter.Print();
    }
}
