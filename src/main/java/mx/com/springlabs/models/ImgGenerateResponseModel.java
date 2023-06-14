package mx.com.springlabs.models;

import lombok.Data;

@Data
public class ImgGenerateResponseModel {

    private String created;
    private StringUrlResponseModel[] data;

}
