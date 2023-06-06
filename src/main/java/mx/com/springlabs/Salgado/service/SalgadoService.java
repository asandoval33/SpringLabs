
package mx.com.springlabs.Salgado.service;

import mx.com.springlabs.models.CompletionsRequestModel;
import mx.com.springlabs.models.CompletionsResponseModel;

public interface SalgadoService {
    
    public CompletionsResponseModel complexity(CompletionsRequestModel model);
    
    public String complex (String frase);
    public String book (String nombreLibro);
    public String nota (String nota);
}
