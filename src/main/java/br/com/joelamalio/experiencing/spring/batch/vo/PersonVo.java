package br.com.joelamalio.experiencing.spring.batch.vo;

import java.io.Serializable;

public class PersonVo implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private String name;
	private String birthday;
	private String sex;
	
	public PersonVo() {
	}
	
	public PersonVo(String name, String birthday, String sex) {
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

	public String getBirthday() {
		return birthday;
	}

	public void setBirthday(String birthday) {
		this.birthday = birthday;
	}

	public String getSex() {
		return sex;
	}

	public void setSex(String sex) {
		this.sex = sex;
	}

	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("PersonVo [");
		builder.append(name);
		builder.append("; ");
		builder.append(birthday);
		builder.append("; ");
		builder.append(sex);
		builder.append("]");
		return builder.toString();
	}

}
