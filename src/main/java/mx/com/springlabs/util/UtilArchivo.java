package mx.com.springlabs.util;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

public class UtilArchivo {

    public static void main(String[] args) {

    }

    public static String quitaExtencionNombreArchivo(String nombreArchivo) {
        return nombreArchivo.substring(0, nombreArchivo.indexOf("."));
    }

    public static String getExtencionNombreArchivo(String nombreArchivo) {
        return nombreArchivo.substring(nombreArchivo.lastIndexOf(".") + 1);
    }

    public static String getRutaParaArchivos(String subRuta) throws IOException {
        StringBuilder builder = new StringBuilder();
        builder.append(System.getProperty("user.home"));
        builder.append(File.separator);
        builder.append(subRuta.replace("/", File.separator).replace("\\", File.separator));
        String rutaCompleta = builder.toString().replace(File.separator + File.separator, File.separator);
        Path path = Paths.get(rutaCompleta);
        Files.createDirectories(path);
        return rutaCompleta;
    }

}
