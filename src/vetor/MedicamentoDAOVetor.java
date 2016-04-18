package vetor;

import medicamento.Medicamento;
import csv.CSVFile;
import dao.MedicamentoDAO;
import datastructures.Vetor;

public class MedicamentoDAOVetor implements MedicamentoDAO{
	private Vetor<Medicamento> medicamentos;
	
	@Override
	public Medicamento getMedicamento(String codigo) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void addMedicamento(Medicamento medicamento) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void removeMedicamento(String codigo) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void loadData(CSVFile arquivo) {
		// TODO Auto-generated method stub
		
	}

}
