/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package app.model;

/***
 * Classe que representa um extrato de uma compra da academia
 * 
 */
public class Extrato {
    
    private Cliente cliente;
    private double valor;
    private String item;

    public Extrato(Cliente cliente, double valor, String item) {
        this.cliente = cliente;
        this.valor = valor;
        this.item = item;
    }
    
    

    public Cliente getCliente() {
        return cliente;
    }

    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }

    public double getValor() {
        return valor;
    }

    public void setValor(double valor) {
        this.valor = valor;
    }

    public String getItem() {
        return item;
    }

    public void setItem(String item) {
        this.item = item;
    }

    @Override
    public String toString() {
        return "Extrato{" + "cliente=" + cliente + ", valor=" + valor + ", item=" + item + '}';
    }

    
    
    
    
}
