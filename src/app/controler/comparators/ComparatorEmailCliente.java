/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package app.controler.comparators;

import app.controler.comparators.StringComparador;
import app.model.Cliente;

import java.util.Comparator;

    /***
     * Comparator para email de um cliente
     * 
     */
    public class ComparatorEmailCliente implements Comparator<Cliente> {
        
        public int compare (Cliente cliente1, Cliente cliente2){
            return StringComparador.comparador(cliente1.getEmail(), cliente2.getEmail());
        }

    @Override
    public String toString() {
        return "ComparatorEmailCliente{" + '}';
    }
        
    }
