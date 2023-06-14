package mx.com.springlabs.arturo.service;

import java.awt.Color;
import java.awt.image.BufferedImage;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.nio.file.Files;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.imageio.ImageIO;
import mx.com.springlabs.arturo.repository.ArturoRepository;
import mx.com.springlabs.models.CompletionsRequestModel;
import mx.com.springlabs.models.ImgGenerateResponseModel;
import mx.com.springlabs.models.StringUrlResponseModel;
import mx.com.springlabs.repository.OpenAIRepository;
import mx.com.springlabs.util.CustomMultipartFile;
import mx.com.springlabs.util.UtilArchivo;
import mx.com.springlabs.util.UtilFecha;
import mx.com.springlabs.util.UtilJson;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

@Service
public class ArturoServiceImpl implements ArturoService {

    @Autowired
    OpenAIRepository openAIRepository;
    @Autowired
    ArturoRepository arturoRepository;

    @Override
    public String yodaDice(String frase) {
        CompletionsRequestModel crm = new CompletionsRequestModel();
        crm.setModel("text-davinci-003");

        crm.setPrompt("Eres yoda de star wars, y vas a transmitir el siguiente mensaje con tu forma particular de expresarte:\n"
                + "\"" + frase + "\"");
//        crm.setPrompt("Convert phrases or text into expressions that Yoda would say.\n"
//                + "\"" + frase + "\"");
        crm.setTemperature(1.0);
        crm.setMax_tokens(100);
        crm.setTop_p(1.0);
        crm.setFrequency_penalty(0.0);
        crm.setPresence_penalty(0.0);
        //String[] stop = {"\n"};
        // crm.setStop(stop);
        return openAIRepository.ejecutaSolicitud(crm).getChoices()[0].getText();
    }

    @Override
    public String generarImagen(String promt) {
        Map<String, Object> map = new HashMap();
        map.put("prompt", promt);
        map.put("n", 1);
        map.put("size", "1024x1024");
        Map<String, Object> mapResul = UtilJson.jsonToModel(arturoRepository.ejecutaSolicitudDallE(map), Map.class);
        System.out.println("mapResul::" + mapResul);
        return (String) ((LinkedHashMap) ((ArrayList) mapResul.get("data")).get(0)).get("url");
    }

    @Override
    public String generaVariacion(MultipartFile image, int n, int size) {
        /*--Definimos las rutas donde se guardaraan las imagenes resultantes---*/
        String ruta = "/";
        String nombreCarpeta = UtilArchivo.quitaExtencionNombreArchivo(image.getOriginalFilename());
        int tamNomCarpeta = 10;//tamanio nombre de la carpeta en base al nombre de la imagen original
        nombreCarpeta = nombreCarpeta.length() >= tamNomCarpeta
                ? nombreCarpeta.substring(0, tamNomCarpeta)
                : nombreCarpeta;
        try {
            ruta = UtilArchivo.getRutaParaArchivos("/ArchivosSpringLabs/ArchivosVariacion/"
                    + nombreCarpeta + "/");
        } catch (IOException ex) {
            Logger.getLogger(ArturoServiceImpl.class.getName()).log(Level.SEVERE, null, ex);
        }

        /*--En caso de ser necesario convertiremos un JPG a PNG---*/
        if (!UtilArchivo.getExtencionNombreArchivo(image.getOriginalFilename()).equals("png")) {
            boolean crearPng = true;
            try {
                InputStream is = new ByteArrayInputStream(image.getBytes());
                BufferedImage bufferGambar = ImageIO.read(is);

                BufferedImage newBufferGambar = new BufferedImage(bufferGambar.getWidth(), bufferGambar.getHeight(), BufferedImage.TYPE_INT_RGB);
                newBufferGambar.createGraphics().drawImage(bufferGambar, 0, 0, Color.white, null);
                byte[] fileContent;
                if (crearPng) {//crea el archivo convertido a png
                    File pngFile = new File(ruta + nombreCarpeta + ".png");
                    ImageIO.write(newBufferGambar, "png", pngFile);
                    fileContent = Files.readAllBytes(pngFile.toPath());
                } else {
                    ByteArrayOutputStream baos = new ByteArrayOutputStream();
                    ImageIO.write(newBufferGambar, "png", baos);
                    fileContent = baos.toByteArray();
                }
                image = new CustomMultipartFile(fileContent);
            } catch (IOException ex) {
                Logger.getLogger(ArturoServiceImpl.class.getName()).log(Level.SEVERE, null, ex);
            }
        }

        /*--Adecuando la peticion---*/
        String sizeS = "1024x1024";
        //String resultFormatS = "url";//b64_json  , url
        //Este parametro es para solicitar que el resultado sea una 'URL' o Bytes[]
        String resultFormatS = "b64_json";//url  , b64_json
        if (size == 2) {
            sizeS = "512x512";
        } else if (size == 3) {
            sizeS = "256x256";
        }

        /*--Enviamos La Solicitud...---*/
        //... y el json resultante lo guardaremos como String
        String json = arturoRepository.ejecutaVariacionDallE(image, n, sizeS, resultFormatS);

        /*--Procesamos el resultado---*/
        //Convertimos del json a un modelo
        ImgGenerateResponseModel iGRM = UtilJson.jsonToModel(json, ImgGenerateResponseModel.class);

        StringBuilder agregaRutas = new StringBuilder();//Lo usaremos para concatenar el directorio de guardado de las imagenes
        StringUrlResponseModel[] dataImages = iGRM.getData();
        int contador = 0;
        ruta += UtilFecha.toYYYYMMDDHHMMSS(System.currentTimeMillis());//Las imagenes se llamaraan de acuerdo a la fecha y hora
        for (StringUrlResponseModel dataImage : dataImages) {
            agregaRutas.append(UtilArchivo.bytesToFile(dataImage.getB64_json(), ruta + "_" + contador + ".png").getAbsolutePath()).append("\n");
            contador++;
        }
        //return iGRM.getData()[0].getUrl();
        return agregaRutas.toString();
    }
}
