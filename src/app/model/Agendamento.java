/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package app.model;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.UUID;

/***
 * Classe que representa um agendamento da academia
 * 
 */
public class Agendamento {
    
    private String nomeCliente;
    private String emailCliente;
    private String dataDoAgendamento;
    private String dataAgendada;
    private String instrutor;
    private String tipoAula;
    private double preco;
    private boolean cofirmada;
    private String assinatura;
    private final String id;



    public Agendamento() {
        this.id = UUID.randomUUID().toString();
    }

    public Agendamento(String aux) {
        this.emailCliente = aux;
        this.dataAgendada = aux;
        this.instrutor = aux;
        this.id = aux;
    }
    
    
    
    

    public Agendamento(
        String nomeCliente, 
        String emailCliente, 
        String instrutor, 
        String tipoAula,
        String assinatura,
        int dia, 
        int mes, 
        int ano, 
        int hora, 
        int minuto) {
        
        
        this.cofirmada = cofirmada;
        this.nomeCliente = nomeCliente;
        this.emailCliente = emailCliente;
        this.instrutor = instrutor;
        this.tipoAula = tipoAula;
        this.assinatura = assinatura;
        this.id = UUID.randomUUID().toString();
        this.dataDoAgendamento = LocalDateTime.now().format(DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm"));
        LocalDateTime dataAgendada = LocalDateTime.of(ano,mes,dia,hora,minuto);
        
        this.dataAgendada = dataAgendada.format(DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm"));
        this.preco = 35;
    }
    
    //Atributos ID e Data do agendamento são definidos quando o construtor é chamado, por isso nao foi necessário seus Setters
    
    
    
    public String getId(){
        return id;
            }

    public boolean isCofirmada() {
        return cofirmada;
    }

    public void setCofirmada(boolean cofirmada) {
        this.cofirmada = cofirmada;
    }
    

    public String getNomeCliente() {
        return nomeCliente;
    }

    public void setNomeCliente(String nomeCliente) {
        this.nomeCliente = nomeCliente;
    }

    public String getEmailCliente() {
        return emailCliente;
    }

    public void setEmailCliente(String emailCliente) {
        this.emailCliente = emailCliente;
    }

    public String getInstrutor() {
        return instrutor;
    }

    public void setInstrutor(String instrutor) {
        this.instrutor = instrutor;
    }

    public String getTipoAula() {
        return tipoAula;
    }

    public void setTipoAula(String tipoAula) {
        this.tipoAula = tipoAula;
    }

    public String getDataAgendada() {
        return dataAgendada;
    }

    public String getAssinatura() {
        return assinatura;
    }

    public void setAssinatura(String assinatura) {
        this.assinatura = assinatura;
    }

    public double getPreco() {
        return preco;
    }

    public void setPreco(double preco) {
        this.preco = preco;
    }

    @Override
    public String toString() {
        return "Agendamento{" + "nomeCliente=" + nomeCliente + ", emailCliente=" + emailCliente + ", dataDoAgendamento=" + dataDoAgendamento + ", dataAgendada=" + dataAgendada + ", instrutor=" + instrutor + ", tipoAula=" + tipoAula + ", preco=" + preco + ", cofirmada=" + cofirmada + ", assinatura=" + assinatura + ", id=" + id + '}';
    }
    
    
    
    






    
    
    
    
    
    
    
    

    
}
