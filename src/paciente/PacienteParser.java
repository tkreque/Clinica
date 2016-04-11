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
public class PacienteParser {
    private Paciente p;

    public Paciente retornaPaciente(String RG, String nome, LocalDate dataNascimento) {
        p = new Paciente(RG, nome, dataNascimento);
        return p;
    }
}
