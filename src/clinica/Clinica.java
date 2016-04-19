/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package clinica;

import csv.CSVFile;
import java.time.LocalDate;
import java.util.Scanner;

import listaEncadeada.MedicamentoDAOListaEncadeada;
import listaEncadeada.PacienteDAOListaEncadeada;

import medicamento.Medicamento;
import paciente.Paciente;
import vetor.MedicamentoDAOVetor;
import vetor.PacienteDAOVetor;

/**
 *
 * @author reque
 */
public class Clinica {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
/*
        Selection Sort para o Vetor , e Insertion Sort para a Lista
*/
        Scanner in = new Scanner(System.in);
        CSVFile<Paciente> pacienteCSV = new CSVFile<>();
        CSVFile<Medicamento> medicamentoCSV = new CSVFile<>();
        MedicamentoDAOVetor medicamentosVetor = new MedicamentoDAOVetor();
        PacienteDAOVetor pacientesVetor = new PacienteDAOVetor();
        MedicamentoDAOListaEncadeada medicamentosLista = new MedicamentoDAOListaEncadeada();
        PacienteDAOListaEncadeada pacientesLista = new PacienteDAOListaEncadeada();
        int op = 1;
        
        do{
            System.out.println("Digite Vetor ou Lista para escolher sua opção? \n(Digite sair para finalizar o programa)");
            switch(in.next().toLowerCase()){
                case "vetor":
                    System.out.println("--> Vetor <--");
                    do{
                        System.out.println("Vocẽ deseja trabalhar nos medicamentos ou pacientes? \n(Digite sair para finalizar o programa)");
                        switch(in.next().toLowerCase()){
                            case "pacientes":
                                Paciente p;
                                pacientesVetor.loadData(pacienteCSV);
                                do{
                                    System.out.println("=>Paciente");
                                    System.out.println("1 - Listar");
                                    System.out.println("2 - Cadastrar");
                                    System.out.println("3 - Remover");
                                    System.out.println("4 - Pesquisar");                                    
                                    System.out.println("0 - Sair");
                                    switch(in.nextInt()){
                                        case 1:
                                            System.out.println(pacientesVetor.toString());
                                            break;
                                        case 2:
                                            p = new Paciente();
                                            in.nextLine();
                                            System.out.println("Digite o nome do Paciente:");
                                            p.setNome(in.nextLine());
                                            System.out.println("Digite o RG do Paciente: ");
                                            p.setRG(in.next());
                                            in.nextLine();
                                            System.out.println("Digite a data de aniversário do Paciente:");
                                            p.setDataNascimento(LocalDate.parse(in.nextLine()));
                                            
                                            pacientesVetor.addPaciente(p);
                                            System.out.println(pacientesVetor.getPaciente(p.getRG()));
                                            
                                            break;
                                        case 3:
                                            p = new Paciente();
                                            System.out.println("Digite o RG ou o Nome do Paciente:");                                            
                                            p = pacientesVetor.getPaciente(in.next().toUpperCase());
                                            
                                            System.out.println("Tem certeza que quer deletar o paciente:\n"+p);
                                            System.out.println("Digite sim para deletar (qualquer outro comando para cancelar):");
                                            if(in.next().toLowerCase().equals("sim")){
                                                pacientesVetor.removePaciente(p.getRG());
                                            }else{
                                                System.out.println("A remoção não ocorreu!");                                                       
                                            }   
                                            break;
                                        case 4:
                                            System.out.println("Digite o RG ou o Nome do Paciente:");                                            
                                            System.out.println(pacientesVetor.getPaciente(in.next().toUpperCase()));
                                            break;
                                        case 0:
                                            op = 0;
                                            break;
                                        default:
                                            System.out.println("Operação inválida!");
                                            break;
                                    }
                                }while(op==1);
                                op = 1;
                                break;
                            case "medicamentos":                                
                                Medicamento m;
                                medicamentosVetor.loadData(medicamentoCSV);
                                do{
                                    System.out.println("=>Medicamento");
                                    System.out.println("1 - Listar");
                                    System.out.println("2 - Cadastrar");
                                    System.out.println("3 - Remover");
                                    System.out.println("4 - Pesquisar");                                    
                                    System.out.println("0 - Sair");
                                    switch(in.nextInt()){
                                        case 1:
                                            System.out.println(medicamentosVetor.toString());
                                            break;
                                        case 2:
                                            m = new Medicamento();
                                            in.nextLine();
                                            System.out.println("Digite o nome do Medicamento:");
                                            m.setNome(in.nextLine());
                                            System.out.println("Digite o Codigo do Medicamento: ");
                                            m.setCode(in.next());
                                            
                                            medicamentosVetor.addMedicamento(m);
                                            System.out.println(medicamentosVetor.getMedicamento(m.getCode()));
                                            
                                            break;
                                        case 3:
                                            m = new Medicamento();
                                            System.out.println("Digite o Código ou o Nome do Medicamento:");                                            
                                            m = medicamentosVetor.getMedicamento(in.next().toUpperCase());
                                            
                                            System.out.println("Tem certeza que quer deletar o Medicamento:\n"+m);
                                            System.out.println("Digite sim para deletar (qualquer outro comando para cancelar):");
                                            if(in.next().toLowerCase().equals("sim")){
                                                medicamentosVetor.removeMedicamento(m.getCode());
                                            }else{
                                                System.out.println("A remoção não ocorreu!");                                                       
                                            }   
                                            break;
                                        case 4:
                                            System.out.println("Digite o Código ou o Nome do Medicamento:");                                            
                                            System.out.println(medicamentosVetor.getMedicamento(in.next().toUpperCase()));
                                            break;
                                        case 0:
                                            op = 0;
                                            break;
                                        default:
                                            System.out.println("Operação inválida!");
                                            break;
                                    }
                                }while(op==1);
                                op = 1;
                                break;
                            case "sair":
                                System.exit(0);
                            default:
                                System.out.println("Opção inválida!");
                                break;
                        }                       
                    }while(1==1);                     
                case "lista":
                    System.out.println("--> Lista Encadeada <--");
                    do{
                        System.out.println("Vocẽ deseja trabalhar nos medicamentos ou pacientes? \n(Digite sair para finalizar o programa)");
                        switch(in.next().toLowerCase()){
                            case "pacientes":
                                Paciente p;
                                pacientesLista.loadData(pacienteCSV);
                                do{
                                    System.out.println("=>Paciente");
                                    System.out.println("1 - Listar");
                                    System.out.println("2 - Cadastrar");
                                    System.out.println("3 - Remover");
                                    System.out.println("4 - Pesquisar");                                    
                                    System.out.println("0 - Sair");
                                    switch(in.nextInt()){
                                        case 1:
                                            System.out.println(pacientesLista.toString());
                                            break;
                                        case 2:
                                            p = new Paciente();
                                            in.nextLine();
                                            System.out.println("Digite o nome do Paciente:");
                                            p.setNome(in.nextLine());
                                            System.out.println("Digite o RG do Paciente: ");
                                            p.setRG(in.next());
                                            in.nextLine();
                                            System.out.println("Digite a data de aniversário do Paciente:");
                                            p.setDataNascimento(LocalDate.parse(in.nextLine()));
                                            
                                            pacientesLista.addPaciente(p);
                                            System.out.println(pacientesLista.getPaciente(p.getRG()));
                                            
                                            break;
                                        case 3:
                                            p = new Paciente();
                                            System.out.println("Digite o RG ou o Nome do Paciente:");                                            
                                            p = pacientesLista.getPaciente(in.next().toUpperCase());
                                            
                                            System.out.println("Tem certeza que quer deletar o paciente:\n"+p);
                                            System.out.println("Digite sim para deletar (qualquer outro comando para cancelar):");
                                            if(in.next().toLowerCase().equals("sim")){
                                                pacientesLista.removePaciente(p.getRG());
                                            }else{
                                                System.out.println("A remoção não ocorreu!");                                                       
                                            }   
                                            break;
                                        case 4:
                                            System.out.println("Digite o RG ou o Nome do Paciente:");                                            
                                            System.out.println(pacientesLista.getPaciente(in.next().toUpperCase()));
                                            break;
                                        case 0:
                                            op = 0;
                                            break;
                                        default:
                                            System.out.println("Operação inválida!");
                                            break;
                                    }
                                }while(op==1);
                                op = 1;
                                break;
                            case "medicamentos":                                
                                Medicamento m;
                                medicamentosLista.loadData(medicamentoCSV);
                                do{
                                    System.out.println("=>Medicamento");
                                    System.out.println("1 - Listar");
                                    System.out.println("2 - Cadastrar");
                                    System.out.println("3 - Remover");
                                    System.out.println("4 - Pesquisar");                                    
                                    System.out.println("0 - Sair");
                                    switch(in.nextInt()){
                                        case 1:
                                            System.out.println(medicamentosLista.toString());
                                            break;
                                        case 2:
                                            m = new Medicamento();
                                            in.nextLine();
                                            System.out.println("Digite o nome do Medicamento:");
                                            m.setNome(in.nextLine());
                                            System.out.println("Digite o Codigo do Medicamento: ");
                                            m.setCode(in.next());
                                            
                                            medicamentosLista.addMedicamento(m);
                                            System.out.println(medicamentosLista.getMedicamento(m.getCode()));
                                            
                                            break;
                                        case 3:
                                            m = new Medicamento();
                                            System.out.println("Digite o Código ou o Nome do Medicamento:");                                            
                                            m = medicamentosLista.getMedicamento(in.next().toUpperCase());
                                            
                                            System.out.println("Tem certeza que quer deletar o Medicamento:\n"+m);
                                            System.out.println("Digite sim para deletar (qualquer outro comando para cancelar):");
                                            if(in.next().toLowerCase().equals("sim")){
                                                medicamentosLista.removeMedicamento(m.getCode());
                                            }else{
                                                System.out.println("A remoção não ocorreu!");                                                       
                                            }   
                                            break;
                                        case 4:
                                            System.out.println("Digite o Código ou o Nome do Medicamento:");                                            
                                            System.out.println(medicamentosLista.getMedicamento(in.next().toUpperCase()));
                                            break;
                                        case 0:
                                            op = 0;
                                            break;
                                        default:
                                            System.out.println("Operação inválida!");
                                            break;
                                    }
                                }while(op==1);
                                op = 1;
                                break;
                            case "sair":
                                System.exit(0);
                            default:
                                System.out.println("Opção inválida!");
                                break;
                        }                       
                    }while(1==1);                   
                case "sair":
                    System.exit(0);
                default:
                    System.out.println("Opção inválida!");
                    
                    break;
            }
        }while(1==1);
        
    }

}
