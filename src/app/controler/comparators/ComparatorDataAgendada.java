/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package app.controler.comparators;

import app.model.Agendamento;
import java.util.Comparator;

/**
 *
 * Comparator para uma data de Agendamento
 */
public class ComparatorDataAgendada implements Comparator<Agendamento>{
    
        public int compare (Agendamento a1,Agendamento a2 ){
            return StringComparador.comparador(a1.getDataAgendada(), a2.getDataAgendada());
        }    

    @Override
    public String toString() {
        return "ComparatorDataAgendada{" + '}';
    }
        
        
}
