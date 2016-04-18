package dao;

import csv.CSVFile;
import medicamento.Medicamento;

public interface MedicamentoDAO {
	
	public Medicamento getMedicamento(int codigo);
	
	public void addMedicamento(Medicamento medicamento);
	
	public void removeMedicamento(int codigo);
	
	public void loadData(CSVFile arquivo);

}
