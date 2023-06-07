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
    public String testAPI1(String textoEjemplo) {
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
    
    @Override
    public String testAPI2(String textoEjemplo) {
        CompletionsRequestModel crm = new CompletionsRequestModel();
        crm.setModel("text-davinci-003");
        crm.setPrompt("Q: Who is Batman?\n" +
                      "A: Batman is a fictional comic book character.\n" +
                      "\n" +
                      "Q: What is torsalplexity?\n" +
                      "A: ?\n" +
                      "\n" +
                      "Q: What is Devz9?\n" +
                      "A: ?\n" +
                      "\n" +
                      "Q: Who is George Lucas?\n" +
                      "A: George Lucas is American film director and producer famous for creating Star Wars.\n" +
                      "\n" +
                      "Q: What is the capital of California?\n" +
                      "A: Sacramento.\n" +
                      "\n" +
                      "Q: What orbits the Earth?\n" +
                      "A: The Moon.\n" +
                      "\n" +
                      "Q: Who is Fred Rickerson?\n" +
                      "A: ?\n" +
                      "\n" +
                      "Q: What is an atom?\n" +
                      "A: An atom is a tiny particle that makes up everything.\n" +
                      "\n" +
                      "Q: Who is Alvan Muntz?\n" +
                      "A: ?\n" +
                      "\n" +
                      "Q: What is Kozar-09?\n" +
                      "A: ?\n" +
                      "\n" +
                      "Q: How many moons does Mars have?\n" +
                      "A: Two, Phobos and Deimos.\n" +
                      "\n" +
                      "Q: What's a language model?\n" +
                      "A:" + textoEjemplo + ":");
        crm.setTemperature(0.0);
        crm.setMax_tokens(60);
        crm.setTop_p(1.0);
        crm.setFrequency_penalty(0.0);
        crm.setPresence_penalty(0.0);
        String[] stop = {"\n"};
        crm.setStop(stop);
        return openAIRepository.ejecutaSolicitud(crm).getChoices()[0].getText();
    }
    
    @Override
    public String testAPI3(String textoEjemplo) {
        CompletionsRequestModel crm = new CompletionsRequestModel();
        crm.setModel("text-davinci-003");
        crm.setPrompt("#JavaScript to Python:\n" +
                      "JavaScript: \n" +
                      "dogs = [\"bill\", \"joe\", \"carl\"]\n" +
                      "car = []\n" +
                      "dogs.forEach((dog) {\n" +
                      "    car.push(dog);\n" +
                      "});\n" +
                      "\n" +
                      "Python:" + textoEjemplo + ":");
        crm.setTemperature(0.8);
        crm.setMax_tokens(60);
        crm.setTop_p(1.0);
        crm.setFrequency_penalty(0.0);
        crm.setPresence_penalty(0.0);
        String[] stop = {"\n"};
        crm.setStop(stop);
        return openAIRepository.ejecutaSolicitud(crm).getChoices()[0].getText();
    }
    
    @Override
    public String testAPI4(String textoEjemplo) {
        CompletionsRequestModel crm = new CompletionsRequestModel();
        crm.setModel("text-davinci-003");
        crm.setPrompt("Marv is a chatbot that reluctantly answers questions with sarcastic responses:\n" +
                      "\n" +
                      "You: How many pounds are in a kilogram?\n" +
                      "Marv: This again? There are 2.2 pounds in a kilogram. Please make a note of this.\n" +
                      "You: What does HTML stand for?\n" +
                      "Marv: Was Google too busy? Hypertext Markup Language. The T is for try to ask better questions in the future.\n" +
                      "You: When did the first airplane fly?\n" +
                      "Marv: On December 17, 1903, Wilbur and Orville Wright made the first flights. I wish they’d come and take me away.\n" +
                      "You: What is the meaning of life?\n" +
                      "Marv: I’m not sure. I’ll ask my friend Google.\n" +
                      "You: What time is it?\n" +
                      "Marv:" + textoEjemplo + ":");
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
