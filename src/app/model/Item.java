/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package app.model;

import app.Sistema;
import app.model.Produto;

import java.util.UUID;
/***
 * Classe que representa um item da loja da academia
 * 
 */
public class Item{
    
    private Produto produto;
    private double preco;
    private  int quantidade;
    private final String id;

    public Item(Produto produto, int quantidade, double preco) {
        this.produto = produto;
        this.quantidade = quantidade;
        this.preco = preco;
        this.id = UUID.randomUUID().toString();
        Sistema.somarNumItens();
    }
    


    public Item() {
        this.id = UUID.randomUUID().toString();
        Sistema.somarNumItens();
    }
    
    public Item(String aux){
        this.id = aux;
        Sistema.somarNumItens();
    }

    
    //O atributo ID é definido na chamada do construtor, além de ser um atributo final, portanto nao foi necessário seu Setter
    
    public String getId() {
        return id;
    }

    public Produto getProduto() {
        return produto;
    }

    public void setProduto(Produto produto) {
        this.produto = produto;
    }

    public int getQuantidade() {
        return quantidade;
    }

    public void setQuantidade(int quantidade) {
        this.quantidade = quantidade;
    }

    public double getPreco() {
        return preco;
    }

    public void setPreco(float preco) {
        this.preco = preco;
    }
    
    

    @Override
    public String toString() {
        return "Item{" + "produto=" + produto + ", preco=" + preco + ", quantidade=" + quantidade + ", id=" + id + '}';
    }
    
    
    
    


    
    
    
    
    
}
