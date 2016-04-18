package medicamento;

import csv.CSVParser;


public class MedicamentoParser implements CSVParser {
	
	@Override
    public Medicamento parseObject(String dados) {
        String[] array = dados.split(";");
        Medicamento m = new Medicamento(array[0], array[1]);
        return m;
    }
	
	
}
