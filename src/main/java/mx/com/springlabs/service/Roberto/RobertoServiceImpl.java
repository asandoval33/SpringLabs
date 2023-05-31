/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package mx.com.springlabs.service.Roberto;

import mx.com.springlabs.models.CompletionsRequestModel;
import mx.com.springlabs.repository.OpenAIRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author LOLBO
 */
@Service
public class RobertoServiceImpl implements RobertoService {
    @Autowired
    OpenAIRepository openAIRepository;

    @Override
    public String datos(String sentencia) {
       CompletionsRequestModel crm = new CompletionsRequestModel();
        crm.setModel("text-davinci-003");
        crm.setPrompt("### Postgres SQL tables, with their properties:\n#\n# Employee(id, name, department_id)\n# Department(id, name, address)\n# Salary_Payments(id, employee_id, amount, date)\n#\n### A query to list the names of the departments which employed more than 10 employees in the last 3 months\nSELECT" + sentencia);
        crm.setTemperature(0.0);
        crm.setMax_tokens(150);
        crm.setTop_p(1.0);
        crm.setFrequency_penalty(0.0);
        crm.setPresence_penalty(0.0);
        String[] stop = {"#", ";"};
        crm.setStop(stop);
        return openAIRepository.ejecutaSolicitud(crm).getChoices()[0].getText();
       
       //Ejercicio 2
        /*CompletionsRequestModel crm = new CompletionsRequestModel();
        crm.setModel("text-davinci-003");
        crm.setPrompt("A neutron star is the collapsed core of a massive supergiant star, which had a total mass of between 10 and 25 solar masses, possibly more if the star was especially metal-rich.[1] Neutron stars are the smallest and densest stellar objects, excluding black holes and hypothetical white holes, quark stars, and strange stars.[2] Neutron stars have a radius on the order of 10 kilometres (6.2 mi) and a mass of about 1.4 solar masses.[3] They result from the supernova explosion of a massive star, combined with gravitational collapse, that compresses the core past white dwarf star density to that of atomic nuclei.\\n\\nTl;dr" + sentencia);
        crm.setTemperature(0.7);
        crm.setMax_tokens(60);
        crm.setTop_p(1.0);
        crm.setFrequency_penalty(0.0);
        crm.setPresence_penalty(1.0);
        return openAIRepository.ejecutaSolicitud(crm).getChoices()[0].getText();*/
        
        //Ejercicio 3
        /*CompletionsRequestModel crm = new CompletionsRequestModel();
        crm.setModel("text-davinci-003");
        crm.setPrompt("# Python 3.7\\n \\ndef randomly_split_dataset(folder, filename, split_ratio=[0.8, 0.2]):\\n    df = pd.read_json(folder + filename, lines=True)\\n    train_name, test_name = \\\"train.jsonl\\\", \\\"test.jsonl\\\"\\n    df_train, df_test = train_test_split(df, test_size=split_ratio[1], random_state=42)\\n    df_train.to_json(folder + train_name, orient='records', lines=True)\\n    df_test.to_json(folder + test_name, orient='records', lines=True)\\nrandomly_split_dataset('finetune_data/', 'dataset.jsonl')\\n    \\n# An elaborate, high quality docstring for the above function:\\n\\\"\\\"\\\"\"," + sentencia);
        crm.setTemperature(0.0);
        crm.setMax_tokens(150);
        crm.setTop_p(1.0);
        crm.setFrequency_penalty(0.0);
        crm.setPresence_penalty(0.0);
        String[] stop = {"#", ";"};
        crm.setStop(stop);
        return openAIRepository.ejecutaSolicitud(crm).getChoices()[0].getText();*/
        
        //Ejercicio 4
        /*CompletionsRequestModel crm = new CompletionsRequestModel();
        crm.setModel("text-davinci-003");
        crm.setPrompt("What are 5 key points I should know when studying Ancient Rome?" + sentencia);
        crm.setTemperature(0.3);
        crm.setMax_tokens(150);
        crm.setTop_p(1.0);
        crm.setFrequency_penalty(0.0);
        crm.setPresence_penalty(0.0);
        return openAIRepository.ejecutaSolicitud(crm).getChoices()[0].getText();*/
    }
       
}
