package pl.sopata.ocrsystem;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController
public class OcrApi {

    private OcrService ocrService;
    private GraphicRepo graphicRepo;
//    private List<Graphic> graphicList;

    @Autowired
    public OcrApi(OcrService ocrService, GraphicRepo graphicRepo) {
        this.ocrService = ocrService;
        this.graphicRepo = graphicRepo;
//        this.graphicList = new ArrayList<>();
    }

    @PostMapping("/api/ocr")
    public String doOcr(@RequestBody Graphic graphic) {
        String ocr = ocrService.doOCR(graphic.getUrl());
        graphic.setContent(ocr);
        graphicRepo.save(graphic);
//        graphicList.add(graphic);
        return ocr;
    }

    @GetMapping("/api/ocr")
    public Iterable<Graphic> getGraphic() {
        return graphicRepo.findAll();
//        return graphicList;
    }
}
