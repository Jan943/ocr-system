package pl.sopata.ocrsystem;

import java.awt.image.BufferedImage;
import java.io.IOException;
import java.net.URL;

import net.sourceforge.tess4j.*;

import javax.imageio.ImageIO;

public class TesseractExample {

    public static void main(String[] args) throws IOException {
        URL imageFile = new URL("https://i.pinimg.com/736x/0b/6b/65/0b6b65ad5510373fd8bd69d9645e0abc.jpg");
        BufferedImage bufferedImage = ImageIO.read(imageFile);

        ITesseract instance = new Tesseract();
        instance.setDatapath("C:\\Users\\Janek\\Downloads");
        instance.setLanguage("pol");
        try {
            String result = instance.doOCR(bufferedImage);
            System.out.println(result);
        } catch (TesseractException e) {
            System.err.println(e.getMessage());
        }
    }
}