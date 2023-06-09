package mx.com.springlabs.util;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.json.JsonMapper;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.net.URL;
import java.net.URLConnection;
import org.apache.tomcat.util.http.fileupload.IOUtils;

public class UtilNet {

    public static void main(String[] args) {

    }

    public static  byte[] urlABytes(String urlCadena) {
       byte[] data = null;
        try {
            URL url = new URL(urlCadena);
            URLConnection conn = url.openConnection();
            conn.setConnectTimeout(5000);
            conn.setReadTimeout(5000);
            conn.connect();
            ByteArrayOutputStream baos = new ByteArrayOutputStream();
            IOUtils.copy(conn.getInputStream(), baos);
            data = baos.toByteArray();
        } catch (IOException e) {
            // Log error and return null, some default or throw a runtime exception
        }
        return data;
    }

   
}
