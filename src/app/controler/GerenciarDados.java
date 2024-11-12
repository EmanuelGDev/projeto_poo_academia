/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package app.controler;

import app.model.Funcionario;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.reflect.TypeToken;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.List;


/***
 * Classe generica que trabalha com gerenciamento dos dados nos arquivos json
 * @author manuc
 */
public class GerenciarDados {
    
    private static final Gson gson = new GsonBuilder().setPrettyPrinting().create();
    
    
    /***
     * Metodo genérico para cerragar dados de um arquivo 
     * @param <T>
     * @param filePath
     * @param listType
     * @return 
     */
    public static <T> ArrayList<T> carregarDadosDoArquivo(String filePath, Type listType) {
        ArrayList<T> dados = new ArrayList<>();
        try (FileReader reader = new FileReader(filePath)) {
            ArrayList<T> dadosDoArquivo = gson.fromJson(reader, listType);
            if (dadosDoArquivo != null) {
                dados.addAll(dadosDoArquivo);
            }
        } catch (IOException e) {
            System.out.println("Arquivo JSON não encontrado ou vazio. Criando um novo arquivo.");
        }
     return dados;   
    }

    
    
    /***
     * Metodo generico para salvar dados em um arquivo
     * @param <T>
     * @param listaDeObjetos
     * @param filePath 
     */
    
    public static <T> void salvarNoArquivo(ArrayList<T> listaDeObjetos, String filePath) {
        try (FileWriter writer = new FileWriter(filePath)) {
            gson.toJson(listaDeObjetos, writer);
        } catch (IOException e) {
            System.out.println("Erro ao salvar no arquivo JSON: " + e.getMessage());
        }
    }
    
    
    /***
     * Metodo generico para listar objetos de uma lista
     * @param <T>
     * @param listaDeObjetos 
     */
    
    public static <T> void listar(ArrayList<T> listaDeObjetos) {
        if (listaDeObjetos.isEmpty()) {
            System.out.println("Nenhum item encontrado.");
        } else {
            for (T objeto : listaDeObjetos) {
                System.out.println(objeto);
            }
        }
    }

    @Override
    public String toString() {
        return "GerenciarDados{" + '}';
    }
    
    
}
