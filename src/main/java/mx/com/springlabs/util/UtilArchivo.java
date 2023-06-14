package mx.com.springlabs.util;

import java.awt.Color;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.imageio.ImageIO;

public class UtilArchivo {

    public static void main(String[] args) {
        File jpgFile=new File("D:\\EKT\\CursoSpring\\prompthero-prompt-31cbf1db83a.webp");
        File pngFile=new File("D:\\EKT\\CursoSpring\\ff.png");
        jpgToPng(jpgFile, pngFile);
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

    public static File bytesToFile(byte[] myByteArray, String pathname) {
        File outputFile = new File(pathname);
        try {
            Files.write(outputFile.toPath(), myByteArray);
        } catch (IOException ex) {
            Logger.getLogger(UtilArchivo.class.getName()).log(Level.SEVERE, null, ex);
        }
        return outputFile;
    }

    public static boolean jpgToPng(File jpgFile, File pngFile) {
        BufferedImage bufferGambar;
        //File pngFile=new File(namePathPng);
        try {
            bufferGambar = ImageIO.read(jpgFile);
            // pkai type INT karna bertipe integer RGB bufferimage
            BufferedImage newBufferGambar = new BufferedImage(bufferGambar.getWidth(), bufferGambar.getHeight(), BufferedImage.TYPE_INT_RGB);
            newBufferGambar.createGraphics().drawImage(bufferGambar, 0, 0, Color.white, null);
            ImageIO.write(newBufferGambar, "png", pngFile);
            return true;
        } catch (IOException e) {
            return false;
        }

    }

}
