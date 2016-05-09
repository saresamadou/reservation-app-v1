package aboudou.samadou.entities;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;


@Entity
@Table(name="clients")
public class Client implements Serializable
{
	private static final long serialVersionUID = 1L;
	//Fields
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private Long id;
	private String name;
	private String email;
	private String addresse;
	private Long phone;
	
	public Client()
	{
		
	}
	
	//Constructor with arguments
	public Client(String name, String email, String addresse, Long phone)
	{
		this.name = name;
		this.email = email;
		this.addresse = addresse;
		this.phone = phone;
	}

	/*Getters and setters*/
	
	public String getName()
	{
		return name;
	}

	public void setName(String name)
	{
		this.name = name;
	}

	public String getEmail()
	{
		return email;
	}

	public void setEmail(String email)
	{
		this.email = email;
	}

	public String getAddresse()
	{
		return addresse;
	}

	public void setAddresse(String addresse)
	{
		this.addresse = addresse;
	}

	public Long getPhone()
	{
		return phone;
	}

	public void setPhone(Long phone)
	{
		this.phone = phone;
	}

}
