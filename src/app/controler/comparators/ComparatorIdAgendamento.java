/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package app.controler.comparators;

import app.model.Agendamento;
import java.util.Comparator;

/**
 *
 * Comparator para o id de um agendamento
 */
public class ComparatorIdAgendamento implements Comparator<Agendamento>{
        public int compare (Agendamento a1, Agendamento a2){
            return StringComparador.comparador(a1.getId(), a2.getId());
        }    

    @Override
    public String toString() {
        return "ComparatorIdAgendamento{" + '}';
    }
    
    
}
