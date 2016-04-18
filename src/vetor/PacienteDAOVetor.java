package vetor;

import csv.CSVFile;
import dao.PacienteDAO;
import datastructures.Vetor;
import paciente.Paciente;

public class PacienteDAOVetor implements PacienteDAO {
	private Vetor<Paciente> pacientes;

	@Override
	public Paciente getPaciente(String rg) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void addPaciente(Paciente paciente) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void removePaciente(String rg) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void loadData(CSVFile arquivo) {
		// TODO Auto-generated method stub
		
	}
}
