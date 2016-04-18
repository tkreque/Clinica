package listaEncadeada;

import medicamento.Medicamento;
import csv.CSVFile;
import dao.MedicamentoDAO;

public class MedicamentoDAOListaEncadeada implements MedicamentoDAO {
	private ListaEncadeada<Medicamento> medicamentos;
	
	@Override
	public Medicamento getMedicamento(int codigo) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void addMedicamento(Medicamento medicamento) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void removeMedicamento(int codigo) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void loadData(CSVFile arquivo) {
		// TODO Auto-generated method stub
		
	}

}
