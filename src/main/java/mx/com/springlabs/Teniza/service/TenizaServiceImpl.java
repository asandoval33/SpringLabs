package mx.com.springlabs.Teniza.service;

//import mx.com.springlabs.Teniza.service.*;
import mx.com.springlabs.models.CompletionsRequestModel;
import mx.com.springlabs.repository.OpenAIRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class TenizaServiceImpl implements TenizaService {

    @Autowired
    OpenAIRepository openAIRepository;

 
    @Override
    public String grammar() {
          CompletionsRequestModel crm = new CompletionsRequestModel();
        crm.setModel("text-davinci-003");
        crm.setPrompt("Correct this to standard English:\\n\\nShe no went to the market.");
        crm.setTemperature(0.0);
        crm.setMax_tokens(60);
        crm.setTop_p(1.0);
        crm.setFrequency_penalty(0.0);
        crm.setPresence_penalty(0.0);
       // String[] stop = {"\n"};
        //crm.setStop(stop);
        return openAIRepository.ejecutaSolicitud(crm).getChoices()[0].getText();
    }
    @Override
    public String summarize() {
          CompletionsRequestModel crm = new CompletionsRequestModel();
        crm.setModel("text-davinci-003");
        crm.setPrompt("Summarize this for a second-grade student:\\n\\nJupiter is the fifth planet from the Sun and the largest in the Solar System. It is a gas giant with a mass one-thousandth that of the Sun, but two-and-a-half times that of all the other planets in the Solar System combined. Jupiter is one of the brightest objects visible to the naked eye in the night sky, and has been known to ancient civilizations since before recorded history. It is named after the Roman god Jupiter.[19] When viewed from Earth, Jupiter can be bright enough for its reflected light to cast visible shadows,[20] and is on average the third-brightest natural object in the night sky after the Moon and Venus.");
        crm.setTemperature(0.7);
        crm.setMax_tokens(64);
        crm.setTop_p(1.0);
        crm.setFrequency_penalty(0.0);
        crm.setPresence_penalty(0.0);
       // String[] stop = {"\n"};
        //crm.setStop(stop);
        return openAIRepository.ejecutaSolicitud(crm).getChoices()[0].getText();
    }
    
    @Override
    public String code() {
        CompletionsRequestModel crm = new CompletionsRequestModel();
        crm.setModel("text-davinci-003");
        crm.setPrompt("class Log:\\n    def __init__(self, path):\\n        dirname = os.path.dirname(path)\\n        os.makedirs(dirname, exist_ok=True)\\n        f = open(path, \\\"a+\\\")\\n\\n        # Check that the file is newline-terminated\\n        size = os.path.getsize(path)\\n        if size > 0:\\n            f.seek(size - 1)\\n            end = f.read(1)\\n            if end != \\\"\\\\n\\\":\\n                f.write(\\\"\\\\n\\\")\\n        self.f = f\\n        self.path = path\\n\\n    def log(self, event):\\n        event[\\\"_event_id\\\"] = str(uuid.uuid4())\\n        json.dump(event, self.f)\\n        self.f.write(\\\"\\\\n\\\")\\n\\n    def state(self):\\n        state = {\\\"complete\\\": set(), \\\"last\\\": None}\\n        for line in open(self.path):\\n            event = json.loads(line)\\n            if event[\\\"type\\\"] == \\\"submit\\\" and event[\\\"success\\\"]:\\n                state[\\\"complete\\\"].add(event[\\\"id\\\"])\\n                state[\\\"last\\\"] = event\\n        return state\\n\\n\\\"\\\"\\\"\\nHere's what the above class is doing, explained in a concise way:\\n1.\",\n" +
" ");
        crm.setTemperature(0.0);
        crm.setMax_tokens(150);
        crm.setTop_p(1.0);
        crm.setFrequency_penalty(0.0);
        crm.setPresence_penalty(0.0);
        String[] stop = {"\"\"\""};
        //crm.setStop(stop);
        return openAIRepository.ejecutaSolicitud(crm).getChoices()[0].getText();
    }
    @Override
    public String sql() {
        CompletionsRequestModel crm = new CompletionsRequestModel();
        crm.setModel("text-davinci-003");
        crm.setPrompt("Create a SQL request to find all users who live in California and have over 1000 credits:");
        crm.setTemperature(0.3);
        crm.setMax_tokens(60);
        crm.setTop_p(1.0);
        crm.setFrequency_penalty(0.0);
        crm.setPresence_penalty(0.0);
       // String[] stop = {"\n"};
        //crm.setStop(stop);
        return openAIRepository.ejecutaSolicitud(crm).getChoices()[0].getText();
    }
        @Override
        public String recipe() {
        CompletionsRequestModel crm = new CompletionsRequestModel();
        crm.setModel("text-davinci-003");
        crm.setPrompt("Write a recipe based on these ingredients and instructions:\\n\\nFrito Pie\\n\\nIngredients:\\nFritos\\nChili\\nShredded cheddar cheese\\nSweet white or red onions, diced small\\nSour cream\\n\\nInstructions:");
        crm.setTemperature(0.3);
        crm.setMax_tokens(120);
        crm.setTop_p(1.0);
        crm.setFrequency_penalty(0.0);
        crm.setPresence_penalty(0.0);
       // String[] stop = {"\n"};
        //crm.setStop(stop);
        return openAIRepository.ejecutaSolicitud(crm).getChoices()[0].getText();
    }
}

