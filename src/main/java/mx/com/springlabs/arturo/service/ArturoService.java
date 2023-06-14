package mx.com.springlabs.arturo.service;

import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

public interface ArturoService {

    public String yodaDice(String texto);

    public String generarImagen(String promt);

    public String generaVariacion(MultipartFile image, int n, int size);
}
