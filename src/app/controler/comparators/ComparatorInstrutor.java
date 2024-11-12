/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package app.controler.comparators;

import app.model.Agendamento;
import java.util.Comparator;

/**
 *
 * comparator para o instrutor de um agendamento
 */
public class ComparatorInstrutor implements Comparator<Agendamento>{
    public int compare (Agendamento a1, Agendamento a2){
        return StringComparador.comparador(a1.getInstrutor(), a2.getInstrutor());
    }

    @Override
    public String toString() {
        return "ComparatorInstrutor{" + '}';
    }
    
    
}
