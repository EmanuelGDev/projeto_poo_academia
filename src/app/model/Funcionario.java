/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package app.model;
import java.util.UUID;

/***
 * Classe que representa um funcionario da academia
 * 
 */
public class Funcionario extends Pessoa{
    
    private String email;
    private String password;
    private String position;
    private String id;

    public Funcionario() {
        this.id = UUID.randomUUID().toString();
    }

    public Funcionario(String email) {
        this.email = email;
    }
    
    

    public Funcionario(String name, String cpf, String email, String password, String position) {
        super(name, cpf);
        this.email = email;
        this.password = password;
        this.position = position;
        this.id = UUID.randomUUID().toString();
    }

    @Override
    public String toString() {
        return "Funcionario{" + "nome= " + super.getName() + ", cpf= " + super.getCpf()+ ", email= " + email + ", password=" + password + ", position=" + position + '}';
    }

    
    //O atributo ID é definido na chamada do construtor, além de ser um atributo final, portanto nao foi necessário seu Setter
    
    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getPosition() {
        return position;
    }

    public void setPosition(String position) {
        this.position = position;
    }
    
    
}
