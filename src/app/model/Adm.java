/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package app.model;

import java.util.ArrayList;

/***
 * Classe que representa um adiministrador da academia
 * 
 */
public class Adm extends Funcionario{

    private static String senhaDeAdministrador;
    
    public Adm() {
    }

    public Adm(String email, String password, String position, String name, String cpf) {
        super(name, cpf, email, password, position);
    }

    public static String getSenhaDeAdministrador() {
        return senhaDeAdministrador;
    }

    public static void setSenhaDeAdministrador(String senhaDeAdministrador) {
        Adm.senhaDeAdministrador = senhaDeAdministrador;
    }

    @Override
    public String toString() {
        return "Adm{" + '}';
    }

    
    
    
    
}
