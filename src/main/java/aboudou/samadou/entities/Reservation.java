package aboudou.samadou.entities;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;

@Entity
@Table(name="reservations")
public class Reservation
{
	private static final Long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private Long id;
	
	@Temporal(javax.persistence.TemporalType.DATE)
	private Date date;
	
	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumn(name="id_car")
	private Car car;
	
	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumn(name="id_client")
	private Client client;
	
	@Column(name = "id_client", insertable = false, updatable = false)
	private Long idClient;
	@Column(name = "id_car", insertable = false, updatable = false)
	private Long idCar;
	
	
	public Reservation()
	{
		
	}


	public Reservation(Car car, Client client)
	{
		this.car = car;
		this.client = client;
	}


	public Car getCar()
	{
		return car;
	}


	public void setCar(Car car)
	{
		this.car = car;
	}


	public Client getClient()
	{
		return client;
	}


	public void setClient(Client client)
	{
		this.client = client;
	}
	
	
}
