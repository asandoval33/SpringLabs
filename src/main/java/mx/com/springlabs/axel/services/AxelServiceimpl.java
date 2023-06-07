/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package mx.com.springlabs.axel.services;

import mx.com.springlabs.models.CompletionsRequestModel;
import mx.com.springlabs.repository.OpenAIRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author Axel Macpias
 */

@Service
public class AxelServiceimpl implements AxelServices{
    
    @Autowired
    OpenAIRepository openAIRepository;
    
    //Ejercicio 11 Python to natural language
    @Override
    public String language(String language) {
        CompletionsRequestModel crm = new CompletionsRequestModel();
        crm.setModel("text-davinci-003");
        crm.setPrompt("# Python 3 \ndef remove_common_prefix(x, prefix, ws_prefix): \n    x[\"completion\"] = x[\"completion\"].str[len(prefix) :] \n    if ws_prefix: \n        # keep the single whitespace as prefix \n        x[\"completion\"] = \" \" + x[\"completion\"] \nreturn x \n\n# Explanation of what the code does\n\n#" + language + ":");
        crm.setTemperature(0.0);
        crm.setMax_tokens(150);
        crm.setTop_p(1.0);
        crm.setFrequency_penalty(0.0);
        crm.setPresence_penalty(0.0);
       
       
        return openAIRepository.ejecutaSolicitud(crm).getChoices()[0].getText();
    }
    
    //Ejercicio 24 JavaScript helper chatbot
    @Override
    public String chatbot(String chatbot) {
        CompletionsRequestModel crm = new CompletionsRequestModel();
        crm.setModel("text-davinci-003");
        crm.setPrompt("You: How do I combine arrays?\nJavaScript chatbot: You can use the concat() method.\nYou: How do you make an alert appear after 10 seconds?\nJavaScript chatbot" + chatbot + ":");
        crm.setTemperature(0.0);
        crm.setMax_tokens(150);
        crm.setTop_p(1.0);
        crm.setFrequency_penalty(0.5);
        crm.setPresence_penalty(0.0);
        String[] stop = {"You:"};
        crm.setStop(stop);
       
        return openAIRepository.ejecutaSolicitud(crm).getChoices()[0].getText();
    }
    
    
     //Ejercicio 37 Micro_horror_story_creator
    @Override
    public String horror(String horror) {
        CompletionsRequestModel crm = new CompletionsRequestModel();
        crm.setModel("text-davinci-003");
        crm.setPrompt("Topic: Breakfast\nTwo-Sentence Horror Story: He always stops crying when I pour the milk on his cereal. I just have to remember not to let him see his face on the carton.\n    \nTopic: Wind\nTwo-Sentence Horror Story:" + horror + ":");
        crm.setTemperature(0.8);
        crm.setMax_tokens(60);
        crm.setTop_p(1.0);
        crm.setFrequency_penalty(0.5);
        crm.setPresence_penalty(0.0);
       
       
        return openAIRepository.ejecutaSolicitud(crm).getChoices()[0].getText();
    }
    
    
    
    
   
}
