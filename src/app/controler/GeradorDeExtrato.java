/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package app.controler;

import app.model.Agendamento;
import app.model.Cliente;
import app.model.Extrato;
import com.google.gson.reflect.TypeToken;
import java.lang.reflect.Type;
import java.util.ArrayList;

/***
 * Classe responsavel por gerar os extratos das vendas da loja
 * @author manuc
 */
public class GeradorDeExtrato {
    
    private ArrayList<Extrato> listaDeExtratos;
    private static final String FILE_PATH = "extratos.json";

    public GeradorDeExtrato() {
        listaDeExtratos = new ArrayList<>();
        carregarExtratosDoArquivo();
    }
   
    /***
     * Método para carregar  os extratos do arquivo Json
     */
    private void carregarExtratosDoArquivo() {
        Type listType = new TypeToken<ArrayList<Extrato>>() {}.getType();
        
        // Chamando o método genérico da classe CarregadorDeDados e garantindo que o tipo está correto
        listaDeExtratos = GerenciarDados.carregarDadosDoArquivo(FILE_PATH, listType);
    }
        
    /*** Método para salvar os Extratos no arquivo JSON
     * 
     */
    
    public void salvarExtratosNoArquivo() {
        GerenciarDados.salvarNoArquivo(listaDeExtratos, FILE_PATH);
    }
    
    /*** 
     * Metodo para listar os extratos
     */
    public void listarExtratos() {
        GerenciarDados.listar(listaDeExtratos);
    }
    
    
    /***
     * Método para gerar um novo extrato
     * @param cliente
     * @param valor
     * @param item 
     */
    public void gerarExtrato(Cliente cliente, double valor, String item){
        Extrato novoExtrato = new Extrato(cliente, valor, item);
        listaDeExtratos.add(novoExtrato);
    }

    @Override
    public String toString() {
        return "GeradorDeExtrato{" + "listaDeExtratos=" + listaDeExtratos + '}';
    }
    
    
}
