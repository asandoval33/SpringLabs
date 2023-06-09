/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package mx.com.springlabs.paola.service;

import mx.com.springlabs.models.CompletionsRequestModel;
import mx.com.springlabs.repository.OpenAIRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PaolaServiceImpl implements PaolaService {

    @Autowired
    OpenAIRepository openAIRepository;

    //EJERCICIO 9: Parse unstructured data
    @Override
    public String parseData(String nombreDatos) {
        CompletionsRequestModel crm = new CompletionsRequestModel();
        crm.setModel("text-davinci-003");
        crm.setPrompt("A table summarizing the fruits from Goocrux:\\n\\nThere are many fruits that were found on the recently discovered planet Goocrux. There are neoskizzles that grow there, which are purple and taste like candy. There are also loheckles, which are a grayish blue fruit and are very tart, a little bit like a lemon. Pounits are a bright green color and are more savory than sweet. There are also plenty of loopnovas which are a neon pink flavor and taste like cotton candy. Finally, there are fruits called glowls, which have a very sour and bitter taste which is acidic and caustic, and a pale orange tinge to them.\\n\\n| Fruit | Color | Flavor |" + nombreDatos + "|");
        crm.setTemperature(0.0);
        crm.setMax_tokens(100);
        crm.setTop_p(1.0);
        crm.setFrequency_penalty(0.0);
        crm.setPresence_penalty(0.0);
        return openAIRepository.ejecutaSolicitud(crm).getChoices()[0].getText();
    }

    //EJERCICIO 22: Python bug fixer
    @Override
    public String pythonFixer(String nombreDatos) {
        CompletionsRequestModel crm = new CompletionsRequestModel();
        crm.setModel("text-davinci-003");
        crm.setPrompt("### Buggy Python" + nombreDatos + "### Fixed Python");
        crm.setTemperature(0.0);
        crm.setMax_tokens(182);
        crm.setTop_p(1.0);
        crm.setFrequency_penalty(0.0);
        crm.setPresence_penalty(0.0);
        String[] stop = {"###"};
        crm.setStop(stop);
        return openAIRepository.ejecutaSolicitud(crm).getChoices()[0].getText();
    }

    //EJERCICIO 35: Analogy maker
    @Override
    public String analogyMaker(String nombreDatos) {
        CompletionsRequestModel crm = new CompletionsRequestModel();
        crm.setModel("text-davinci-003");
        crm.setPrompt("Create an analogy for this phrase:\\n\\n" + nombreDatos + ":");
        crm.setTemperature(0.5);
        crm.setMax_tokens(60);
        crm.setTop_p(1.0);
        crm.setFrequency_penalty(0.0);
        crm.setPresence_penalty(0.0);
        return openAIRepository.ejecutaSolicitud(crm).getChoices()[0].getText();
    }

    //EJERCICIO 48: Interview questions
    @Override
    public String interviewQuestions(String nombreDatos) {
        CompletionsRequestModel crm = new CompletionsRequestModel();
        crm.setModel("text-davinci-003");
        crm.setPrompt("" + nombreDatos + "");
        crm.setTemperature(0.5);
        crm.setMax_tokens(500);
        crm.setTop_p(1.0);
        crm.setFrequency_penalty(0.0);
        crm.setPresence_penalty(0.0);
        return openAIRepository.ejecutaSolicitud(crm).getChoices()[0].getText();
    }
    
    //EJERCICIO: Generador de letra de una cancion
    @Override
    public String letraCancion(String nombreDatos) {
        CompletionsRequestModel crm = new CompletionsRequestModel();
        crm.setModel("text-davinci-003");
        crm.setPrompt("Genera la letra de una cancion con la siguientes palabras:\n" + nombreDatos + "");
        crm.setTemperature(1.0);
        crm.setMax_tokens(800);
        crm.setTop_p(1.0);
        crm.setFrequency_penalty(0.0);
        crm.setPresence_penalty(0.0);
        return openAIRepository.ejecutaSolicitud(crm).getChoices()[0].getText();
        //Muestra la lyrica de la siguiente cancion:
    }

}
