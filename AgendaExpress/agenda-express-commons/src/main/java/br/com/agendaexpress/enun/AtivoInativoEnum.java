package br.com.agendaexpress.enun;

public enum AtivoInativoEnum {
	ATIVO("S"),

	INATIVO("N"),

	PENDENTE("P");

	private String value;

	AtivoInativoEnum(String value) {
		this.value = value;
	}

	public String getValue() {
		return value;
	}

	public void setValue(String value) {
		this.value = value;
	}

}
