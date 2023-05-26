package mx.com.springlabs.repository;

import mx.com.springlabs.models.CompletionsRequestModel;
import mx.com.springlabs.models.CompletionsResponseModel;

public interface OpenAIRepository {

    public CompletionsResponseModel ejecutaSolicitud(CompletionsRequestModel crm);
}
