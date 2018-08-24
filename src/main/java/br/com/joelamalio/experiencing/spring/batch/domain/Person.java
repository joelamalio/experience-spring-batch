package br.com.joelamalio.experiencing.spring.batch.domain;

import java.io.Serializable;
import java.util.Date;

public class Person implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private String name;
	private Date birthday;
	private Sex sex;
	
	public Person() {
	}
	
	public Person(String name, Date birthday, Sex sex) {
		super();
		this.name = name;
		this.birthday = birthday;
		this.sex = sex;
	}



	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Date getBirthday() {
		return birthday;
	}

	public void setBirthday(Date birthday) {
		this.birthday = birthday;
	}

	public Sex getSex() {
		return sex;
	}

	public void setSex(Sex sex) {
		this.sex = sex;
	}

	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("Person [name=");
		builder.append(name);
		builder.append(", birthday=");
		builder.append(birthday);
		builder.append(", sex=");
		builder.append(sex);
		builder.append("]");
		return builder.toString();
	}

}
