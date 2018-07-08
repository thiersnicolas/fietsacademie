package be.vdab.valueobjects;

import java.io.Serializable;

import javax.persistence.Embeddable;

@Embeddable
public class TelefoonNr implements Serializable{
	private static final long serialVersionUID = 1L;
	private String nummer;
	private boolean fax;
	private String opmerking;
	
	public TelefoonNr(String nummer, boolean fax, String opmerking) {
		this.nummer = nummer;
		this.fax = fax;
		this.opmerking = opmerking;
	}
	
	protected TelefoonNr() {}

	public String getNummer() {
		return nummer;
	}

	public boolean isFax() {
		return fax;
	}

	public String getOpmerking() {
		return opmerking;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((nummer == null) ? 0 : nummer.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}
		if (obj == null) {
			return false;
		}
		if (!(obj instanceof TelefoonNr)) {
			return false;
		}
		TelefoonNr other = (TelefoonNr) obj;
		if (nummer == null) {
			if (other.nummer != null) {
				return false;
			}
		} else if (!nummer.equals(other.nummer)) {
			return false;
		}
		return true;
	}
	
	

}
