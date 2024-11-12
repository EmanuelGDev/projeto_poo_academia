/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package app.controler;


import app.model.Conta;
import app.model.Extrato;
import com.google.gson.reflect.TypeToken;
import java.lang.reflect.Type;
import java.util.ArrayList;

/***
 * Classe que gerencia a parte financeira do sistema, realizando tarefas relacionadas a venda de itens, geração de extratos e balanços
 * 
 */
public class Financeiro {
    
    private ArrayList<Conta> listaDeContas;
    private static final String FILE_PATH = "contas.json";
    
    public Financeiro(){
        listaDeContas = new ArrayList<>();
        carregarContasDoArquivo();
    }

    public ArrayList<Conta> getListaDeContas() {
        return listaDeContas;
    }
    
    /***
     * Método para carregar as contas do arquivo json
     */
    
    private void carregarContasDoArquivo() {
        Type listType = new TypeToken<ArrayList<Conta>>() {}.getType();
        
        // Chamando o método genérico da classe CarregadorDeDados e garantindo que o tipo está correto
        listaDeContas = GerenciarDados.carregarDadosDoArquivo(FILE_PATH, listType);
    }
        
    /*** Método para salvar as contas no arquivo JSON
     * 
     */
    
    public void salvarExtratosNoArquivo() {
        GerenciarDados.salvarNoArquivo(listaDeContas, FILE_PATH);
    }
    
    
    /***
     * Método para listar os extratos
     */
    public void listarExtratos() {
        GerenciarDados.listar(listaDeContas);
    }
    
    
    /***
     * Metodo para cadastrar uma nova conta
     * @param nome
     * @param descricao
     * @param valor
     * @param tipo 
     */
    public void cadastrarConta(String nome, String descricao, double valor, String tipo){
        
        Conta novaConta = new Conta(nome, descricao,valor,tipo);
        listaDeContas.add(novaConta);
        
    }

    @Override
    public String toString() {
        return "Financeiro{" + "listaDeContas=" + listaDeContas + '}';
    }
    
    
}
