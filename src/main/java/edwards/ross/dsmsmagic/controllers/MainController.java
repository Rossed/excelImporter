package edwards.ross.dsmsmagic.controllers;

import edwards.ross.dsmsmagic.excel.Readsheet;
import edwards.ross.dsmsmagic.excel.Writesheet;
import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;

@Controller
public class MainController {

    @Autowired private Readsheet readsheet;
    @Autowired private Writesheet writesheet;

    @GetMapping("/data-upload")
    public String greeting(Model model) {
        model.addAttribute("outcome", "Success");
        return "data-upload";
    }

    @PostMapping("/file-upload")
    public String fileUpload(@RequestParam("excelFile") MultipartFile file, Model model) {
        try {
            readsheet.readFile(file);
        } catch(IOException | InvalidFormatException e) {
            model.addAttribute("outcome", "Failure");
            return "data-upload";
        }
        model.addAttribute("outcome", "Success");
        return "data-upload";
    }

    @GetMapping("/write-db-to-file")
    public String writeDbToFile(Model model) {
        try {
            writesheet.writeFile();
        } catch(IOException e) {
            model.addAttribute("outcome", "Failure");
            return "data-upload";
        }
        model.addAttribute("outcome", "Success");
        return "data-upload";
    }

}
