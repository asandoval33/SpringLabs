package mx.com.springlabs.IsraelR.service;

import mx.com.springlabs.models.CompletionsRequestModel;
import mx.com.springlabs.repository.OpenAIRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class IsraelRServiceImpl implements IsraelRService {

    @Autowired
    OpenAIRepository openAIRepository;
    
    
    @Override
    public String classification() {
        CompletionsRequestModel crm = new CompletionsRequestModel();
        crm.setModel("text-davinci-003");
        crm.setPrompt("The following is a list of companies and the categories they fall into:\n\nApple, Facebook, Fedex\n\nApple\nCategory:");
        crm.setTemperature(0.0);
        crm.setMax_tokens(64);
        crm.setTop_p(1.0);
        crm.setFrequency_penalty(0.0);
        crm.setPresence_penalty(0.0);
       // String[] stop = {"\n"};
       // crm.setStop(stop);
        return openAIRepository.ejecutaSolicitud(crm).getChoices()[0].getText();
    }
    
    @Override
    public String spreadsheet_creator() {
        CompletionsRequestModel crm = new CompletionsRequestModel();
        crm.setModel("text-davinci-003");
        crm.setPrompt("A two-column spreadsheet of top science fiction movies and the year of release:\n\nTitle |  Year of release");
        crm.setTemperature(0.5);
        crm.setMax_tokens(60);
        crm.setTop_p(1.0);
        crm.setFrequency_penalty(0.0);
        crm.setPresence_penalty(0.0);
       // String[] stop = {"\n"};
       // crm.setStop(stop);
        return openAIRepository.ejecutaSolicitud(crm).getChoices()[0].getText();
    }
    
    @Override
    public String javaScript_one_line() {
        CompletionsRequestModel crm = new CompletionsRequestModel();
        crm.setModel("text-davinci-003");
        crm.setPrompt("Use list comprehension to convert this into one line of JavaScript:\n\ndogs.forEach((dog) => {\n    car.push(dog);\n});\n\nJavaScript one line version:");
        crm.setTemperature(0.0);
        crm.setMax_tokens(60);
        crm.setTop_p(1.0);
        crm.setFrequency_penalty(0.0);
        crm.setPresence_penalty(0.0);
        String[] stop = {";"};
        crm.setStop(stop);
        return openAIRepository.ejecutaSolicitud(crm).getChoices()[0].getText();
    }
    
    
}
