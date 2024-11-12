/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package app.controler.comparators;

import app.model.Cliente;

/**
 *
 * Classe comparadora entra duas strings
 */
public class StringComparador {
    
        
    /***
     * Metodo que retorna a diferenca entra duas strings beseada no valor dos caracteres das strings.
     * @param s1
     * @param s2
     * @return 
     */
    public static int comparador(String s1, String s2) {
            
        
        int minLength = Math.min(s1.length(), s2.length());
        
        
        for (int i = 0; i < minLength; i++) {
            char ch1 = s1.charAt(i);
            char ch2 = s2.charAt(i);
            
            if (ch1 != ch2) {
               
                return ch1 - ch2;
            }
        }
        
        return s1.length() - s2.length();
    }

    @Override
    public String toString() {
        return "StringComparador{" + '}';
    }
    
    
}
