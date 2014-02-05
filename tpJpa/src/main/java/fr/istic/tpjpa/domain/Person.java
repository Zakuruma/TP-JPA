package fr.istic.tpjpa.domain;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;

@Entity
public class Person {

	private long id;
	private String name;
	private String firstName;
	private String genre;
	private String profile;
	private String birthDate;
    private List<Home> homes = new ArrayList<Home>();
    private List<Person> friends = new ArrayList<Person>();
    private List<ElectronicDevice> devices = new ArrayList<ElectronicDevice>();

	

	public Person(String name, String firstName, String genre,
			String profile, String birthDate) {
		this.name = name;
		this.firstName = firstName;
		this.genre = genre;
		this.profile = profile;
		this.birthDate = birthDate;
	}

	@Id
    @GeneratedValue
	public long getId() {
		return this.id;
	}

	@Override
	public String toString() {
		return "Person [idPerson=" + this.id + ", name=" + this.name
				+ ", firstName=" + this.firstName + ", genre=" + this.genre
				+ ", profile=" + this.profile + ", birthDate=" + this.birthDate + "]";
	}

	public void setId(long id) {
		this.id = id;
	}


	public String getName() {
		return this.name;
	}


	public void setName(String name) {
		this.name = name;
	}


	public String getFirstName() {
		return this. firstName;
	}


	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}


	public String getGenre() {
		return this.genre;
	}


	public void setGenre(String genre) {
		this.genre = genre;
	}


	public String getProfile() {
		return this.profile;
	}


	public void setProfile(String profile) {
		this.profile = profile;
	}


	public String getDateNaiss() {
		return this.birthDate;
	}


	public void setDateNaiss(String birthDate) {
		this.birthDate = birthDate;
	}
	
    @OneToMany(mappedBy = "person", cascade = CascadeType.PERSIST)
    public List<Home> getHomes() {
        return this.homes;

    }

    public void setHomes(List<Home> homes) {
        this.homes = homes;
    }
    
    @OneToMany
    @JoinTable(name="FRIENDS")
	public List<Person> getFriends() {
		return friends;
	}

	public void setFriends(List<Person> friends) {
		this.friends = friends;
	}
	
    @OneToMany(mappedBy = "person", cascade = CascadeType.PERSIST)
    public List<ElectronicDevice> getDevices() {
        return this.devices;

    }

    public void setDevices(List<ElectronicDevice> devices) {
        this.devices = devices;
    }
	
}
