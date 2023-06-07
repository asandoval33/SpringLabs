package mx.com.springlabs.Salgado.service;

import javax.annotation.Resource;
import mx.com.springlabs.models.CompletionsRequestModel;
import mx.com.springlabs.models.CompletionsResponseModel;
import mx.com.springlabs.repository.OpenAIRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class SalgadoServiceImpl implements SalgadoService {

    @Autowired
    OpenAIRepository openAIRepository;

    @Override
    public CompletionsResponseModel complexity(CompletionsRequestModel model) {
        CompletionsResponseModel valor = openAIRepository.ejecutaSolicitud(model);
        return openAIRepository.ejecutaSolicitud(model);
    }

    @Override
    public String complex(String frase) {
        CompletionsRequestModel crm = new CompletionsRequestModel();
        crm.setModel("text-davinci-003");
        crm.setPrompt("def foo(n, k):\\naccum = 0\\nfor i in range(n):\\n    for l in range(k):\\n        accum += i\\nreturn accum\\n\\\"\\\"\\\"\\nThe time complexity of this function is");
        crm.setTemperature(0.0);
        crm.setMax_tokens(64);
        crm.setTop_p(1.0);
        crm.setFrequency_penalty(0.0);
        crm.setPresence_penalty(0.0);
        String[] stop = {"\n"};
        crm.setStop(stop);
        return openAIRepository.ejecutaSolicitud(crm).getChoices()[0].getText();
    }

    @Override
    public String book(String nombreLibro) {
        CompletionsRequestModel crm = new CompletionsRequestModel();
        crm.setModel("text-davinci-003");
        crm.setPrompt("List 10 " + nombreLibro + " books:");
        crm.setTemperature(0.5);
        crm.setMax_tokens(200);
        crm.setTop_p(1.0);
        crm.setFrequency_penalty(0.52);
        crm.setPresence_penalty(0.5);
        String[] stop = {"11."};
        crm.setStop(stop);
        return openAIRepository.ejecutaSolicitud(crm).getChoices()[0].getText();
    }
    
    @Override
    public String nota(String nota) {
        CompletionsRequestModel crm = new CompletionsRequestModel();
        crm.setModel("text-davinci-003");
        crm.setPrompt("Convert my short hand into a first-hand account of the meeting:\\n\\nTom: Profits up 50%\\nJane:"
                + " New servers are online\\nKjel: Need more time to fix software\\nJane: Happy to help\\nParkman: "
                + "Beta testing almost done\n" + "    ");
        crm.setTemperature(0.0);
        crm.setMax_tokens(64);
        crm.setTop_p(1.0);
        crm.setFrequency_penalty(0.0);
        crm.setPresence_penalty(0.0);
        return openAIRepository.ejecutaSolicitud(crm).getChoices()[0].getText();
    }
}
