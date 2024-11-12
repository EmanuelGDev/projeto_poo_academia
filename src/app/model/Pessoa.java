/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package app.model;

/***
 * Classe abstrata que representa uma pessoa da academia
 * 
 */
public abstract class Pessoa {
    
    
    //Atributos
    private String name;
    private String cpf;

    //Construtor padrão
    public Pessoa() {
    }

    //Construtor com parametros
    public Pessoa(String name, String cpf) {
        this.name = name;
        this.cpf = cpf;
    }

    
    @Override
    public String toString() {
        return "Pessoa{" + "name=" + name + ", cpf=" + cpf + '}';
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }
    
    
}
