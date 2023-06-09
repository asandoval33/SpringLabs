package mx.com.springlabs.arturo.repository;

import java.util.Map;
import mx.com.springlabs.models.CompletionsRequestModel;
import mx.com.springlabs.models.CompletionsResponseModel;
import mx.com.springlabs.util.UtilJson;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

//Cuida el orden y el orden cuidará de ti
@Service
public class ArturoRepositoryImpl implements ArturoRepository {

    @Autowired
    private RestTemplate clienteRest;

    @Value("${api-key}")
    private String accessToken;

    private final String completionsUrl = "https://api.openai.com/v1/completions";
    private final String imgGenerationsUrl = "https://api.openai.com/v1/images/generations";

    @Override
    public CompletionsResponseModel ejecutaSolicitud(CompletionsRequestModel crm) {
        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_JSON);
        headers.set("Authorization", "Bearer " + accessToken);
        String json = UtilJson.modeltoJson(crm, false);
        HttpEntity<String> request = new HttpEntity<>(json, headers);
        //ResponseEntity<String> responseEntityStr = clienteRest.postForEntity(completionsUrl, request, String.class);
        //String responseEntityStr = clienteRest.postForEntity(completionsUrl, request, String.class);
        String result = clienteRest.postForObject(completionsUrl, request, String.class);
        //Archivo archivo = UtilJson.jsonToModel(json, Archivo.class);
        //JsonNode root = objectMapper.readTree(responseEntityStr.getBody());
        //HttpEntity<String> entity = new HttpEntity<String>(requestJson,headers);
        return UtilJson.jsonToModel(result, CompletionsResponseModel.class);
    }

    @Override
    public String ejecutaSolicitudDallE(Map<String, Object> map) {
        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_JSON);
        headers.set("Authorization", "Bearer " + accessToken);
        String json = UtilJson.modeltoJson(map, false);
        System.out.println("json::" + json);
        HttpEntity<String> request = new HttpEntity<>(json, headers);
        return clienteRest.postForObject(imgGenerationsUrl, request, String.class);
    }
}
