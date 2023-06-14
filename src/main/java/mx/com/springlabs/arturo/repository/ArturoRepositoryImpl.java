package mx.com.springlabs.arturo.repository;

import java.io.File;
import java.io.IOException;
import java.util.Map;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.springframework.core.io.FileSystemResource;
import org.springframework.core.io.Resource;
import mx.com.springlabs.models.CompletionsRequestModel;
import mx.com.springlabs.models.CompletionsResponseModel;
import mx.com.springlabs.util.UtilArchivo;
import mx.com.springlabs.util.UtilJson;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.io.ByteArrayResource;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.client.MultipartBodyBuilder;
import org.springframework.stereotype.Repository;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.multipart.MultipartFile;

//Cuida el orden y el orden cuidará de ti
@Repository
public class ArturoRepositoryImpl implements ArturoRepository {

    @Autowired
    private RestTemplate clienteRest;

    @Value("${api-key}")
    private String accessToken;

    private final String completionsUrl = "https://api.openai.com/v1/completions";
    private final String imgGenerationsUrl = "https://api.openai.com/v1/images/generations";
    private final String imgVariationsUrl = "https://api.openai.com/v1/images/variations";

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

    /*
    Lo importante no es saber, sino tener el teléfono del que sabe
    Ref::
    https://www.baeldung.com/spring-rest-template-multipart-upload
     */
    @Override
    public String ejecutaVariacionDallE(MultipartFile image, Integer n, String size,String responseFormat) {
        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.MULTIPART_FORM_DATA);
        //headers.set("Authorization", "Bearer " + accessToken);
        headers.setBearerAuth(accessToken);

        MultiValueMap<String, Object> multipartBody = new LinkedMultiValueMap<>();
        multipartBody.add("image", image.getResource());//El demonio estaa en los detalles
        multipartBody.add("n", n);
        multipartBody.add("size", size);
        multipartBody.add("response_format", responseFormat);
        System.out.println("multipartBody:::"+multipartBody);
        HttpEntity<MultiValueMap<String, Object>> requestEntity = new HttpEntity<>(multipartBody, headers);
        return clienteRest.postForObject(imgVariationsUrl, requestEntity, String.class);
    }
}
