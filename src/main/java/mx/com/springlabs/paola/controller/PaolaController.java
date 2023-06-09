/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package mx.com.springlabs.paola.controller;

import mx.com.springlabs.paola.service.PaolaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/paola")
public class PaolaController {

    @Autowired
    private PaolaService paolaService;

    //EJERCICIO 9: Parse_unstructured_data
    @GetMapping("/Parse_unstructured_data/{nombreDatos}")
    public String parseData(@PathVariable("nombreDatos") String nombreDatos) {
        return paolaService.parseData(nombreDatos);
    }

    //EJERCICIO 22: Python_bug_fixer
    @GetMapping("/Python_bug_fixer/{nombreDatos}")
    public String pythonFixer(@PathVariable("nombreDatos") String nombreDatos) {
        return paolaService.pythonFixer(nombreDatos);
    }

    //EJERCICIO 35: Analogy_maker
    @GetMapping("/Analogy_maker/{nombreDatos}")
    public String analogyMaker(@PathVariable("nombreDatos") String nombreDatos) {
        return paolaService.analogyMaker(nombreDatos);
    }

    //EJERCICIO 48: Interview_questions
    @GetMapping("/Interview_questions/{nombreDatos}")
    public String interviewQuestions(@PathVariable("nombreDatos") String nombreDatos) {
        return paolaService.interviewQuestions(nombreDatos);
    }
     //EJERCICIO: Generador de letra de una cancion
    @GetMapping("/Letra_cancion/{nombreDatos}")
    public String letraCancion(@PathVariable("nombreDatos") String nombreDatos) {
        return paolaService.letraCancion(nombreDatos);
    }
    /* REVISION
    Hago entrega de mis 4 actividades, ademas tambien hago entrega de mi otra actividad hice un metodo
    para pedir una o varios palabras y que este genere la letra de una cancion.
    */
}
