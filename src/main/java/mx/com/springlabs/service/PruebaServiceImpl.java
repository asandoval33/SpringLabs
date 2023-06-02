package mx.com.springlabs.service;

import mx.com.springlabs.models.CompletionsRequestModel;
import mx.com.springlabs.repository.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

@Service
public class PruebaServiceImpl implements PruebaService {

    @Autowired
    OpenAIRepository openAIRepository;

    @Autowired
    PruebaRepository pruebaRepository;

    @Override
    public String peliculasAEmoji(String nombrePelicula) {
        CompletionsRequestModel crm = new CompletionsRequestModel();
        crm.setModel("text-davinci-003");
        crm.setPrompt("Convert movie titles into emoji.\n\nBack to the Future: 👨👴🚗🕒 \nBatman: 🤵🦇 \nTransformers: 🚗🤖 \n" + nombrePelicula + ":");
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
    public String guardarArchivo(@RequestParam MultipartFile file, String nombreArchivo) {
        return pruebaRepository.guardarArchivo(file, nombreArchivo);
    }

    @Override
    public String listarArchivos() {
        return pruebaRepository.listarArchivos();
    }

    public byte[] buscarArchivo(String nombreArchivo) {
        return pruebaRepository.buscarArchivo(nombreArchivo);
    }

}
