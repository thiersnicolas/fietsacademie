package be.vdab.entities;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import be.vdab.valueobjects.Adres;

@Entity
@Table(name="campussen")
public class Campus implements Serializable{
	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private long Id;
	private String naam;
	private Adres adres;
	
	protected Campus() {}

	public Campus(long id, String naam, Adres adres) {
		super();
		Id = id;
		this.naam = naam;
		this.adres = adres;
	}


	public long getId() {
		return Id;
	}

	public String getNaam() {
		return naam;
	}

	public Adres getAdres() {
		return adres;
	}
	
	

}
