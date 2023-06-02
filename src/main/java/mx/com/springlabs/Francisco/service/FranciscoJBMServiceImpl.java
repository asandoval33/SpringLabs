package mx.com.springlabs.Francisco.service;

import mx.com.springlabs.models.CompletionsRequestModel;
import mx.com.springlabs.repository.OpenAIRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class FranciscoJBMServiceImpl implements FranciscoJBMService {

    @Autowired
    OpenAIRepository openAIRepository;

    @Override
    public String testAPI(String textoEjemplo) {
        CompletionsRequestModel crm = new CompletionsRequestModel();
        crm.setModel("text-davinci-003");
        crm.setPrompt("Convert this text to a programmatic command:\n" + "\n" +
                        "Example: Ask Constance if we need some bread\n" +
                        "Output: send-msg `find constance` Do we need some bread?\n" + "\n" +
                        "Reach out to the ski store and figure out if I can get my skis fixed before I leave on Thursday" + textoEjemplo + ":");
        crm.setTemperature(0.8);
        crm.setMax_tokens(60);
        crm.setTop_p(1.0);
        crm.setFrequency_penalty(0.0);
        crm.setPresence_penalty(0.0);
        String[] stop = {"\n"};
        crm.setStop(stop);
        return openAIRepository.ejecutaSolicitud(crm).getChoices()[0].getText();
    }
}
