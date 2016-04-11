/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package paciente;

import csv.CSVParser;
import java.time.LocalDate;

/**
 *
 * @author reque
 */
public class PacienteParser implements CSVParser{
    private Paciente p;
    
    @Override
    public Paciente parseObject(String dados) {
        String[] array = dados.split(";");
        p = new Paciente(array[0], array[1], LocalDate.parse(array[2]));
        return p;
    }
    
    public Paciente getDados(String dados) {
        String[] array = dados.split(";");
        p = new Paciente(array[0], array[1], LocalDate.parse(array[2]));
        return p;
    }
    
}
