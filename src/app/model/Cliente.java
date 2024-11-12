/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package app.model;



import app.Sistema;
import java.util.UUID;

/***
 * Classe que representa um cliente da academia
 */
public class Cliente extends Pessoa{
    
    private String endereco;
    private String fone;
    private String email;
    private String cartao;
    private final String id;


    public Cliente() {
        
        this.id = UUID.randomUUID().toString();
        Sistema.somarNumCliente();
    }

    public Cliente(String name, String email, String cpf, String cartao, String fone, String endereco) {
        super(name, cpf);
        
       
        this.endereco = endereco;
        this.fone = fone;
        this.email = email;
        this.cartao = cartao;
        this.id = UUID.randomUUID().toString();
        Sistema.somarNumCliente();
    }

    public Cliente(String email) {
        this.email = email;
        this.id = UUID.randomUUID().toString();
        Sistema.somarNumCliente();
    }


    //O atributo ID é definido na chamada do construtor, além de ser um atributo final, portanto nao foi necessário seu Setter
    
    public String getId() {
        return id;
    }


    public String getEndereco() {
        return endereco;
    }

    public void setEndereco(String endereco) {
        this.endereco = endereco;
    }

    public String getFone() {
        return fone;
    }

    public void setFone(String fone) {
        this.fone = fone;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getCartao() {
        return cartao;
    }

    public void setCartao(String cartao) {
        this.cartao = cartao;
    }


    @Override
    public String toString() {
        return "Cliente{ nome= " + super.getName() + ", cpf= " + super.getCpf() + ", endereco= " + endereco + ", fone= " + fone + ", email= " + email + ", cartao= " + cartao + ", id= " + id + '}';
    }

    
    
    
    
    
}
