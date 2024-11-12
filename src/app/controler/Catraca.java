/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package app.controler;

import app.model.PassagemCatraca;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.reflect.TypeToken;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.lang.reflect.Type;
import java.util.ArrayList;


/**
 * Classe para representar o sistema externo de catraca
 * 
 */
public class Catraca {
    
    
    /*** 
     * Atributos
     */
    private ArrayList<PassagemCatraca> listaDeLogs;
    private static final String FILE_PATH = "logs.json"; // Arquivo onde os dados serão armazenados
    private final Gson gson;
    private static int clientesPresentes;

    public Catraca() {
        listaDeLogs = new ArrayList<>();
        
        gson = new GsonBuilder().setPrettyPrinting().create(); // Para formatar o JSON de maneira legível
        carregarLogsDoArquivo(); // Carregar clientes ao iniciar o sistema
    }
    
    
    /***
     * Getters e setters
     * 
     */

    public ArrayList<PassagemCatraca> getListaDeLogs() {
        return listaDeLogs;
    }
    
    

    public static int getClientesPresentes() {
        return clientesPresentes;
    }
    
    

    public static void setClientesPresentes(int clientesPresentes) {
        Catraca.clientesPresentes = clientesPresentes;
    }
    
     public int mostrarNumeroClientesAtivos(){
        return getClientesPresentes();
    }
    
    

    /***
     * Metodo para aumentar o representador de clientes presentes na academia
     */
    public void aumentarClienteAtivo(){
        setClientesPresentes(getClientesPresentes() + 1);
        System.out.println(getClientesPresentes());
    }
    
    
    
    /***
     * Metodo para diminuir o representador de clientes presentes na academia
     */
    
    public void diminuirClienteAtivo(){
        setClientesPresentes(getClientesPresentes() - 1 );
        System.out.println(getClientesPresentes());
    }
    
    
    
    
    
    
    /***
     * Método para carregar os logs do arquivo JSON
     */
    
    private void carregarLogsDoArquivo() {
        
                // Definindo o tipo da lista de funcioanarios de forma correta
        Type logsListType = new TypeToken<ArrayList<PassagemCatraca>>() {}.getType();
        
        // Chamando o método genérico da classe GerenciarDados e garantindo que o tipo está correto
        listaDeLogs = GerenciarDados.carregarDadosDoArquivo("logs.json", logsListType);
    }
    
    

    /*** Método para salvar os logs no arquivo JSON
     * 
     */
    
    public void salvarLogsNoArquivo() {
        GerenciarDados.salvarNoArquivo(listaDeLogs, FILE_PATH);
    }
    
    
    
    
    /***
     * Método para listar os logs
     */
    public void listarLogs() {
        GerenciarDados.listar(listaDeLogs);
    }
    
    
    
    /***
     * Metodo para adicionar um log
     * @param nome
     * @param email
     * @param entrouSaiu 
     */
    public void adicionarLog(String nome, String email, String entrouSaiu) {
        
        PassagemCatraca passagemCatraca= new PassagemCatraca(nome,email,entrouSaiu);
        listaDeLogs.add(passagemCatraca);
        salvarLogsNoArquivo();
        
    }

    @Override
    public String toString() {
        return "Catraca{" + "listaDeLogs=" + listaDeLogs + ", gson=" + gson + '}';
    }
    
    
    
}
