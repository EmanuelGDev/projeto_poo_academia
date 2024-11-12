/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package app.controler;

import app.controler.comparators.ComparatorIdItem;
import app.model.Item;
import java.util.ArrayList;
import java.util.Iterator;

/***
 * Classe que representa a loja da academia com sistema de venda.
 * 
 */
public class Loja {

    Estoque estoque = new Estoque();
    ComparatorIdItem comparatorId = new ComparatorIdItem();
    private static final String FILE_PATH = "estoque.json";
    
    ArrayList<Item> listaDeItens = estoque.getListaDeItens();
    
    
    public void salvarItensNoArquivo() {
        
        GerenciarDados.salvarNoArquivo(listaDeItens, FILE_PATH);
    }
    
    /***
     * Metodo para realizar a venda de um item da loja
     * @param id 
     */
    public void venderItem(String id){
        
        Iterator<Item> iterator = listaDeItens.iterator();
        
        while (iterator.hasNext()) {
            Item item = iterator.next();
            if (comparatorId.compare(item, new Item(id)) == 0) {
                item.setQuantidade(item.getQuantidade()-1);
            }

        }
        
    }

    @Override
    public String toString() {
        return "Loja{" + "estoque=" + estoque + ", comparatorId=" + comparatorId + ", listaDeItens=" + listaDeItens + '}';
    }
    
    
}
