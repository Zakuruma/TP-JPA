package fr.istic.tpjpa.domain;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

@Entity
public class Home {

	private long id;
	private String adresse;
	private String superficie;
	private String ip;
	private Person person;
    private List<Heater> heaters = new ArrayList<Heater>();


	
	public Home(String adresse, String superficie, String ip, Person p) {
		this.adresse = adresse;
		this.superficie = superficie;
		this.ip = ip;
		this.person = p;
	}
	
	@Override
	public String toString() {
		return "Home [id=" + this.id + ", adresse=" + this.adresse
				+ ", superficie=" + this.superficie + ", ip=" + this.ip + ", person=" + this.person.getName() + "]";
	}
	
	@Id
    @GeneratedValue
	public long getId() {
		return this.id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getAdresse() {
		return adresse;
	}
	
	public void setAdresse(String adresse) {
		this.adresse = adresse;
	}
	
	public String getSuperficie() {
		return superficie;
	}
	
	public void setSuperficie(String superficie) {
		this.superficie = superficie;
	}
	
	public String getIp() {
		return this.ip;
	}
	
	public void setIp(String ip) {
		this.ip = ip;
	}
	
	@ManyToOne
	public Person getPerson() {
		return this.person;
	}

	public void setPerson(Person p) {
		this.person = p;
	}
	
    @OneToMany(mappedBy = "person", cascade = CascadeType.PERSIST)
    public List<Heater> getHeaters() {
        return this.heaters;

    }

    public void setHeaters(List<Heater> heaters) {
        this.heaters = heaters;
    }

}
