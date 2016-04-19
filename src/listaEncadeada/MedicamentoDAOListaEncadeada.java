package listaEncadeada;

import medicamento.Medicamento;
import csv.CSVFile;
import dao.MedicamentoDAO;
import datastructures.Iterador;
import datastructures.ListaEncadeada;
import java.util.ArrayList;
import medicamento.MedicamentoParser;

public class MedicamentoDAOListaEncadeada implements MedicamentoDAO {
    private ListaEncadeada<Medicamento> medicamentos = new ListaEncadeada<>();

    @Override
    public Medicamento getMedicamento(String codigo) {
        if(medicamentos!=null){
            for(Medicamento m: medicamentos){
               if((m.getCode().toUpperCase().equals(codigo.toUpperCase())) || (m.getNome().toUpperCase().contains(codigo.toUpperCase()))){
                   return m;
               }
            }           
        }else{
            throw new RuntimeException("Não existe nenhum medicamento na lista!");
        }

        return null;
    }

    @Override
    public void addMedicamento(Medicamento medicamento) {
        if(medicamento != null){
            medicamentos.append(medicamento);
        }else{
           throw new RuntimeException("O medicamento está em branco, não é possível cadastrar!");
       }

    }

    @Override
    public void removeMedicamento(String codigo) {
        if(medicamentos != null){
            Iterador<Medicamento> it = medicamentos.iterator();
            for(Medicamento m: medicamentos){
               if((m.getCode().toUpperCase().equals(codigo.toUpperCase()))){
                   it.remove();
               }
               it.next();
            }
        }else{
           throw new RuntimeException("Não existe nenhum medicamento na lista!");
        }

    }

    @Override
    public void loadData(CSVFile arquivo) {
    try{
        //String pacienteFile = "C:\\Users\\631301442\\Desktop\\Clinica\\Files\\medicamentos.csv";
        String medicamentoFile = "/home/reque/Codes/Clinica/Files/medicamentos.csv";
        MedicamentoParser medicamentoParser = new MedicamentoParser();
        ArrayList<Medicamento> lista;

        arquivo.open(medicamentoFile);
        arquivo.setParser(medicamentoParser);

        lista = arquivo.readObject();
        for(int i=0;i<lista.size();i++){
            medicamentos.append(lista.get(i));
        }

        arquivo.close();
    }catch(Exception ex){
        throw new RuntimeException("Não foi possível carregar os dados: "+ex);
    }

    }
        
    @Override
    public String toString() {
         String s = "<--- LISTA DE MEDICAMENTOS --->";
        for(Medicamento p : medicamentos){
            s = s+"\n"+p;
        }
        s = s+"\n---> FIM DA LISTA <---";
        return s;
    }

}
