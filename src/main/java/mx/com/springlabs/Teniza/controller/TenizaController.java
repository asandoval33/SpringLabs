package mx.com.springlabs.Teniza.controller;

//import mx.com.springlabs.controller.*;
import mx.com.springlabs.Teniza.service.TenizaService;
//import mx.com.springlabs.service.PruebaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/Teniza")
public class TenizaController {

    
    @Autowired
    private TenizaService tenizaService;

    @GetMapping("/grammar")
    public String prueba() {
        return tenizaService.grammar();
    }
  

    @GetMapping("/summarize/{Texto}")
    public String summarize(@PathVariable("Texto")String texto){
        return tenizaService.summarize(texto);
    }
    @GetMapping("/code")
    public String code(){
        return tenizaService.code();
    }
      @GetMapping("/sql")
    public String sql(){
        return tenizaService.sql();
    }
      @GetMapping("/recipe")
    public String recipe(){
        return tenizaService.recipe();
    }
}
