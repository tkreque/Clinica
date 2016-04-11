/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package clinica;

import csv.CSVFile;
import java.util.ArrayList;
import paciente.Paciente;

/**
 *
 * @author reque
 */
public class Clinica {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        String file = "/home/reque/Codes/Clinica/Clinica/Files/pacientes.csv";
        CSVFile csv = new CSVFile();
        ArrayList<Paciente> pacientes = null;
        
        try{
            csv.open(file);
            pacientes = csv.readObject();
            csv.close();
        }catch(Exception ex){
            System.out.println("Erro: "+ex);
        }
        
        for(int i=0; i<pacientes.size();i++){
            System.out.println(pacientes.get(i));
        }
    }
    
}
