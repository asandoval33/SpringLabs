package mx.com.springlabs.models;

import lombok.Data;

@Data
public class UsageResponseModel {

    private Integer prompt_tokens;
    private Integer completion_tokens;
    private Integer total_tokens;

}
