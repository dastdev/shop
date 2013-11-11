/**
 * 
 */
package de.webshop.artikelverwaltung.domain;

import java.math.BigDecimal;
import java.util.Date;
import javax.validation.constraints.DecimalMin;
import javax.validation.constraints.Future;
import javax.validation.constraints.NotNull;
import javax.xml.bind.annotation.XmlRootElement;

import org.hibernate.validator.constraints.NotEmpty;

/**
 * @author Stephan-PC
 * 
 */
@XmlRootElement
public class Artikelpreishistorie {

	// Eigenschaften
	@NotEmpty
	private long id;
	@NotEmpty
	private long artikelID;
	@Future
	@NotNull
	private Date gueltigVon;
	@DecimalMin("0.0")
	@NotNull
	private BigDecimal preis;

	// Konstruktor
	public Artikelpreishistorie(long artikelid, Date gueltigVon,
			BigDecimal preis) {
		super();
		this.artikelID = artikelid;
		this.gueltigVon = gueltigVon;
		this.preis = preis;
	}

	// get/set-Methoden
	public long getID() {
		return id;
	}

	public void setID(long id) {
		this.id = id;
	}

	public long getArtikelid() {
		return artikelID;
	}

	public void setArtikelid(long artikelid) {
		this.artikelID = artikelid;
	}

	public Date getGueltigVon() {
		return gueltigVon;
	}

	public void setGueltigVon(Date gueltigVon) {
		this.gueltigVon = gueltigVon;
	}

	public BigDecimal getPreis() {
		return preis;
	}

	public void setPreis(BigDecimal preis) {
		this.preis = preis;
	}

	// BasisMethoden
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + (int) (artikelID ^ (artikelID >>> 32));
		result = prime * result
				+ ((gueltigVon == null) ? 0 : gueltigVon.hashCode());
		result = prime * result + (int) (id ^ (id >>> 32));
		result = prime * result + ((preis == null) ? 0 : preis.hashCode());
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
		final Artikelpreishistorie other = (Artikelpreishistorie) obj;
		if (artikelID != other.artikelID)
			return false;
		if (gueltigVon == null) {
			if (other.gueltigVon != null)
				return false;
		} else if (!gueltigVon.equals(other.gueltigVon))
			return false;
		if (id != other.id)
			return false;
		if (preis == null) {
			if (other.preis != null)
				return false;
		} else if (!preis.equals(other.preis))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "Artikelpreishistorie [id=" + id + ", artikelid=" + artikelID
				+ ", gueltigVon=" + gueltigVon + ", preis=" + preis + "]";
	}
}
