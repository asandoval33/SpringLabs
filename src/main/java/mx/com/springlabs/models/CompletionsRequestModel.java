package mx.com.springlabs.models;

import lombok.Data;

@Data
public class CompletionsRequestModel {

    private String model;
    private String prompt;
    private Double temperature;
    private Integer max_tokens;
    private Double top_p;
    private Double frequency_penalty;
    private Double presence_penalty;
    private String[] stop;
}
