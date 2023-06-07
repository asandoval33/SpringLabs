/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package mx.com.springlabs.juanjose.service;
import mx.com.springlabs.models.CompletionsRequestModel;
import mx.com.springlabs.repository.OpenAIRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
/**
 *
 * @author juanj
 */
@Service
public class ServiceImplJuanJose implements ServiceJuan {
    @Autowired
    OpenAIRepository openAIRepository;

    @Override
    public String conteston(String para, String msg) {
        CompletionsRequestModel crm = new CompletionsRequestModel();
        crm.setModel("text-davinci-003");
        crm.setPrompt("Responde al mensaje de texto de "+para+" que es el siguiente: "+msg+"/n");
        crm.setTemperature(1.0);
        crm.setMax_tokens(256);
        crm.setTop_p(1.0);
        crm.setFrequency_penalty(0.0);
        crm.setPresence_penalty(0.0);
        return openAIRepository.ejecutaSolicitud(crm).getChoices()[0].getText();
    }
    
    @Override
    public String naturalLanguage() {
        CompletionsRequestModel crm = new CompletionsRequestModel();
        crm.setModel("text-davinci-003");
        crm.setPrompt("\"\"\"\nUtil exposes the following:\n\nutil.stripe() -> authenticates & returns the stripe module; usable as stripe.Charge.create etc\n\"\"\"\nimport util\n\"\"\"\nCreate a Stripe token using the users credit card: 5555-4444-3333-2222, expiration date 12 / 28, cvc 521\n\"\"\"");
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
    public String productNameGenerator() {
        CompletionsRequestModel crm = new CompletionsRequestModel();
        crm.setModel("text-davinci-003");
        crm.setPrompt("Product description: A home milkshake maker\\nSeed words: fast, healthy, compact.\\nProduct names: HomeShaker, Fit Shaker, QuickShake, Shake Maker\\n\\nProduct description: A pair of shoes that can fit any foot size.\\nSeed words: adaptable, fit, omni-fit.");
        crm.setTemperature(0.8);
        crm.setMax_tokens(60);
        crm.setTop_p(1.0);
        crm.setFrequency_penalty(0.0);
        crm.setPresence_penalty(0.0);
        return openAIRepository.ejecutaSolicitud(crm).getChoices()[0].getText();
    }
    
    @Override
    public String moodColor() {
        CompletionsRequestModel crm = new CompletionsRequestModel();
        crm.setModel("text-davinci-003");
        crm.setPrompt("The CSS code for a color like a blue sky at dusk:\\n\\nbackground-color: #");
        crm.setTemperature(0.0);
        crm.setMax_tokens(64);
        crm.setTop_p(1.0);
        crm.setFrequency_penalty(0.0);
        crm.setPresence_penalty(0.0);
        return openAIRepository.ejecutaSolicitud(crm).getChoices()[0].getText();
    }
    
    @Override
    public String restaurantReviewCreator() {
        CompletionsRequestModel crm = new CompletionsRequestModel();
        crm.setModel("text-davinci-003");
        crm.setPrompt("Write a restaurant review based on these notes:\\n\\nName: The Blue Wharf\\nLobster great, noisy, service polite, prices good.\\n\\nReview:");
        crm.setTemperature(0.5);
        crm.setMax_tokens(64);
        crm.setTop_p(1.0);
        crm.setFrequency_penalty(0.0);
        crm.setPresence_penalty(0.0);
        return openAIRepository.ejecutaSolicitud(crm).getChoices()[0].getText();
    }
}
