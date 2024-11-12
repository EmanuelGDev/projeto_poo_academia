package app.controler;

import app.controler.comparators.ComparatorEmailCliente;
import app.controler.comparators.ComparatorEmailFuncionario;
import app.model.Adm;
import app.model.Funcionario;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.reflect.TypeToken;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.Scanner;

/***
 * 
 * 
 * 
 * Classe da seção de gerenciamento de funcionario
 */

public class GerenciamentoFuncionario {
    
    private ArrayList<Funcionario> listaDeFuncionarios;
    private static final String FILE_PATH = "funcionarios.json"; // Arquivo onde os dados serão armazenados
    ComparatorEmailFuncionario emailComparator = new ComparatorEmailFuncionario();
    
    
    public ArrayList<Funcionario> getListaDeFuncionarios() {
        return listaDeFuncionarios;
    }
    
    
    
    
    public GerenciamentoFuncionario() {
        listaDeFuncionarios = new ArrayList<>();
        carregarFuncionariosDoArquivo(); // Carregar funcionários ao iniciar o sistema
    }
    
    
    

    /*** Método para carregar os funcionários do arquivo JSON
     * 
     */
    private void carregarFuncionariosDoArquivo() {
        // Definindo o tipo da lista de funcioanarios de forma correta
        Type ListType = new TypeToken<ArrayList<Funcionario>>() {}.getType();
        
        // Chamando o método genérico da classe GerenciarDados e garantindo que o tipo está correto
        listaDeFuncionarios = GerenciarDados.carregarDadosDoArquivo(FILE_PATH, ListType);
       
    }
    
    
    

    /*** Método para salvar os funcionários no arquivo JSON
     * 
     */
    public void salvarFuncionariosNoArquivo() {
        GerenciarDados.salvarNoArquivo(listaDeFuncionarios, FILE_PATH);
    }
    
    
    
    
    /*** Método para listar todos os Funcionarios
     * 
     */
    public void listarFuncionarios() {
        GerenciarDados.listar(listaDeFuncionarios);
    }
    
    
    
    /***
     * Metodo que verifica um email de funcionario
     * @param email
     * @return 
     */
    public boolean verificarEmail(String email) {
       
       Collections.sort(listaDeFuncionarios, emailComparator);
        
       int index =  Collections.binarySearch(listaDeFuncionarios, new Funcionario(email) , emailComparator);
       if (index >= 0) {
            System.out.println("Item encontrado no índice: " + index);
            return true;
        } else {
            System.out.println("Item não encontrado.");
        }
       return false;
        
    } 
    
    
    
    
    
    /***
     * Metodo para adicionar um funcionario
     * @param name
     * @param cpf
     * @param email
     * @param password
     * @param cargo 
     */
    public void adicionarFuncionario(String name, String cpf, String email, String password, String cargo) {
        if (!verificarEmail(email)) {
            Funcionario novoFuncionario = new Funcionario(name, cpf, email, password, cargo);
            listaDeFuncionarios.add(novoFuncionario);
        }
    }



    /*** Método para excluir um funcionário
     * 
     * @param email 
     */
    public void excluirFuncionario(String email) {
        for (int i = 0; i < listaDeFuncionarios.size(); i++) {
            if (listaDeFuncionarios.get(i).getEmail().equals(email)) {
                listaDeFuncionarios.remove(i);
                break;
            }
        }
    }
    
    /*** Metodo para editar um funcionario
     * 
     * @param emailAtual
     * @param nome
     * @param cpf
     * @param senha
     * @param novoEmail
     * @param cargo
     */
    public void editarFuncionario(String emailAtual, String nome, String cpf, String senha, String novoEmail, String cargo){
        for (int i = 0; i < listaDeFuncionarios.size(); i++) {
            if (listaDeFuncionarios.get(i).getEmail().equals(emailAtual)){
                
                listaDeFuncionarios.get(i).setName(nome);
                listaDeFuncionarios.get(i).setCpf(cpf);
                listaDeFuncionarios.get(i).setPassword(senha);
                listaDeFuncionarios.get(i).setEmail(novoEmail);
                listaDeFuncionarios.get(i).setPosition(cargo);
                
                
                break;
            }
        }
    
    }
    
    
    /***
     * Metodo feito para alterar a senha de administrador
     * @param novaSenha 
     */
    public void alterarSenhaAdm(String novaSenha){
        Adm.setSenhaDeAdministrador(novaSenha);
    }
    
    
    /***
     * Esse metodo salva a senha de administrador em um arquivo json
     */
    public static void salvarSenha() {
    try (BufferedWriter writer = new BufferedWriter(new FileWriter("senhaAdm.json"))) {
        writer.write(Adm.getSenhaDeAdministrador());
    } catch (IOException e) {
        e.printStackTrace();
    }
}

    /***
     * Esse metodo carrega a senha do arquivo json
     */
    public static void carregarSenha() {
        try (BufferedReader reader = new BufferedReader(new FileReader("senhaAdm.json"))) {
            String aux = reader.readLine();
            Adm.setSenhaDeAdministrador(aux);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Override
    public String toString() {
        return "GerenciamentoFuncionario{" + "listaDeFuncionarios=" + listaDeFuncionarios + ", emailComparator=" + emailComparator + '}';
    }
    
    
}
