
package mx.com.springlabs.IsraelR.controller;

import mx.com.springlabs.IsraelR.service.IsraelRService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/Israel")
public class IsraelRController {

    
    @Autowired
    private IsraelRService israelService;
    
    @GetMapping("/classification")
    public String classification() {
        return israelService.classification();
    }
    @GetMapping("/spreadsheet_creator")
    public String spreadsheet_creator() {
        return israelService.spreadsheet_creator();
    }
    @GetMapping("/javaScript_one_line")
    public String javaScript_one_line() {
        return israelService.javaScript_one_line();
    }



}