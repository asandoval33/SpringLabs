package mx.com.springlabs.repository;

import org.springframework.web.multipart.MultipartFile;

public interface PruebaRepository {

    public String guardarArchivo(MultipartFile file, String ruta);

    public String listarArchivos();

    public byte[] buscarArchivo(String nombreArchivo);
}
