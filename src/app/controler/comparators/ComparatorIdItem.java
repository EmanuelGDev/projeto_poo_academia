/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package app.controler.comparators;

import app.model.Item;
import java.util.Comparator;

/**
 *
 * Comparator para o id de um item
 */
public class ComparatorIdItem implements Comparator<Item> {
    
    public int compare (Item i1 , Item i2){
        return StringComparador.comparador(i1.getId(), i2.getId());
    }

    @Override
    public String toString() {
        return "ComparatorIdItem{" + '}';
    }
    
    
}
