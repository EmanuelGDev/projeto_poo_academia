/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package app.model;

import java.util.ArrayList;

/***
 * Classe que representa uma sala da academia
 * @author manuc
 */
public class Salas {
    
    private String nome;
    private int lotacaoMaxima;

    public Salas(){
    }

    public Salas(String nome, int lotacaoMaxima) {
        this.nome = nome;
        this.lotacaoMaxima = lotacaoMaxima;
    }

    @Override
    public String toString() {
        return "Salas{" + "nome=" + nome + ", lotacaoMaxima=" + lotacaoMaxima + '}';
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public int getLotacaoMaxima() {
        return lotacaoMaxima;
    }

    public void setLotacaoMaxima(int lotacaoMaxima) {
        this.lotacaoMaxima = lotacaoMaxima;
    }
    
    
    
    
    
    
    
    
}
