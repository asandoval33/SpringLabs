/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package mx.com.springlabs.arnol.service;

import mx.com.springlabs.models.CompletionsRequestModel;
import mx.com.springlabs.repository.OpenAIRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author arnol
 */
@Service
public class arnolService implements arnolServiceInterface {

    @Autowired
    OpenAIRepository openAIRepository;
    
    @Override
    public String natural_language_to_OpenAI_API(String datos) {
        CompletionsRequestModel crm = new CompletionsRequestModel();
        
        crm.setModel("text-davinci-003");
        crm.setPrompt("\\\"\\\"\\\"\\nUtil exposes the following:\\nutil.openai() -> authenticates & returns the openai module, which has the following functions:\\nopenai.Completion.create(\\n    prompt=\\\"<my prompt>\\\", # The prompt to start completing from\\n    max_tokens=123, # The max number of tokens to generate\\n    temperature=1.0 # A measure of randomness\\n    echo=True, # Whether to return the prompt in addition to the generated completion\\n)\\n\\\"\\\"\\\"\\nimport util\\n\\\"\\\"\\\"\\nCreate an OpenAI completion starting from the prompt \\\"Once upon an AI\\\", no more than 5 tokens. Does not include the prompt.\\n\\\"\\\"\\\"\\n" + datos + ":");
        crm.setTemperature(0.0);
        crm.setMax_tokens(100);
        crm.setTop_p(1.0);
        crm.setFrequency_penalty(0.0);
        crm.setPresence_penalty(0.0);
        String[] stop = {"\"\"\""};
        crm.setStop(stop);
       
        return openAIRepository.ejecutaSolicitud(crm).getChoices()[0].getText();
    }
    
    @Override
    public String keywords(String datos) {
        CompletionsRequestModel crm = new CompletionsRequestModel();
        
        crm.setModel("text-davinci-003");
        crm.setPrompt("Extract keywords from this text:\n\nBlack-on-black ware is a 20th- and 21st-century pottery tradition developed by the Puebloan Native American ceramic artists in Northern New Mexico. Traditional reduction-fired blackware has been made for centuries by pueblo artists. Black-on-black ware of the past century is produced with a smooth surface, with the designs applied through selective burnishing or the application of refractory slip. Another style involves carving or incising designs and selectively polishing the raised areas. For generations several families from Kha'po Owingeh and P'ohwhóge Owingeh pueblos have been making black-on-black ware with the techniques passed down from matriarch potters. Artists from other pueblos have also produced black-on-black ware. Several contemporary artists have created works honoring the pottery of their ancestors." + datos + ":");
        crm.setTemperature(0.5);
        crm.setMax_tokens(60);
        crm.setTop_p(1.0);
        crm.setFrequency_penalty(0.8);
        crm.setPresence_penalty(0.0);
      
      
        return openAIRepository.ejecutaSolicitud(crm).getChoices()[0].getText();
    }
    
    @Override
    public String extractContactInformation(String datos) {
        CompletionsRequestModel crm = new CompletionsRequestModel();
        
        crm.setModel("text-davinci-003");
        crm.setPrompt("Extract the name and mailing address from this email:\n\nDear Kelly,\n\nIt was great to talk to you at the seminar. I thought Jane's talk was quite good.\n\nThank you for the book. Here's my address 2111 Ash Lane, Crestview CA 92002\n\nBest,\n\nMaya\n\nName:" + datos + ":");
        crm.setTemperature(0.0);
        crm.setMax_tokens(64);
        crm.setTop_p(1.0);
        crm.setFrequency_penalty(0.0);
        crm.setPresence_penalty(0.0);
      
      
        return openAIRepository.ejecutaSolicitud(crm).getChoices()[0].getText();
    }
    
    @Override
    public String chat(String datos) {
        CompletionsRequestModel crm = new CompletionsRequestModel();
        
        crm.setModel("text-davinci-003");
        crm.setPrompt("The following is a conversation with an AI assistant. The assistant is helpful, creative, clever, and very friendly.\n\nHuman: Hello, who are you?\nAI: I am an AI created by OpenAI. How can I help you today?\nHuman: I'd like to cancel my subscription.\nAI:" + datos + ":");
        crm.setTemperature(0.9);
        crm.setMax_tokens(150);
        crm.setTop_p(1.0);
        crm.setFrequency_penalty(0.0);
        crm.setPresence_penalty(0.6);
        String[] stop = {" Human:", " AI:"};
        crm.setStop(stop);
      
        return openAIRepository.ejecutaSolicitud(crm).getChoices()[0].getText();
    }
    
}
