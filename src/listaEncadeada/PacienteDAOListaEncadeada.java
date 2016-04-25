package listaEncadeada;

import paciente.Paciente;
import csv.CSVFile;
import dao.PacienteDAO;
import datastructures.Iterador;
import datastructures.ListaEncadeada;
import java.util.ArrayList;
import paciente.PacienteParser;

public class PacienteDAOListaEncadeada implements PacienteDAO {
    private ListaEncadeada<Paciente> pacientes = new ListaEncadeada<>();

    @Override
    public Paciente getPaciente(String rg) {
       if(pacientes!=null){
           for(Paciente p: pacientes){
               if((p.getRG().toUpperCase().equals(rg)) || (p.getNome().toUpperCase().contains(rg))){
                   return p;
               }
           }           
        }else{
           throw new RuntimeException("Não existe nenhum paciente na lista!");
       }
       return null;
    }
    

    @Override
    public void addPaciente(Paciente paciente) {
        if(paciente != null){
            pacientes.append(paciente);
        }else{
           throw new RuntimeException("O paciente está em branco, não é possível cadastrar!");
       }
    }

    @Override
    public void removePaciente(String rg) {
        if(pacientes != null){
            Iterador<Paciente> it = pacientes.iterator();
            for(Paciente p: pacientes){
               if(p.getRG().toUpperCase().equals(rg)){
                   it.remove();
               }
               it.next();
            }
        }else{
           throw new RuntimeException("Não existe nenhum paciente na lista!");
       }
    }

    @Override
    public void loadData(CSVFile arquivo) {
        try{
            //String pacienteFile = "C:\\Users\\631301442\\Desktop\\Clinica\\Files\\pacientes.csv";
            String pacienteFile = "/home/reque/Codes/Clinica/Files/pacientes.csv";
            PacienteParser pacienteParser = new PacienteParser();
            ArrayList<Paciente> lista;

            arquivo.open(pacienteFile);
            arquivo.setParser(pacienteParser);

            lista = arquivo.readObject();
            for(int i=0;i<lista.size();i++){
                pacientes.append(lista.get(i));
                pacientes = ordenacao();
            }
            arquivo.close();            
        }catch(Exception ex){
            throw new RuntimeException("Não foi possível carregar os dados: "+ex);
        }
    }

    @Override
    public String toString() {
        String s = "<--- LISTA DE PACIENTES --->";
        for(Paciente p : pacientes){
            s = s+"\n"+p;
        }
        s = s+"\n---> FIM DA LISTA <---";
        return s;
    }
    
    public ListaEncadeada<Paciente> ordenacao(){
        ListaEncadeada<Paciente> pacientesNew = new ListaEncadeada<>();

        for (Paciente p : pacientes) {
            Iterador<Paciente> eleito = pacientes.iterator();
            Paciente aux;
            
            while(eleito.hasNext()){
                int resu = p.compareTo(eleito.next());
                if (resu == 1){
                    aux = eleito.next();
                    pacientesNew.append(aux);
                    pacientesNew.prepend(p);
                }else{
                    if(resu == -1){
                        aux = p;
                        pacientesNew.append(aux);
                        pacientesNew.prepend(eleito.next());
                    }
                }
                eleito.next();
            }
        }
        return pacientesNew;
    }
}
