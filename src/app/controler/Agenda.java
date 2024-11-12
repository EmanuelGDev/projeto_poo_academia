/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package app.controler;

import app.controler.comparators.ComparatorDataAgendada;
import app.controler.comparators.ComparatorEmailCliente;
import app.controler.comparators.ComparatorIdAgendamento;
import app.controler.comparators.ComparatorInstrutor;
import app.model.Agendamento;
import app.model.Cliente;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.reflect.TypeToken;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.lang.reflect.Type;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.time.temporal.ChronoUnit;
import static java.time.temporal.ChronoUnit.DAYS;
import java.util.ArrayList;
import java.util.Iterator;
import javax.swing.JOptionPane;


/**
 *
 * Classe Agenda, onde será realizado tratamento dos agendamentos.
 */
public class Agenda {
    
    
    private ArrayList<Agendamento> listaDeAgendamentos;
    private static final String FILE_PATH = "agendamentos.json"; // Arquivo onde os dados serão armazenados
    private ComparatorInstrutor comparatorInstrutor = new ComparatorInstrutor();
    private ComparatorIdAgendamento comparatorId = new ComparatorIdAgendamento();
    private ComparatorDataAgendada comparatorData = new ComparatorDataAgendada();
    
    /***
     * Construtor da classe Agenda
     */
    
    public Agenda() {
        listaDeAgendamentos = new ArrayList<>();
        carregarAgendamentosDoArquivo();
    }
    
    /***
     * Getter
     * @return retorna a lista de agendamentos
     */
    
    public ArrayList<Agendamento> getListaDeAgendamentos() {
        return listaDeAgendamentos;
    }
    
    /*** 
     * Metodo para carregar os agendamentos do arquivo Json
     */
    
    private void carregarAgendamentosDoArquivo() {
        Type listType = new TypeToken<ArrayList<Agendamento>>() {}.getType();
        
        listaDeAgendamentos = GerenciarDados.carregarDadosDoArquivo(FILE_PATH, listType);
    }
    
    /*** Método para salvar os agendamentos no arquivo JSON
     * 
     */
    
    public void salvarAgendamentosNoArquivo() {
        GerenciarDados.salvarNoArquivo(listaDeAgendamentos, FILE_PATH);
    }
    
    
    /*** Método que lista todos os agendamentos.
     * 
     */
    public void listarAgendamentos() {
        GerenciarDados.listar(listaDeAgendamentos);
    }
    
    
    
    
    /***
     * Metodo que cadastra um novo agendamento
     * @param nomeCliente
     * @param emailCliente
     * @param instrutor
     * @param tipoAula
     * @param assinatura
     * @param dia
     * @param mes
     * @param ano
     * @param hora
     * @param minuto 
     */
    
    public void adicionarAgendamento(String nomeCliente, String emailCliente, String instrutor, String tipoAula, String assinatura, int dia, int mes, int ano, int hora, int minuto){
        
        boolean aux1 = dataMaior(dia, mes, ano, hora, minuto);
        String dataAgendada = String.format("%02d",dia) + "/" + String.format("%02d",mes) + "/" + String.format("%02d",ano) + " " + String.format("%02d",hora) + ":" + String.format("%02d",minuto);
        boolean aux2 = instrutorDisponivel(instrutor, dataAgendada);
        
        //Verifica se a data atual não é maior que a data do agendamento
        if(!aux1){
            //Verifica se o instrutor desejado está disponível
            if(aux2){
                
                //Cria o agendamento
                Agendamento agendamento = new Agendamento(nomeCliente, emailCliente, instrutor, tipoAula, assinatura, dia, mes, ano, hora, minuto);
                listaDeAgendamentos.add(agendamento);
                JOptionPane.showMessageDialog(null, "Agendamento adicionado com sucesso!");
            }else{
                JOptionPane.showMessageDialog(null, "Esse instrutor esta ocupado nesse horário! Agende outro horário ou escolha um outro insrtutor.");
            }
        }else
            {
                JOptionPane.showMessageDialog(null, "Esse dia ja passou!");
        }
        
    }
    
    
    /***
     * Método para verificar se a data atual é maior que uma data especifica
     * @param dia
     * @param mes
     * @param ano
     * @param hora
     * @param minuto
     * @return 
     */
    public boolean dataMaior(int dia, int mes, int ano, int hora, int minuto){
        LocalDateTime aux1 = LocalDateTime.of(ano, mes, dia, hora, minuto);
        LocalDateTime aux2 = LocalDateTime.now();
        
        if(aux1.isBefore(aux2)){
            return true;
        }
        return false;
    }
    
    
    /***
     * Metodo para excluir um agendamento
     * @param id 
     */
    public void excluirAgendamento(String id){
       Iterator<Agendamento> iterator = listaDeAgendamentos.iterator();
       
       while(iterator.hasNext()){
           Agendamento agendamento = iterator.next();
           if(comparatorId.compare(agendamento, new Agendamento(id))==0){
                iterator.remove();
               System.out.println("excluindo");
           }
       }
    }
    
    
    
    /***
     * Método que verifica se um instrutor esta disponivel em certo horário.
     * @param instrutor
     * @param dataAgendada
     * @return 
     */   
    public boolean instrutorDisponivel(String instrutor, String dataAgendada){
        Iterator<Agendamento> iterator = listaDeAgendamentos.iterator();
       
        while(iterator.hasNext()){
           Agendamento agendamento = iterator.next();
           
           int aux1 = comparatorInstrutor.compare(agendamento, new Agendamento(instrutor));
           int aux2 = comparatorData.compare(agendamento, new Agendamento(dataAgendada));
           
           if(aux1 == 0 && aux2 ==0){
                  return false; 
           }
        }
    return true;
    
    }
    
    
    /***
     * Método que verifica se, após cancelar um agendamento, será devolvido metade do valor ao cliente de acordo
     * com o número de dias restantes para o dia agendado
     * @param id
     * @return 
     */
    public boolean devolverMetade(String id){
        Iterator<Agendamento> iterator = listaDeAgendamentos.iterator();
       
       while(iterator.hasNext()){
            Agendamento agendamento = iterator.next();
           
            String diaMarcado = agendamento.getDataAgendada();
            
            DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm");
           
            LocalDateTime dataMarcada = LocalDateTime.parse(diaMarcado, formatter);
            LocalDateTime dataAtual = LocalDateTime.now();
            
            long diferencaDias = ChronoUnit.DAYS.between(dataAtual, dataMarcada);
            
            int aux = comparatorId.compare(agendamento, new Agendamento(id));
            if(aux == 0){
                if(agendamento.isCofirmada() ==true){
                    
                    if(diferencaDias > 3){
                        System.out.println("foi devolvido metade");
                        System.out.println(diferencaDias);
                        return true;
               } else{ System.out.println("nao devolvido metade");}
            }
            }
           
       }

       return false;
        
    }
    
    
    /***
     * Método para fazer a confirmação de um agendamento.
     * @param id 
     */
    public void confirmarAgendamento(String id){
        Iterator<Agendamento> iterator = listaDeAgendamentos.iterator();
       
       while(iterator.hasNext()){
           Agendamento agendamento = iterator.next();
           if(comparatorId.compare(agendamento, new Agendamento(id))==0){
               agendamento.setCofirmada(true);
           }
        }
    }

    @Override
    public String toString() {
        return "Agenda{" + "listaDeAgendamentos=" + listaDeAgendamentos + ", comparatorInstrutor=" + comparatorInstrutor + ", comparatorId=" + comparatorId + ", comparatorData=" + comparatorData + '}';
    }
    
    
}
