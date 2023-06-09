package mx.com.springlabs.emiliano.service;

import mx.com.springlabs.models.CompletionsRequestModel;
import mx.com.springlabs.repository.OpenAIRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PruebaServiceImpl1 implements PruebaService1 {

    @Autowired
    OpenAIRepository openAIRepository;

    @Override
    //Ejemplo Profe:
    public String data(String dataName) {
        CompletionsRequestModel crm = new CompletionsRequestModel();
        crm.setModel("text-davinci-003");
        crm.setPrompt("Convert movie titles into emoji.\n\nBack to the Future: 👨👴🚗🕒 \nBatman: 🤵🦇 \nTransformers: 🚗🤖 \n" + dataName + ":");
        crm.setTemperature(0.8);
        crm.setMax_tokens(60);
        crm.setTop_p(1.0);
        crm.setFrequency_penalty(0.0);
        crm.setPresence_penalty(0.0);
        String[] stop = {"\n"};
        crm.setStop(stop);
        return openAIRepository.ejecutaSolicitud(crm).getChoices()[0].getText();
    }
    
    //Ejercicio 9
    public String data2(String dataName) {
        CompletionsRequestModel crm = new CompletionsRequestModel();
        crm.setModel("text-davinci-003");
        crm.setPrompt("Translate this into 1. French, 2. Spanish and 3. Japanese:\n\n" + dataName + "\n\n1.");
        crm.setTemperature(0.3);
        crm.setMax_tokens(100);
        crm.setTop_p(1.0);
        crm.setFrequency_penalty(0.0);
        crm.setPresence_penalty(0.0);
        return openAIRepository.ejecutaSolicitud(crm).getChoices()[0].getText();
    }
    
    //Ejercicio 19
    public String data3(String dataName) {
        CompletionsRequestModel crm = new CompletionsRequestModel();
        crm.setModel("text-davinci-003");
        crm.setPrompt("Write a creative ad for the following product to run on Facebook aimed at parents:\n\nProduct: " + dataName);
        crm.setTemperature(0.5);
        crm.setMax_tokens(100);
        crm.setTop_p(1.0);
        crm.setFrequency_penalty(0.0);
        crm.setPresence_penalty(0.0);
        return openAIRepository.ejecutaSolicitud(crm).getChoices()[0].getText();
    }
    
    //Ejercicio 32
    public String data4(String dataName) {
        CompletionsRequestModel crm = new CompletionsRequestModel();
        crm.setModel("text-davinci-003");
        crm.setPrompt("You: " + dataName);
        crm.setTemperature(0.5);
        crm.setMax_tokens(60);
        crm.setTop_p(1.0);
        crm.setFrequency_penalty(0.5);
        crm.setPresence_penalty(0.0);
        String[] stop = {"You:"};
        crm.setStop(stop);
        return openAIRepository.ejecutaSolicitud(crm).getChoices()[0].getText();
    }
    
    //Ejercicio 45
    public String data5(String dataName) {
        CompletionsRequestModel crm = new CompletionsRequestModel();
        crm.setModel("text-davinci-003");
        crm.setPrompt("Create a numbered list of turn-by-turn directions from this text: " + dataName);    
        crm.setTemperature(0.3);
        crm.setMax_tokens(64);
        crm.setTop_p(1.0);
        crm.setFrequency_penalty(0.0);
        crm.setPresence_penalty(0.0);
        return openAIRepository.ejecutaSolicitud(crm).getChoices()[0].getText();
    }
    
    //Idea: Listar ingredientes de un platillo.
    public String data6(String dataName) {
        CompletionsRequestModel crm = new CompletionsRequestModel();
        crm.setModel("text-davinci-003");
        crm.setPrompt("Enlista solo ingredientes (con sus respectivas porciones) de " + dataName);    
        crm.setTemperature(0.3);
        crm.setMax_tokens(64);
        crm.setTop_p(1.0);
        crm.setFrequency_penalty(0.0);
        crm.setPresence_penalty(0.0);
        return openAIRepository.ejecutaSolicitud(crm).getChoices()[0].getText();
    }
}
