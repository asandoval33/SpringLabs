package mx.com.springlabs.service;

import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

public interface PruebaService {

    public String peliculasAEmoji(String nombrePelicula);

    public String guardarArchivo(@RequestParam MultipartFile file, String nombreArchivo);

    public String listarArchivos();

    public byte[] buscarArchivo(String nombreArchivo);
}
