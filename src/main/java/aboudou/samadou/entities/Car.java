package aboudou.samadou.entities;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "cars")
public class Car implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;
	private String matricule;
	private String marque;
	private int place;
	private boolean disponibilite;

	public Car() {

	}

	public Car(String matricule, String marque, int place, boolean disponibilite) {
		super();
		this.matricule = matricule;
		this.marque = marque;
		this.place = place;
		this.disponibilite = disponibilite;
	}

	
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getMatricule() {
		return matricule;
	}

	public void setMatricule(String matricule) {
		this.matricule = matricule;
	}

	public String getMarque() {
		return marque;
	}

	public void setMarque(String marque) {
		this.marque = marque;
	}

	public int getPlace() {
		return place;
	}

	public void setPlace(int place) {
		this.place = place;
	}

	public boolean isdisponibilite() {
		return disponibilite;
	}

	public void setdisponibilite(boolean disponibilite) {
		this.disponibilite = disponibilite;
	}

	@Override
	public String toString() {
		return "Car [id=" + id + ", matricule=" + matricule + ", marque=" + marque + ", place=" + place
				+ ", disponibilite=" + disponibilite + "]";
	}

	
}
