package br.com.enfermagem.domain;

public enum SexoEnum {

	M ("Masculino"),
	F ("Feminino"),
	I ("Indefinido");

 	private final String sexo;

	SexoEnum(String sexo){
		this.sexo = sexo;
	}

	public String getSexo() {
		return sexo;
	}

}
