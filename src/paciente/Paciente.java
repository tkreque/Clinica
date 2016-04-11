/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package paciente;

import java.time.LocalDate;

/**
 *
 * @author reque
 */
public class Paciente {
    private String RG;
    private String nome;
    private LocalDate dataNascimento;

    public Paciente() {
    }

    public Paciente(String RG, String nome, LocalDate dataNascimento) {
        this.RG = RG;
        this.nome = nome;
        this.dataNascimento = dataNascimento;
    }
    
    public String getRG() {
        return RG;
    }

    public void setRG(String RG) {
        this.RG = RG;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public LocalDate getDataNascimento() {
        return dataNascimento;
    }

    public void setDataNascimento(LocalDate dataNascimento) {
        this.dataNascimento = dataNascimento;
    }

    @Override
    public String toString() {
        return "Paciente{" + "RG=" + RG + ", nome=" + nome + ", dataNascimento=" + dataNascimento + '}';
    }

}
