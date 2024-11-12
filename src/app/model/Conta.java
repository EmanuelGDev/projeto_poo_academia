/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package app.model;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.UUID;

/***
 * Classe que representa uma conta da academia, seja receita ou despesa
 * 
 */
public class Conta {
    
    private String nomeConta;
    private String descricao;
    private double valor;
    private final String id;
    private String data;
    private String tipo;

    public Conta() {
        this.id = UUID.randomUUID().toString();
        this.data = this.data = LocalDateTime.now().format(DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm"));
    }

    public Conta(String nomeDispesa, String descricao, double valor, String tipo) {
        this.nomeConta = nomeDispesa;
        this.descricao = descricao;
        this.valor = valor;
        this.id = UUID.randomUUID().toString();
        this.data = this.data = LocalDateTime.now().format(DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm"));
        this.tipo = tipo;
    }

    
    //O atributo ID é definido na chamada do construtor, além de ser um atributo final, portanto nao foi necessário seu Setter
    
    public String getNomeConta() {
        return nomeConta;
    }

    public void setNomeConta(String nomeDispesa) {
        this.nomeConta = nomeDispesa;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public double getValor() {
        return valor;
    }

    public void setValor(double valor) {
        this.valor = valor;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public String getId() {
        return id;
    }

    public String getData() {
        return data;
    }
    
    

    @Override
    public String toString() {
        return "Conta{" + "nomeDispesa=" + nomeConta + ", descricao=" + descricao + ", valor=" + valor + ", id=" + id + ", data=" + data + ", tipo=" + tipo + '}';
    }
    

    
    
    
}
