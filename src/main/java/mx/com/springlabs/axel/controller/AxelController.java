/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package mx.com.springlabs.axel.controller;


import mx.com.springlabs.axel.services.AxelServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/axel")

public class AxelController {
    
    @Autowired
    private AxelServices axelService;

    @GetMapping("/Python_to_natural_language/{language}")
    public String datos(@PathVariable("language") String language) {
        return axelService.language(language);
    }
    
    @GetMapping("/JavaScript_helper_chatbot/{chatbot}")
    public String chatbot(@PathVariable("chatbot") String chatbot) {
        return axelService.chatbot(chatbot);
    }
    
    @GetMapping("/Micro_horror_story_creator/{horror}")
    public String horror(@PathVariable("horror") String horror) {
        return axelService.horror(horror);
    }
    
    //Python_to_natural_language/
    //JavaScript_helper_chatbot
    //Micro_horror_story_creator
}
