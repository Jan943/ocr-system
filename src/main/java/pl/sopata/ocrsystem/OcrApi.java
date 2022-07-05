package pl.sopata.ocrsystem;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class OcrApi {

    private OcrService ocrService;

    @Autowired
    public OcrApi(OcrService ocrService) {
        this.ocrService = ocrService;
    }

    @PostMapping("/api/ocr")
    public String doOcr(@RequestBody Graphic graphic) {
        String ocr = ocrService.doOCR(graphic.getUrl());
        return ocr;
    }
}
