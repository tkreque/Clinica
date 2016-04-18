package medicamento;

public class Medicamento {
	private String code;
	private String nome;
	
	public Medicamento() {
	}

	public Medicamento(String code, String nome) {
		this.code = code;
		this.nome = nome;
	}

	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	@Override
	public String toString() {
		return "Medicamento [code=" + code + ", nome=" + nome + "]";
	}
	
	
	
}
