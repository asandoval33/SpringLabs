package mx.com.springlabs.controller;

import mx.com.springlabs.service.PruebaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/prueba")
public class PruebaController {

    
    @Autowired
    private PruebaService pruebaService;

    @GetMapping("/pelicula_emoji/{nombrePelicula}")
    public String prueba(@PathVariable("nombrePelicula") String nombrePelicula) {
        return pruebaService.peliculasAEmoji(nombrePelicula);
    }

}
