/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package mx.com.springlabs.emiliano.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import mx.com.springlabs.emiliano.service.PruebaService1;
/**
 *
 * @author Emiliano
 */
@RestController
@RequestMapping("/emiliano")
public class EmilianoController {
    @Autowired
    private PruebaService1 pruebaService;

    @GetMapping("/Turn_by_turn_directions/{dataName}")
    public String data(@PathVariable("dataName") String dataName) {
        return pruebaService.data(dataName);
    }
    
    //Ejemplo: pelicula_emoji
    //EJERCICIO 6: English_to_other_languages
    //EJERCICIO 19: Ad_from_product_description
    //EJERCICIO 32: Friend_chat
    //EJERCICIO 45: Turn_by_turn_directions
}
