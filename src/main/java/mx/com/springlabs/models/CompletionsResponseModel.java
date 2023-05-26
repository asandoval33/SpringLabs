package mx.com.springlabs.models;

import lombok.Data;

@Data
public class CompletionsResponseModel {

    private String id;
    private String object;
    private Integer created;
    private String model;
    private ChoiceResponseModel[] choices;
    private UsageResponseModel usage;

}
