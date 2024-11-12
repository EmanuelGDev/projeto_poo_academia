/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package app.controler;

import app.model.Funcionario;
import java.util.List;

/***
 * Classe que gerencia a autenticação do sistema
 * @author manuc
 */
public class Autenticador {
    
     GerenciamentoFuncionario gerfun = new GerenciamentoFuncionario();
    
    
    /***
     * Metodo para autenticação de um funcionario
     * 
     * @param email
     * @param senha
     * @return boolean
     */
    
    public boolean login(String email, String senha){
        
        while (true) {
            
            Boolean aux = false;
            
            List<Funcionario> funcionarios = gerfun.getListaDeFuncionarios();
            
            for (int i = 0; i < funcionarios.size(); i++) {
                if(funcionarios.get(i).getEmail().equals(email) && funcionarios.get(i).getPassword().equals(senha)){
                    aux = true;
                    break;
                }
            }
            
            if(aux){
                return true;
            }else{
            return false;
                    }
        }
    }

    @Override
    public String toString() {
        return "Autenticador{" + "gerfun=" + gerfun + '}';
    }
    
    
}
