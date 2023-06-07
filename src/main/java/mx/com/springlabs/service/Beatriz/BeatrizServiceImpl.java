/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package mx.com.springlabs.service.Beatriz;

import mx.com.springlabs.models.CompletionsRequestModel;
import mx.com.springlabs.repository.OpenAIRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class BeatrizServiceImpl implements BeatrizService{
    @Autowired
    OpenAIRepository openAIRepository;
    
    @Override
    public String grammar(String frase) {
        CompletionsRequestModel crm = new CompletionsRequestModel();
        crm.setModel("text-davinci-003");
        crm.setPrompt("Correct this to standard English:\\n\\nShe no went to the market.");
        crm.setTemperature(0.0);
        crm.setMax_tokens(60);
        crm.setTop_p(1.0);
        crm.setFrequency_penalty(0.0);
        crm.setPresence_penalty(0.0);
     
        return openAIRepository.ejecutaSolicitud(crm).getChoices()[0].getText();
    }
    
    @Override
    public String tweet(String tweet) {
        CompletionsRequestModel crm = new CompletionsRequestModel();
        crm.setModel("text-davinci-003");
        crm.setPrompt("Decide whether a Tweet's sentiment is positive, neutral, or negative.\\n\\nTweet: \\\"I loved the new Batman movie!\\\"\\nSentiment:");
        crm.setTemperature(0.0);
        crm.setMax_tokens(60);
        crm.setTop_p(1.0);
        crm.setFrequency_penalty(0.5);
        crm.setPresence_penalty(0.0);
     
        return openAIRepository.ejecutaSolicitud(crm).getChoices()[0].getText();
    }
}
