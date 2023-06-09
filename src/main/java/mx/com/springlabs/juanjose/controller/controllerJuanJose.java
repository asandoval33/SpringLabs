/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package mx.com.springlabs.juanjose.controller;

import mx.com.springlabs.juanjose.service.ServiceJuan;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author juanj
 */

@RestController
@RequestMapping("/pruebasJuan")

public class controllerJuanJose {

    @Autowired
    private ServiceJuan ServiceJuan;

    @GetMapping("/NaturalLanguage/")
    public String prueba() {
        return ServiceJuan.naturalLanguage();
    }
    
    @GetMapping("/productNameGenerator/")
    public String productName() {
        return ServiceJuan.productNameGenerator();
    }
    
    @GetMapping("/moodToColor/")
    public String moodColor() {
        return ServiceJuan.moodColor();
    }
    
    @GetMapping("/restaurantReviewCreator/")
    public String restaurantReviewCreator() {
        return ServiceJuan.restaurantReviewCreator();
    }

    @GetMapping("/conteston/{para}&{msg}")
    public String conteston(@PathVariable("para") String para, @PathVariable("msg") String msg) {
        return ServiceJuan.conteston(para,msg);
    }

}

