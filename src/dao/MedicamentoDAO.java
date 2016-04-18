package dao;

import csv.CSVFile;
import medicamento.Medicamento;

public interface MedicamentoDAO<T> {
	
	public Medicamento getMedicamento(String codigo);
	
	public void addMedicamento(Medicamento medicamento);
	
	public void removeMedicamento(String codigo);
	
	public void loadData(CSVFile arquivo);

}
