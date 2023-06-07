package mx.com.springlabs.arturo.repository;

import java.util.Map;
import mx.com.springlabs.models.CompletionsRequestModel;
import mx.com.springlabs.models.CompletionsResponseModel;

public interface ArturoRepository {

    public CompletionsResponseModel ejecutaSolicitud(CompletionsRequestModel crm);

    public String ejecutaSolicitudDallE(Map<String, Object> map);
}
