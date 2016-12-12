package aboudou.samadou.entities;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;


@Entity
@Table(name = "cars", uniqueConstraints=@UniqueConstraint(name="matricule_car_uc", 
columnNames="matricule"))
public class Car implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;
	@Column(name="matricule", unique=true)
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

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + (disponibilite ? 1231 : 1237);
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		result = prime * result + ((marque == null) ? 0 : marque.hashCode());
		result = prime * result + ((matricule == null) ? 0 : matricule.hashCode());
		result = prime * result + place;
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
		Car other = (Car) obj;
		if (disponibilite != other.disponibilite)
			return false;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		if (marque == null) {
			if (other.marque != null)
				return false;
		} else if (!marque.equals(other.marque))
			return false;
		if (matricule == null) {
			if (other.matricule != null)
				return false;
		} else if (!matricule.equals(other.matricule))
			return false;
		if (place != other.place)
			return false;
		return true;
	}

	
}
