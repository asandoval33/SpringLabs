package mx.com.springlabs.Salgado.controller;

import org.springframework.beans.factory.annotation.Autowired;
import mx.com.springlabs.Salgado.service.SalgadoService;
import mx.com.springlabs.models.CompletionsRequestModel;
import mx.com.springlabs.models.CompletionsResponseModel;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/salgado")
public class SalgadoController {
  @Autowired
  private SalgadoService SalgadoService;
  
   @GetMapping("/complexity")  
    public CompletionsResponseModel complexity(@RequestBody CompletionsRequestModel model){       
    return SalgadoService.complexity(model);
    } 
    
   @GetMapping("/complex")
   public String complex(@RequestParam(value = "texto", required = false) String frase){
   return SalgadoService.complex(frase);
   }
    
   @GetMapping(value = "/book", produces = MediaType.TEXT_PLAIN_VALUE)
   
   public String book(@RequestParam(value = "texto", required = false) String nombreLibro){
   return SalgadoService.book(nombreLibro);
   }
   
   @GetMapping("/nota")
   
   public String nota(@RequestParam(value = "texto", required = false) String nota){
   return SalgadoService.nota(nota);
   }
}
