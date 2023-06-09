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
        public String natural_language_to_OpenAI_API(String datos);
        public String keywords(String datos);
        public String extractContactInformation(String datos);
        public String chat(String datos);
}
