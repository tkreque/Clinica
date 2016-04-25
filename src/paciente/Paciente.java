/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package paciente;

import java.time.LocalDate;
import java.util.Objects;

/**
 *
 * @author reque
 */
public class Paciente implements Comparable<Paciente> {
    private String nome;
    private String RG;
    private LocalDate dataNascimento;

    public Paciente() {
    }

    public Paciente(String nome, String RG, LocalDate dataNascimento) {
        this.nome = nome;
        this.RG = RG;
        this.dataNascimento = dataNascimento;
    }
    
    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getRG() {
        return RG;
    }

    public void setRG(String RG) {
        this.RG = RG;
    }
    
    public LocalDate getDataNascimento() {
        return dataNascimento;
    }

    public void setDataNascimento(LocalDate dataNascimento) {
        this.dataNascimento = dataNascimento;
    }

    @Override
    public String toString() {
        return "Paciente{" + "nome=" + nome + ", RG=" + RG + ", dataNascimento=" + dataNascimento + '}';
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 17 * hash + Objects.hashCode(this.RG);
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Paciente other = (Paciente) obj;
        if (!Objects.equals(this.RG, other.RG)) {
            return false;
        }
        return true;
    }

    @Override
    public int compareTo(Paciente o) {
        if(this.equals(o)){
            return 0;
        }else if(this.hashCode() > o.hashCode()){
            return 1;
        }else{
            return -1;
        }
    }

    

}
