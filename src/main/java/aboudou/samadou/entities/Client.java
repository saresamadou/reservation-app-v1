package aboudou.samadou.entities;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import com.google.common.base.Objects;

/**
 * @author absare
 *
 */
@Entity
@Table(name = "clients")
public class Client implements Serializable {
	/** Serial number used for serialisation/deserialisation */
	private static final long serialVersionUID = 1L;
	// Fields
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;
	private String name;
	private String email;
	private String addresse;
	private Long phone;

	// Default constructor
	public Client() {
		super();
	}

	// Constructor with arguments
	public Client(String name, String email, String addresse, Long phone) {
		this.name = name;
		this.email = email;
		this.addresse = addresse;
		this.phone = phone;
	}

	/* Getters and setters */

	public String getName() {
		return name;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getAddresse() {
		return addresse;
	}

	public void setAddresse(String addresse) {
		this.addresse = addresse;
	}

	public Long getPhone() {
		return phone;
	}

	public void setPhone(Long phone) {
		this.phone = phone;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see java.lang.Object#hashCode()
	 */
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((addresse == null) ? 0 : addresse.hashCode());
		result = prime * result + ((email == null) ? 0 : email.hashCode());
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		result = prime * result + ((name == null) ? 0 : name.hashCode());
		result = prime * result + ((phone == null) ? 0 : phone.hashCode());
		return result;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see java.lang.Object#equals(java.lang.Object)
	 */
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Client other = (Client) obj;

		return Objects.equal(addresse, other.addresse) && Objects.equal(email, other.email)
				&& Objects.equal(id, other.id) && Objects.equal(name, other.name) && Objects.equal(phone, other.phone);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		StringBuilder result = new StringBuilder();
		result.append("Client [id=");
		result.append(this.id);
		result.append(", name=");
		result.append(this.name);
		result.append(", email=");
		result.append(this.email);
		result.append(", addresse=");
		result.append(this.addresse);
		result.append(", phone=");
		result.append(this.phone);
		result.append("]");
		return result.toString();
	}

}
