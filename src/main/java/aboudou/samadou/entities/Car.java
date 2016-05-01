package aboudou.samadou.entities;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="cars")
public class Car
{
	private static final long serialVersionUID=1L;
	
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private Long id;
	private String matricule;
	private String marque;
	
	public Car()
	{
		
	}

	public Car(String matricule, String marque)
	{
		super();
		this.matricule = matricule;
		this.marque = marque;
	}

	public String getMatricule()
	{
		return matricule;
	}

	public void setMatricule(String matricule)
	{
		this.matricule = matricule;
	}

	public String getMarque()
	{
		return marque;
	}

	public void setMarque(String marque)
	{
		this.marque = marque;
	}
	
	
}
