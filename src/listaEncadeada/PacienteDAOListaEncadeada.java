package listaEncadeada;

import paciente.Paciente;
import csv.CSVFile;
import dao.PacienteDAO;
import datastructures.IteradorListaEncadeada;
import datastructures.ListaEncadeada;

public class PacienteDAOListaEncadeada implements PacienteDAO {
	private ListaEncadeada<Paciente> pacientes;
	
	@Override
	public Paciente getPaciente(String rg) {
		if(pacientes!=null){
			for (Paciente p : pacientes){
				if(rg.equals(p.getRG())){
					return p;
				}
			}			
		}else{
			throw new RuntimeException("Não existe nenhum Paciente cadastrado!");
		}
		return null;
	}

	@Override
	public void addPaciente(Paciente paciente) {
		if(paciente!=null){
			pacientes.append(paciente);
		}else{
			throw new RuntimeException("Nenhum Paciente informado!");
		}		
	}

	@Override
	public void removePaciente(String rg) {
		Paciente p = new Paciente();
		if(pacientes!=null){
			IteradorListaEncadeada<Paciente> iterador = pacientes.iterator();
			while(iterador.hasNext()){
				p = iterador.next();
				if(p.getRG().equals(rg)){
					iterador.remove();	
				}
				iterador.next();
			}
		}else{
			throw new RuntimeException("Não existe nenhum Paciente cadastrado!");
		}
	}

	@Override
	public void loadData(CSVFile arquivo) {
		
		
	}

}
