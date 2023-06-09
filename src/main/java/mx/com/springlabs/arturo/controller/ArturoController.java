package mx.com.springlabs.arturo.controller;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.net.URL;
import java.net.URLConnection;
import javax.annotation.Resource;
import mx.com.springlabs.arturo.service.ArturoService;
import mx.com.springlabs.util.UtilNet;
import org.apache.tomcat.util.http.fileupload.IOUtils;
import org.springframework.core.io.ByteArrayResource;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/arturo")
public class ArturoController {
    //El demonio esta en los detalles

    //@Autowired
    //@Resource(name = "arturoServiceImpl1")
    @Resource(name = "arturoServiceImpl")
    ArturoService arturoService;

    @GetMapping("/pelicula_emoji/{nombrePelicula}")
    public String prueba(@PathVariable("nombrePelicula") String nombrePelicula) {
        return nombrePelicula;
    }

    @GetMapping(value = "/yoda_dice", produces = MediaType.TEXT_PLAIN_VALUE)
    public String yodaDice(@RequestParam(value = "texto", required = false) String frase) {
        return arturoService.yodaDice(frase);
    }

    //a stained glass window depicting a dark wizard
    //a stained glass window depicting a strapless big hips girl
    @GetMapping(value = "/generar_imagen", produces = MediaType.TEXT_PLAIN_VALUE)
    public ResponseEntity<ByteArrayResource> generarImagen(@RequestParam() String promt) {
        byte[] data = null;
        int dataLeng = 0;
        try {
            URL url = new URL(arturoService.generarImagen(promt));
            URLConnection conn = url.openConnection();
            conn.setConnectTimeout(5000);
            conn.setReadTimeout(5000);
            conn.connect();

            ByteArrayOutputStream baos = new ByteArrayOutputStream();
            IOUtils.copy(conn.getInputStream(), baos);

            data = baos.toByteArray();
            dataLeng = data.length;
        } catch (IOException e) {
            // Log error and return null, some default or throw a runtime exception
        }
        ByteArrayResource resource = new ByteArrayResource(data);
        return ResponseEntity
                .ok()
                .contentLength(dataLeng)
                .header("Content-type", MediaType.IMAGE_GIF_VALUE)
                .body(resource);
    }

    @GetMapping(value = "/generar_imagen2")
    public ResponseEntity<ByteArrayResource> generarImagen2(@RequestParam() String promt) {
        System.out.println("promt::." + promt);
        byte[] data=UtilNet.urlABytes(arturoService.generarImagen(promt));
        //return arturoService.generarImagen(promt);
        ByteArrayResource resource = new ByteArrayResource(data);
        return ResponseEntity
                    .ok()
                    .contentLength(data.length)
                    .header("Content-type", MediaType.IMAGE_PNG_VALUE)
                    .body(resource);
    }
}
