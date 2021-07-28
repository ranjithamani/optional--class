package com.xworkz.optional.rogi.dto;

import java.io.Serializable;
import java.util.Comparator;

public class RogiDTO implements Serializable,Comparable<RogiDTO>{
	private int id;
	private String  name;
	private int age;
	private String disease;
	private boolean badukuGuarantee;
	
	public RogiDTO() {
		
	}
@Override
public int compareTo(RogiDTO o) {
	Integer temp = o.getAge();
	if (this.age == 0)
		return 0;
	if (this.age> 0)
		return 1;
	if (this.age< 0)
		return -1;
	return 0;

}

	public RogiDTO(int id, String name, int age, String disease, boolean badukuGuarantee) {
		super();
		this.id = id;
		this.name = name;
		this.age = age;
		this.disease = disease;
		this.badukuGuarantee = badukuGuarantee;
	}

	@Override
	public String toString() {
		return "RogiDTO [id=" + id + ", name=" + name + ", age=" + age + ", disease=" + disease + ", badukuGuarantee="
				+ badukuGuarantee + "]";
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + id;
		result = prime * result + ((name == null) ? 0 : name.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		RogiDTO other = (RogiDTO) obj;
		if (id != other.id)
			return false;
		if (name == null) {
			if (other.name != null)
				return false;
		} else if (!name.equals(other.name))
			return false;
		return true;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	public String getDisease() {
		return disease;
	}

	public void setDisease(String disease) {
		this.disease = disease;
	}

	public boolean isBadukuGuarantee() {
		return badukuGuarantee;
	}

	public void setBadukuGuarantee(boolean badukuGuarantee) {
		this.badukuGuarantee = badukuGuarantee;
	}

}
