/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package app;

import app.controler.Agenda;
import app.controler.Catraca;
import app.controler.Estoque;
import app.controler.Financeiro;
import app.controler.GeradorDeExtrato;
import app.controler.GerenciamentoCliente;
import app.controler.GerenciamentoFuncionario;
import app.controler.Loja;
import app.controler.comparators.ComparatorEmailCliente;
import app.controler.comparators.ComparatorEmailFuncionario;
import app.controler.comparators.ComparatorNomeCliente;
import app.model.Adm;
import app.model.Agendamento;
import app.model.Cliente;
import app.model.Funcionario;
import app.model.Item;
import app.model.Produto;
import app.model.Salas;
import app.view.ViewLogin;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;



/**
 *
 * @author manuc
 */
public class Sistema {
    
    
    //Atributos
    private static int numItens;
    private static int numClientes1;
    protected static int numClientes2;
    private static ArrayList<Salas> listaDeSalas = new ArrayList<>();
    

    public static ArrayList<Salas> getListaDeSalas() {
        return listaDeSalas;
    }
    
    private static Salas spinning = new Salas("Spinning",30);
    private static Salas fitDance = new Salas("Fit Dance",15);
    private static Salas musculacao = new Salas("Musculação",40);
    private static Salas crossFit = new Salas("CrossFit",35);
    
    
    //Getters
    public static int getNumClientes1() {
        return numClientes1;
    }
    
    public static int getNumProdutos() {
        return numItens;
    }
    
    
    /***
     *  Metodo que soma o numero de clientes de ambos os tipos de controle de acesso
     */
    
    public static void somarNumCliente() {
        numClientes1++;
        numClientes2++;
    }
    
    /***
     * Metodo que soma o numero de itens
     */
    public static void somarNumItens() {
        numItens++;
    }
    

    public static void main(String[] args) {
        GerenciamentoCliente gc = new GerenciamentoCliente();
        GerenciamentoFuncionario gf = new GerenciamentoFuncionario();
        ComparatorEmailCliente ComparatorEC = new ComparatorEmailCliente();
        Estoque estoque = new Estoque();
        
        GerenciamentoFuncionario.carregarSenha();


       
            java.awt.EventQueue.invokeLater(new Runnable() {
                public void run() {
                    new ViewLogin().setVisible(true);
                }
            });
            System.out.println(Adm.getSenhaDeAdministrador());
            
    
            /*Financeiro financeiro = new Financeiro();
            
            financeiro.cadastrarConta("salarios", "todos os salarios do mes", 5000, "despesa");
            financeiro.salvarExtratosNoArquivo();*/
  
        
       
        
        
        

       
       //Questão 1 - Mostrar(Pronto)
       //Questão 2 - Mostrar(Pronto)
       //Questão 3 - Mostrar(Pronto)
       //Questão 4 - Mostrar(Pronto)
       //Questão 5 - 
       
        /*listaDeSalas.add(spinning);
        listaDeSalas.add(fitDance);
        listaDeSalas.add(musculacao);
        listaDeSalas.add(crossFit);
        
        System.out.println(Sistema.getListaDeSalas());*/
       
       
       
       //Questão 6 (Pronto)
       
            /*GerenciamentoFuncionario gf = new GerenciamentoFuncionario();

            gf.adicionarFuncionario("Emanuel", "12345678900", "emanuel.guimaraes@gmail.com", "senha123", "recepcionista");

            gf.salvarFuncionariosNoArquivo();

            gf.editarFuncionario("emanuel.guimaraes@gmail.com", "Emanuel2", "12345678910", "novoemail@gmail.com", "novasenha", "personal");

            gf.salvarFuncionariosNoArquivo();

            gf.excluirFuncionario("novoemail@gmail.com");

            gf.salvarFuncionariosNoArquivo();*/
       
       
       //Questão 7 (Pronto)
       
       
        //gc.adicionarCliente("Douglas", "emaildocliente@gmail.com", "99988877700", "4224 2223 5556 7890", "33999887766", "Rua dos Bobos nº 0");

        //gc.salvarClientesNoArquivo();

        //gc.editarCliente("emaildocliente@gmail.com", "lucas", "novoemail@hotmail.com", "00000000000", "cartao", "12893782347", "novo endereco");

        //gc.salvarClientesNoArquivo();

         //gc.excluirCliente("novoemail@hotmail.com");

         //gc.salvarClientesNoArquivo();
        
        
        //Questão 8 (Pronto)
        
        
        //Questão 9 - Mostrar(Pronto)
        
        
        //Questão 10 - 
        
        /*Cliente emanuel = new Cliente("Emanuel", "EMAIL", "12345678900", "1234234123123", "12312423", "eu quero ir pra casa");
        GeradorDeExtrato g = new GeradorDeExtrato();
        
        g.gerarExtrato(emanuel, 124, "whey");
        g.salvarExtratosNoArquivo();*/
        
        //Questão 11 - 
        
        
        
        /*System.out.println("Numero de clientes com o atributo private: " + getNumClientes1());
        System.out.println("Numero de clientes com o atributo protected: " + numClientes2);
        System.out.println("Numero de itens " + numItens);*/
        
        
        
        //Questão 12 - Mostrar(Pronto)
        
        
        //Questão 13 - Mostrar(Pronto)
        
        
        //Questão 14 - Mostrar(Pronto)
        
        
        //Questão 15 - 
        
            /*Iterator<Cliente> iterator = gc.getListaDeClientes().iterator();

            while (iterator.hasNext()) {
                Cliente cliente = iterator.next();
                System.out.println(cliente);
                }

            for(Cliente cliente : gc.getListaDeClientes()){
                System.out.println(cliente);
            }*/

            //Foi criado um iterator de cliente que recebe a lista de clientes, logo após
            //foi definido um while com o hasNext, ou seja, enquanto o nó atual da lista aponta para outro nó ele executa o while,
            //onde a variavel cliente recebe o iterator next, ou seja, o proximo nó, e é printado a variavel cliente.
            //Esse código faz basicamente o que o foreach faria, que seria, para cada elemento de uma lista, ele faria algo,
            //Que nesse caso seria printar o elemento

        
        //Questão 16 - (Pronto)
        
            /*
            ArrayList<Cliente> listaDeClientes = gc.getListaDeClientes();
            System.out.println("Lista de Clienes sem ordernar");
            gc.listarClientes();
            System.out.println("-------------------------------------");
            
            Collections.sort(listaDeClientes, ComparatorEC);
            System.out.println("Lista de Clienes ordenada por email");
            gc.listarClientes();
            System.out.println("-------------------------------------");
            
            Collections.sort(listaDeClientes, new ComparatorNomeCliente());
            System.out.println("Lista de Clienes ordenada por nome");
            gc.listarClientes();
            System.out.println("-------------------------------------");
            */
            
            

            

            
        
        //Questão 17 - 
        
        gc.findClienteIteratorComparator("guimaraesemanuel99@gmail.com");
        gc.findBinarySearch("guimaraesemanuel99@gmail.com");

       

        
    }
    
    
    
    
    
}
    

