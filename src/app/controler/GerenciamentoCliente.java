package app.controler;

import app.Sistema;
import app.controler.comparators.ComparatorEmailCliente;
import app.model.Cliente;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.reflect.TypeToken;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.Scanner;

/***
 * Classe que faz o gerenciamento de tudo relacionado à clientes
 * 
 */

public class GerenciamentoCliente {
    
    private ArrayList<Cliente> listaDeClientes;
    private static final String FILE_PATH = "clientes.json"; // Arquivo onde os dados serão armazenados
    ComparatorEmailCliente emailComparator = new ComparatorEmailCliente();
    private static int contador;
    
    
    
    public GerenciamentoCliente() {
        listaDeClientes = new ArrayList<>();
        carregarClientesDoArquivo(); // Carregar clientes ao iniciar o sistema
    }
    
    

    public ArrayList<Cliente> getListaDeClientes() {
        return listaDeClientes;
    }

    public static int getContador() {
        return contador;
    }

    public static void setContador(int contador) {
        GerenciamentoCliente.contador = contador;
    }

    
    
    
    
    

    /***
     * Método para carregar os clientes do arquivo JSON
     */
    
    private void carregarClientesDoArquivo() {
        // Definindo o tipo da lista de clientes de forma correta
        Type listType = new TypeToken<ArrayList<Cliente>>() {}.getType();
        
        // Chamando o método genérico da classe CarregadorDeDados e garantindo que o tipo está correto
        listaDeClientes = GerenciarDados.carregarDadosDoArquivo("clientes.json", listType);
    }
    
    
    

    /*** Método para salvar os clientes no arquivo JSON
     * 
     */
    
    public void salvarClientesNoArquivo() {
        
        GerenciarDados.salvarNoArquivo(listaDeClientes, FILE_PATH);
    }
    
    
    
    /*** Método para listar todos os clientes
     * 
     */
    public void listarClientes() {
        GerenciarDados.listar(listaDeClientes);
    
    }
    

    /*** Método para verificar se um email já está cadastrado
     * 
     * @param email
     * @return boolean
     */
    
    public boolean verificarEmail(String email) {
        
        Collections.sort(listaDeClientes, emailComparator);
       
        int index =  Collections.binarySearch(listaDeClientes, new Cliente(email) , emailComparator);
        if (index >= 0) {
            System.out.println("Item encontrado no índice: " + index);
            return true;
        } else {
            System.out.println("Item não encontrado.");
        }
        return false;
        

        
    } 
    
    
    
    
    /*** Método para criar um novo cliente e adicionar à lista e ao arquivo JSON
     * 
     * @param endereco
     * @param fone
     * @param email
     * @param nome
     * @param cpf 
     * @param cartao
     */
    public void adicionarCliente(String nome, String email, String cpf, String cartao, String fone, String endereco) {
        if (!(verificarEmail(email))) {
            Cliente novoCliente = new Cliente(nome, email, cpf, cartao, fone, endereco);
            listaDeClientes.add(novoCliente);
            System.out.println("Cliente adicionado: " + novoCliente);
        } else {
            System.out.println("Esse email já foi cadastrado.");
        }
    }
    
    


    /*** Método para excluir um cliente
     * 
     * @param email 
     */
    public void excluirCliente(String email) {
        for (int i = 0; i < listaDeClientes.size(); i++) {
            if (listaDeClientes.get(i).getEmail().equals(email)) {
                System.out.println("Cliente Excluído: " + listaDeClientes.get(i).getName());
                listaDeClientes.remove(i);
                break;
                
            }
        }
    }
    
    
    
    
    /***
     * Metodo para editar um cliente
     * @param email 
     */
    public void editarCliente(String emailAtual, String nome, String novoEmail, String cpf, String cartao, String telefone, String endereco){
        Scanner scanner = new Scanner(System.in);
        for (int i = 0; i < listaDeClientes.size(); i++) {
            if (listaDeClientes.get(i).getEmail().equals(emailAtual)){
                
                listaDeClientes.get(i).setName(nome);
                listaDeClientes.get(i).setEmail(novoEmail);
                listaDeClientes.get(i).setCpf(cpf);
                listaDeClientes.get(i).setCartao(cartao);
                listaDeClientes.get(i).setFone(telefone);
                listaDeClientes.get(i).setEndereco(endereco);

                break;
            }
        }
        
    }
    
    public Cliente findClienteIteratorComparator(String email){
        
            Iterator<Cliente> iterator = getListaDeClientes().iterator();
            int auxIndex = 0;
            while (iterator.hasNext()) {
                Cliente cliente = iterator.next();
                int aux = emailComparator.compare(cliente,new Cliente(email));
                if(aux == 0 ){
                    System.out.println("Cliente encontrado no index: " + auxIndex);
                    return cliente;
                }
                auxIndex++;
                    
            }  
            return null;
    }
    
    public int findBinarySearch(String email){
        ArrayList<Cliente> aux1 = getListaDeClientes();

            

        int index =  Collections.binarySearch(aux1, new Cliente(email) , emailComparator);
            if (index >= 0) {
               System.out.println("Item encontrado no indice: " + index);
               return index;
            }else {
                System.out.println("Item nao encontrado.");
                return -1;
        }
    }

    @Override
    public String toString() {
        return "GerenciamentoCliente{" + "listaDeClientes=" + listaDeClientes + ", emailComparator=" + emailComparator + '}';
    }
    
    
}
