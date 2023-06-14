package mx.com.springlabs.arturo.repository;

import java.util.Map;
import mx.com.springlabs.models.CompletionsRequestModel;
import mx.com.springlabs.models.CompletionsResponseModel;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

public interface ArturoRepository {

    public CompletionsResponseModel ejecutaSolicitud(CompletionsRequestModel crm);

    public String ejecutaSolicitudDallE(Map<String, Object> map);

    public String ejecutaVariacionDallE(MultipartFile image, Integer n, String size,String responseFormat);
}
