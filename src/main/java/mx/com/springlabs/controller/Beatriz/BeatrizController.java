/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package mx.com.springlabs.controller.Beatriz;

import mx.com.springlabs.service.Beatriz.BeatrizService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/bety")
public class BeatrizController {
    @Autowired
    private BeatrizService beatrizService;
     
    @GetMapping("/gramm")
    public String grammar(@RequestParam(value = "texto", required = false) String frase){
    return beatrizService.grammar(frase);
   }
     @GetMapping("/tweet")
     public String tweet(@RequestParam(value = "texto", required = false) String tweet){
     return beatrizService.grammar(tweet);
     }
}
