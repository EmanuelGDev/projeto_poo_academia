/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package app.model;

import app.Sistema;
import java.util.UUID;

/***
 * Classe que representa um produto da academia
 * 
 */
public class Produto {
    
    private String nome;
    private final String id;

    public Produto() {
        this.id = UUID.randomUUID().toString();
        
    }

    public Produto(String nome) {
        this.id = UUID.randomUUID().toString();
        this.nome = nome;
        
    }
    //O atributo ID é definido na chamada do construtor, além de ser um atributo final, portanto nao foi necessário seu Setter

    public String getId() {
        return id;
    }
    
    
    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    @Override
    public String toString() {
        return "Produto{" + "nome=" + nome + ", id=" + id + '}';
    }
    
    
    
}
