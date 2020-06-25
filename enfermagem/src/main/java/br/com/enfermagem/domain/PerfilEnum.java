package br.com.enfermagem.domain;

public enum PerfilEnum {

	A ("Administrado"),
	U ( "Usuário");

	private final String perfil;

	PerfilEnum(String perfil){
		this.perfil = perfil;
	}

	public String getPerfil() {
		return perfil;
	}

}
