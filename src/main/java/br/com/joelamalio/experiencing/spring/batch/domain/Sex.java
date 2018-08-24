package br.com.joelamalio.experiencing.spring.batch.domain;

public enum Sex {

	MALE("M", "Male"), FEMALE("F", "Female");

	private final String id;
	private final String description;

	private Sex(String id, String description) {
		this.id = id;
		this.description = description;
	}

	public String getId() {
		return id;
	}

	public String getDescription() {
		return description;
	}
	
	public static Sex get(String value) {
		for (Sex sex : values()) {
			if (sex.id.equalsIgnoreCase(value) || sex.description.equalsIgnoreCase(value)) {
				return sex;
			}
		}
		return null;
	}
	
	@Override
	public String toString() {
		return id;
	}

}
