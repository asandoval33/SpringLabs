package mx.com.springlabs.arturo.service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;
import mx.com.springlabs.arturo.repository.ArturoRepository;
import mx.com.springlabs.models.CompletionsRequestModel;
import mx.com.springlabs.repository.OpenAIRepository;
import mx.com.springlabs.util.UtilJson;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

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

}
