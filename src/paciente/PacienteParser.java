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
    
    @Override
    public Paciente parseObject(String dados) {
        String[] array = dados.split(";");
        Paciente p = new Paciente(array[0], array[1], LocalDate.parse(array[2]));
        return p;
    }
    
}
