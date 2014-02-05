package fr.istic.tpjpa.domain;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

@Entity
public class ElectronicDevice {
	
	private long id;
	private String name;
	private Person person;
	
	public ElectronicDevice(String name, Person p) {
		this.name = name;
		this.person = p;
	}
	
	@Id
    @GeneratedValue
	public long getId() {
		return this.id;
	}
	
	public void setId(long id) {
		this.id = id;
	}
	
	@ManyToOne
	public Person getPerson() {
		return this.person;
	}

	public void setPerson(Person p) {
		this.person = p;
	}

	public String getName() {
		return this.name;
	}

	public void setName(String name) {
		this.name = name;
	}

}
