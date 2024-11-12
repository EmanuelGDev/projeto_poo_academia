/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package app.controler.comparators;

import app.model.Funcionario;
import java.util.Comparator;

/**
 *
 * Comparator para um email de um funcionario
 */
public class ComparatorEmailFuncionario implements Comparator<Funcionario> {
    
    public int compare (Funcionario func1, Funcionario func2){
        return StringComparador.comparador(func1.getEmail(), func2.getEmail());
    
    }

    @Override
    public String toString() {
        return "ComparatorEmailFuncionario{" + '}';
    }
    
    
}
