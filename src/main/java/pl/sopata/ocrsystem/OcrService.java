package pl.sopata.ocrsystem;

import java.awt.image.BufferedImage;
import java.net.URL;

import net.sourceforge.tess4j.*;
import org.springframework.stereotype.Service;

import javax.imageio.ImageIO;

@Service
public class OcrService {

    public String doOCR(String url) {
        try {
            URL imageFile = new URL(url);
            BufferedImage bufferedImage = ImageIO.read(imageFile);
            ITesseract instance = new Tesseract();
            instance.setDatapath("C:\\Users\\Janek\\Downloads");
            instance.setLanguage("pol");
            return instance.doOCR(bufferedImage);
        } catch (Exception e) {
            // TODO Exception handler
            e.printStackTrace();
        }
        return "";
    }
}