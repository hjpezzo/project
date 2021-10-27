package br.com.harley.project.enums;

public enum Folder {

	HEALTH("HEALTH"), EDUCATION("EDUCATION"), SPORTS("SPORTS"), INFRASTRUCTURE("INFRASTRUCTURE");

	private final String value;

	Folder(String value) {
		this.value = value;
	}

	public String getValue() {
		return value;
	}

}
