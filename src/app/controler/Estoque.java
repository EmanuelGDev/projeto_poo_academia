/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package app.controler;

import app.controler.comparators.ComparatorEmailCliente;
import app.controler.comparators.ComparatorIdItem;
import app.model.Item;
import app.model.Produto;
import com.google.gson.reflect.TypeToken;
import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.Iterator;

/**
 *
 * Classe para gerenciamento de estoque
 */
public class Estoque {
    
    
    /***
     * Atributos
     */
    private ArrayList<Item> listaDeItens;
    private static final String FILE_PATH = "estoque.json"; // Arquivo onde os dados serão armazenados
    ComparatorIdItem meuComparator = new ComparatorIdItem();
    
    public Estoque (){
        listaDeItens = new ArrayList<>();
        carregarEstoqueDoArquivo();
    }
    
    
    /***
     * Getter
     * @return retorna a lista de Itens do estoque
     */
    public ArrayList<Item> getListaDeItens() {
        return listaDeItens;
    }
    
    
    /***
     * Metodo para carregar os itens do arquivo json
     */
    
    private void carregarEstoqueDoArquivo(){
        Type listType = new TypeToken<ArrayList<Item>>() {}.getType();
        
        // Chamando o método genérico da classe CarregadorDeDados e garantindo que o tipo está correto
        listaDeItens = GerenciarDados.carregarDadosDoArquivo(FILE_PATH, listType);
    }
    
    /***
     * Metodo para salvar os itens no arquivo Json
     */
    public void salvarItensNoArquivo() {
        
        GerenciarDados.salvarNoArquivo(listaDeItens, FILE_PATH);
    }
    
    
    
    /*** Método para listar todos os itens
     * 
     */
    public void listarItens() {
    
        GerenciarDados.listar(listaDeItens);
    
    }
    
    /***
     * Metodo para adicionar um item
     * @param produto
     * @param quantidade
     * @param preco 
     */
    public void adicionarItem(Produto produto, int quantidade, double preco) {
        Item novoItem = new Item(produto, quantidade, preco);
        listaDeItens.add(novoItem);
    }
    
    /***
     * Método para excluir um item
     * @param id 
     */
    public void excluirItem(String id){
        Iterator<Item> iterator = listaDeItens.iterator();
        
        while (iterator.hasNext()) {
            Item item = iterator.next();
            if (meuComparator.compare(item, new Item(id)) == 0) {
                iterator.remove();
                System.out.println("item removido");
            }
        }

    }

    @Override
    public String toString() {
        return "Estoque{" + "listaDeItens=" + listaDeItens + ", meuComparator=" + meuComparator + '}';
    }
    
    
}
