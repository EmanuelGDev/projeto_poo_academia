/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package app.model;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;


/***
 * Classe que representa uma passagem na catraca da academia
 *
 */
public class PassagemCatraca {
    
    private String nome;
    private String email;
    private String data;
    private String entrouSaiu;

    public PassagemCatraca() {
    }

    public PassagemCatraca(String nome, String email, String entrouOuSaiu) {
        this.nome = nome;
        this.email = email;
        this.data = LocalDateTime.now().format(DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm:ss"));
        this.entrouSaiu = entrouOuSaiu;
        
    }
    
    //O atributo data é definido na chamada do construtor, portanto nao foi necessário seu Setter

    @Override
    public String toString() {
        return "PassagemCatraca{" + "nome=" + nome + ", email=" + email + ", data=" + data + ", entrouSaiu=" + entrouSaiu + '}';
    }

    
    
}
