package mx.com.springlabs.repository;

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

@Service
public class OpenAIRepositoryImpl implements OpenAIRepository {

    @Autowired
    private RestTemplate clienteRest;

    @Value("${api-key}")
    private String accessToken;

    private final String completionsUrl = "https://api.openai.com/v1/completions";

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

}
