package mx.com.springlabs.models;

import lombok.Data;

@Data
public class ChoiceResponseModel {

    private String text;
    private Integer index;
    private String logprobs;
    private String finish_reason;

}
