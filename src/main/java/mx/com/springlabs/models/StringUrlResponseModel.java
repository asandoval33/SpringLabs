package mx.com.springlabs.models;

import lombok.Data;

@Data
public class StringUrlResponseModel {

    private String url;
    private byte[] b64_json;
}
