
package mx.com.springlabs.arturo.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/arturo")
public class ArturoController {
    
    
    @GetMapping("/pelicula_emoji/{nombrePelicula}")
    public String prueba(@PathVariable("nombrePelicula") String nombrePelicula) {
        return nombrePelicula;
    }
}
