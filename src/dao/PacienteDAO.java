package dao;

import csv.CSVFile;
import paciente.Paciente;

public interface PacienteDAO {

	public Paciente getPaciente(String rg);
	
	public void addPaciente(Paciente paciente);
	
	public void removePaciente(String rg);
	
	public void loadData(CSVFile arquivo);
}
