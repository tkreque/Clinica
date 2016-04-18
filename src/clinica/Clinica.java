/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package clinica;

import csv.CSVFile;

import java.util.ArrayList;

import medicamento.Medicamento;
import medicamento.MedicamentoParser;
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
        String pacienteFile = "C:\\Users\\631301442\\Desktop\\Clinica\\Files\\pacientes.csv";
        String medicamentoFile = "C:\\Users\\631301442\\Desktop\\Clinica\\Files\\medicamentos.csv";
        CSVFile<Paciente> pacienteCSV = new CSVFile<>();
        ArrayList<Paciente> pacientes = null;
        PacienteParser pacienteParser = new PacienteParser();
        CSVFile<Medicamento> medicamentoCSV = new CSVFile<>();
        ArrayList<Medicamento> medicamentos = null;
        MedicamentoParser medicamentoParser = new MedicamentoParser();

        try {
        	pacienteCSV.open(pacienteFile);
        	pacienteCSV.setParser(pacienteParser);
            pacientes = pacienteCSV.readObject();
            pacienteCSV.close();
        } catch (Exception ex) {
            System.out.println("Erro: " + ex);
        }

        if (pacientes != null) {
            System.out.println("-----> INICIO DA LISTA PACIENTES <-----");
            for (int i = 0; i < pacientes.size(); i++) {
                System.out.println(pacientes.get(i));
            }
            System.out.println("<----- FIM DA LISTA PACIENTES ----->");
        }
        
        try {
        	medicamentoCSV.open(medicamentoFile);
        	medicamentoCSV.setParser(medicamentoParser);
            medicamentos = medicamentoCSV.readObject();
            medicamentoCSV.close();
        } catch (Exception ex) {
            System.out.println("Erro: " + ex);
        }

        if (medicamentos != null) {
            System.out.println("-----> INICIO DA LISTA MEDICAMENTOS <-----");
            for (int i = 0; i < medicamentos.size(); i++) {
                System.out.println(medicamentos.get(i));
            }
            System.out.println("<----- FIM DA LISTA MEDICAMENTOS ----->");
        }
        
        
        

    }

}
