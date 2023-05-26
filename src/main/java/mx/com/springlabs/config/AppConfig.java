package mx.com.springlabs.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.client.SimpleClientHttpRequestFactory;
import org.springframework.web.client.RestTemplate;

@Configuration
public class AppConfig {

    @Bean("clienteRest")//se va a usar para inyectar un objeto new RestTemplate(). Para cliente de apis
    public RestTemplate registrarRestTemplate() {
        SimpleClientHttpRequestFactory factory = new SimpleClientHttpRequestFactory();
        factory.setBufferRequestBody(false);
//        MultipartConfigFactory factosry = new MultipartConfigFactory();
//        factosry.setMaxFileSize("200MB");
//        factosry.setMaxRequestSize("200MB");
        return new RestTemplate(factory);
        //return new RestTemplate();
    }
}
