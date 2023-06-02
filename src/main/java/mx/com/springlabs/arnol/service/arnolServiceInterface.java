/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package mx.com.springlabs.arnol.service;

/**
 *
 * @author arnol
 */
public interface arnolServiceInterface {
        public String natural_language_to_OpenAI_API(String nombrePelicula);
        public String keywords(String nombrePelicula);
        public String extractContactInformation(String nombrePelicula);
        public String chat(String nombrePelicula);
}
