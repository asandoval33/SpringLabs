/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package mx.com.springlabs.arnol.controller;
import mx.com.springlabs.arnol.service.arnolServiceInterface;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
/**
 *
 * @author arnol
 */
@RestController
@RequestMapping("/arnol")
public class ArnolController {
    @Autowired
    private arnolServiceInterface arnolserviceinterface;
    
    @GetMapping("/Natural_language_to_OpenAI_API/{datos}")
    /*
    Natural_language_to_OpenAI_API
    Keywords
    Extract_contact_information
    Chat

    */
    public String prueba(@PathVariable("datos") String nombrePelicula) {
        return arnolserviceinterface.natural_language_to_OpenAI_API(nombrePelicula);
        
    }
    

}
