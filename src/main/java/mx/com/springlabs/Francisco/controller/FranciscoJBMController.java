package mx.com.springlabs.Francisco.controller;

import mx.com.springlabs.Francisco.service.FranciscoJBMService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/Francisco")
public class FranciscoJBMController {

    
    @Autowired
    private FranciscoJBMService FranciscoJBMService;

    @GetMapping("/API1/{textoEjemplo}")
    public String testAPI1(@PathVariable("textoEjemplo") String textoEjemplo) {
        return FranciscoJBMService.testAPI1(textoEjemplo);
    }
    
    @GetMapping("/API2/{textoEjemplo}")
    public String testAPI2(@PathVariable("textoEjemplo") String textoEjemplo) {
        return FranciscoJBMService.testAPI2(textoEjemplo);
    }
    
    @GetMapping("/API3/{textoEjemplo}")
    public String testAPI3(@PathVariable("textoEjemplo") String textoEjemplo) {
        return FranciscoJBMService.testAPI3(textoEjemplo);
    }
    
    @GetMapping("/API4/{textoEjemplo}")
    public String testAPI4(@PathVariable("textoEjemplo") String textoEjemplo) {
        return FranciscoJBMService.testAPI4(textoEjemplo);
    }
    
     @GetMapping("/API5/{textoEjemplo}")
    public String testAPI5(@PathVariable("textoEjemplo") String textoEjemplo) {
        return FranciscoJBMService.testAPI5(textoEjemplo);
    }

}
