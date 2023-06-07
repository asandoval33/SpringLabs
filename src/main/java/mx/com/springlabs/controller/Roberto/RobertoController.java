package mx.com.springlabs.controller.Roberto;

import mx.com.springlabs.service.Roberto.RobertoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author LOLBO
 */
@RestController
@RequestMapping("/Roberto")
public class RobertoController {
    @Autowired
    private RobertoService robertoService;

    @GetMapping("/sqlTranslate/{sentencia}")
    //@GetMapping("/tldr/{sentencia}")
    //@GetMapping("/pythondocs/{sentencia}")
    //@GetMapping("/study/{sentencia}")
    public String prueba(@PathVariable("sentencia") String sentencia) {
        return robertoService.datos(sentencia);
    }
}
