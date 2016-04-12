/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package clinica;

import csv.CSVFile;
import java.util.ArrayList;
import paciente.Paciente;
import paciente.PacienteParser;

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
        CSVFile<Paciente> csv = new CSVFile<>();
        ArrayList<Paciente> pacientes = null;
        PacienteParser pp = new PacienteParser();
        
        try{
            csv.open(file);
            csv.setParser(pp);
            pacientes = csv.readObject();
            csv.close();
        }catch(Exception ex){
            System.out.println("Erro: "+ex);
        }
        
        if(pacientes!=null){
            System.out.println("-----> INICIO DA LISTA <-----");
            for(int i=0; i<pacientes.size();i++){
                System.out.println(pacientes.get(i));
            }
            System.out.println("<----- FIM DA LISTA ----->");
        }
        
    }
    
}
