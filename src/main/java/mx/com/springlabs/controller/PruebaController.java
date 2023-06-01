package mx.com.springlabs.controller;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.util.Map;
import java.util.stream.Collectors;
import mx.com.springlabs.models.ChoiceResponseModel;
import mx.com.springlabs.service.PruebaService;
import mx.com.springlabs.util.UtilArchivo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.ByteArrayResource;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.util.MultiValueMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

@RestController
@RequestMapping("/prueba")
public class PruebaController {

    @Autowired
    private PruebaService pruebaService;

    @GetMapping("/pelicula_emoji/{nombrePelicula}")
    public String prueba(@PathVariable("nombrePelicula") String nombrePelicula) {
        return pruebaService.peliculasAEmoji(nombrePelicula);
    }

    /*
    curl --location --request GET 'http://localhost:8080/prueba/prueba_json' \
--header 'Content-Type: application/json' \
--data-raw '{
    "text" : "hola",
    "index" : 1726,
    "logprobs" : "log",
    "finish_reason" : "finish"
}'
     */
    @GetMapping(value = "/prueba_json", consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<String> guardar(@RequestBody ChoiceResponseModel choiceResponseModel) {
        return ResponseEntity.ok(choiceResponseModel.toString());
    }

    //curl --location --request GET 'http://localhost:8080/prueba/getBasePath'
    @GetMapping("/getBasePath")
    public ResponseEntity<String> getBasePath() {
        return new ResponseEntity<>(ServletUriComponentsBuilder.fromCurrentContextPath().build().toUriString(), HttpStatus.OK);
    }

    /*
    pruebas Header INI
        Referencia:
        https://www.baeldung.com/spring-rest-http-headers
 
        curl --location --request GET 'http://localhost:8080/prueba/greeting' \
        --header 'Content-Type: application/json' \
     */
    @GetMapping("/greeting")
    public ResponseEntity<String> greeting(@RequestHeader(HttpHeaders.CONTENT_TYPE) String contentType) {
        return new ResponseEntity<>(contentType, HttpStatus.OK);
    }

    //curl --location --request GET 'http://localhost:8080/prueba/getBaseUrl'
    @GetMapping("/getBaseUrl")
    public ResponseEntity<String> getBaseUrl(@RequestHeader HttpHeaders headers) {
        InetSocketAddress host = headers.getHost();
        String url = host != null ? "http://" + host.getHostName() + ":" + host.getPort() : "";
        return new ResponseEntity<>(String.format("Base URL = %s", url), HttpStatus.OK);
    }

    //curl --location --request GET 'http://localhost:8080/prueba/multiValue'
    @GetMapping(value = "/multiValue", produces = MediaType.TEXT_PLAIN_VALUE)
    public ResponseEntity<String> multiValue(@RequestHeader MultiValueMap<String, String> headers) {

        StringBuilder sb = new StringBuilder();
        headers.forEach((key, value) -> {
            sb.append(String.format("Header '%s' = %s\n", key, value.stream().collect(Collectors.joining("|"))));
        });
        sb.append(String.format("Listed %d headers", headers.size()));
        return new ResponseEntity<>(sb.toString(), HttpStatus.OK);
    }

    @GetMapping(value = "/listHeaders", produces = MediaType.TEXT_PLAIN_VALUE)
    public ResponseEntity<String> listAllHeaders(@RequestHeader Map<String, String> headers) {
        StringBuilder sb = new StringBuilder();
        headers.forEach((key, value) -> {
            sb.append(String.format("Header '%s' = %s\n", key, value));
        });
        sb.append(String.format("Listed %d headers", headers.size()));
        return new ResponseEntity<>(sb.toString(), HttpStatus.OK);
    }

    @GetMapping(value = "/listHeaders2", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Object> listAllHeaders2(@RequestHeader Map<String, String> headers) {
        return new ResponseEntity<>(headers, HttpStatus.OK);
    }

    //pruebas Header FIN
    //pruebas con Archivos INI
    /*
    curl --location --request POST 'http://localhost:8080/prueba/guardar_archivo' \
    --form 'nombreArchivo="img.png"' \
    --form 'file=@"/path/to/file"'
     */
    @PostMapping(value = "/guardar_archivo", consumes = MediaType.MULTIPART_FORM_DATA_VALUE)
    public ResponseEntity<String> guardarArchivo(@RequestParam MultipartFile file, @RequestParam("nombreArchivo") String nombreArchivo) throws IOException {
        return ResponseEntity.ok(pruebaService.guardarArchivo(file, nombreArchivo));
    }

    //curl --location --request GET 'http://localhost:8080/prueba/listar_archivos'
    @GetMapping(value = "/listar_archivos", produces = MediaType.TEXT_PLAIN_VALUE)
    public ResponseEntity<String> listarArchivos() {
        return ResponseEntity.ok(pruebaService.listarArchivos());
    }

    //curl --location --request GET 'http://localhost:8080/prueba/downloadFile?fileName=blanco.png'
    @GetMapping("/downloadFile")
    public ResponseEntity<ByteArrayResource> downloadFile(@RequestParam(value = "fileName") String fileName)
            throws IOException {
        String tipoArchivo = UtilArchivo.getExtencionNombreArchivo(fileName);
        byte[] data = pruebaService.buscarArchivo(fileName);
        ByteArrayResource resource = new ByteArrayResource(data);
        if (tipoArchivo.equals("png") || tipoArchivo.equals("jpg") || tipoArchivo.equals("jpeg") || tipoArchivo.equals("gif")) {
            return ResponseEntity
                    .ok()
                    .contentLength(data.length)
                    .header("Content-type", MediaType.IMAGE_GIF_VALUE)
                    .body(resource);
        } else {
            return ResponseEntity
                    .ok()
                    .contentLength(data.length)
                    .header("Content-type", "application/octet-stream")
                    .header("Content-disposition", "attachment; filename=\"" + fileName + "\"")
                    .body(resource);
        }
    }
    //pruebas con Archivos FIN

}
