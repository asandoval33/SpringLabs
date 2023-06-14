package mx.com.springlabs.arturo.service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;
import mx.com.springlabs.arturo.repository.ArturoRepository;
import mx.com.springlabs.repository.OpenAIRepository;
import mx.com.springlabs.util.UtilJson;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

@Service
public class ArturoServiceImpl1 implements ArturoService {

    @Autowired
    OpenAIRepository openAIRepository;

    @Autowired
    ArturoRepository arturoRepository;

    @Override
    public String yodaDice(String frase) {
        return "Un misterio infinito la Fuerza es. Mucho por aprender aún queda.";
    }

    @Override
    public String generarImagen(String promt) {
        Map<String, Object> map = new HashMap<>();
        map.put("prompt", promt);
        map.put("n", 1);
        map.put("size", "1024x1024");
        Map<String, Object> mapResul = UtilJson.jsonToModel(arturoRepository.ejecutaSolicitudDallE(map), Map.class);
        System.out.println("mapResul::" + mapResul);
        return (String) ((LinkedHashMap) ((ArrayList) mapResul.get("data")).get(0)).get("url");
    }

    @Override
    public String generaVariacion(MultipartFile image, int n, int size) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

   

}
