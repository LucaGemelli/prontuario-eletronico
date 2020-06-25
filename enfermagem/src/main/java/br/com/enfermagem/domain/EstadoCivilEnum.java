package br.com.enfermagem.domain;

public enum EstadoCivilEnum {

	S ("Solteiro"),
	C ("Casado"),
	D ("Divorciado");

 	private final String estadoCivil;

	EstadoCivilEnum(String estadoCivil){
		this.estadoCivil = estadoCivil;
	}

	public String getEstadoCivil() {
		return estadoCivil;
	}

}
