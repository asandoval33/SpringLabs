package mx.com.springlabs.repository;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Arrays;
import java.util.logging.Level;
import java.util.logging.Logger;
import mx.com.springlabs.util.UtilArchivo;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

@Service
public class PruebaRepositoryImpl implements PruebaRepository {

    @Override
    public String guardarArchivo(MultipartFile file, String nombreArchivo) {
        String resultado = "";
        try {
            String estensionArchivo = UtilArchivo.getExtencionNombreArchivo(file.getOriginalFilename());
            String ruta = UtilArchivo.getRutaParaArchivos("/ArchivosSpringLabs/")
                    + UtilArchivo.quitaExtencionNombreArchivo(nombreArchivo) + "." + estensionArchivo;

            byte[] fileBytes = file.getBytes();
            Path path = Paths.get(ruta);
            resultado = Files.write(path, fileBytes).toString();
        } catch (IOException ex) {
            Logger.getLogger(PruebaRepositoryImpl.class.getName()).log(Level.SEVERE, null, ex);
        }
        return resultado;
    }

    @Override
    public String listarArchivos() {
        try {
            String ruta = UtilArchivo.getRutaParaArchivos("/ArchivosSpringLabs/");
            StringBuilder builder = new StringBuilder();
            File rutabase = new File(ruta);
            Arrays.asList(rutabase.listFiles()).forEach(subElem -> {
                builder.append(subElem.getName()).append("\n");
            });
            return builder.toString();
        } catch (IOException ex) {
            Logger.getLogger(PruebaRepositoryImpl.class.getName()).log(Level.SEVERE, null, ex);
        }
        return "Error en la ruta";
    }

    @Override
    public byte[] buscarArchivo(String nombreArchivo) {
        try {
            return Files.readAllBytes(Paths.get(UtilArchivo.getRutaParaArchivos("/ArchivosSpringLabs/") + nombreArchivo));
        } catch (IOException ex) {
            Logger.getLogger(PruebaRepositoryImpl.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }

}
