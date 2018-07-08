package be.vdab.entities;

import java.io.Serializable;
import java.util.Collections;
import java.util.LinkedHashSet;
import java.util.Set;

import javax.persistence.CollectionTable;
import javax.persistence.ElementCollection;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OrderBy;
import javax.persistence.Table;

import be.vdab.valueobjects.Adres;
import be.vdab.valueobjects.TelefoonNr;

@Entity
@Table(name="campussen")
public class Campus implements Serializable{
	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private long Id;
	private String naam;
	private Adres adres;
	@ElementCollection
	@CollectionTable(name="campussentelefoonnrs", joinColumns = @JoinColumn(name="campusid"))
	@OrderBy("fax")
	private Set<TelefoonNr> telefoonNrs;
	
	protected Campus() {}

	public Campus(long id, String naam, Adres adres) {
		super();
		Id = id;
		this.naam = naam;
		this.adres = adres;
		telefoonNrs = new LinkedHashSet<>();
	}
	
	public Set<TelefoonNr> getTelefoonNrs() {
		return Collections.unmodifiableSet(telefoonNrs);
	}
	
	public void addTelefoonNr(TelefoonNr telefoonNr) {
		telefoonNrs.add(telefoonNr);
	}
	
	public void removeTelefoonNr(TelefoonNr telefoonNr) {
		telefoonNrs.remove(telefoonNr);
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
