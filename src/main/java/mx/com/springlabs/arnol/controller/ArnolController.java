/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package mx.com.springlabs.arnol.controller;
import java.io.IOException;
import mx.com.springlabs.arnol.service.arnolServiceInterface;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;
/**
 *
 * @author arnol
 */
@RestController
@RequestMapping("/arnol")
public class ArnolController {
    @Autowired
    private arnolServiceInterface arnolserviceinterface;
    
    @GetMapping("/natural_language_to_OpenAI_API/{datos}")
    public String natural_language_to_OpenAI_API(@PathVariable("datos") String datos) {
        return arnolserviceinterface.natural_language_to_OpenAI_API(datos);
        
    }
    
    @GetMapping("/keywords/{datos}")
    public String keywords(@PathVariable("datos") String datos) {
        return arnolserviceinterface.keywords(datos);
        
    }
    @GetMapping("/extractContactInformation/{datos}")
    public String extractContactInformation(@PathVariable("datos") String datos) {
        return arnolserviceinterface.extractContactInformation(datos);
        
    }
    @GetMapping("/chat/{datos}")
    public String chat(@PathVariable("datos") String datos) {
        return arnolserviceinterface.chat(datos);
        
    }
    @GetMapping("/eslogan/{datos}")
    public String eslogan(@PathVariable("datos") String datos) {
        return arnolserviceinterface.eslogan(datos);
        
    }
    
    
}

/* REVISION: 
            "    " 
*/