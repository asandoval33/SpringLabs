package mx.com.springlabs.Francisco.controller;

import mx.com.springlabs.Francisco.service.FranciscoJBMService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/prueba")
public class FranciscoJBMController {

    
    @Autowired
    private FranciscoJBMService FranciscoJBMService;

    @GetMapping("/API/{textoEjemplo}")
    public String prueba(@PathVariable("textoEjemplo") String textoEjemplo) {
        return FranciscoJBMService.testAPI(textoEjemplo);
    }

}
