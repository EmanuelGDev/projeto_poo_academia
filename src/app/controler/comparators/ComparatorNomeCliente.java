/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package app.controler.comparators;

/**
 *
 * @author manuc
 */

import app.model.Cliente;
import java.util.Comparator;

    /***
     * 
     * Comparator para o nome de um cliente
     */
    public class ComparatorNomeCliente implements Comparator<Cliente> {
        
        public int compare (Cliente cliente1, Cliente cliente2){
            return StringComparador.comparador(cliente1.getName(), cliente2.getName());
        }

    @Override
    public String toString() {
        return "ComparatorNomeCliente{" + '}';
    }
        
        
    }
