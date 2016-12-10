package aboudou.samadou.entities;

import java.io.Serializable;
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
public class Reservation implements Serializable
{
	private static final long serialVersionUID=1L;

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private Long id;
	
	@Column(name="date")
	@Temporal(javax.persistence.TemporalType.DATE)
	private Date date = new java.sql.Date(new java.util.Date().getTime());
	
	//fetch=FetchType.LAZY
	@ManyToOne(fetch=FetchType.EAGER)
	@JoinColumn(name="id_car")
	private Car car;
	
	@ManyToOne(fetch=FetchType.EAGER)
	@JoinColumn(name="id_client")
	public Client client;
	
	@Column(name = "id_client", insertable = false, updatable = false)
	private Long idClient;
	@Column(name = "id_car", insertable = false, updatable = false)
	private Long idCar;
	
	
	public Reservation()
	{
		
	}


	public Reservation(Long id, Date date, Car car, Client client, Long idClient, Long idCar) {
		super();
		this.id = id;
		this.date = date;
		this.car = car;
		this.client = client;
		this.idClient = idClient;
		this.idCar = idCar;
	}


	public Date getDate() {
		return date;
	}


	public void setDate(Date date) {
		this.date = date;
	}


	public Long getIdClient() {
		return idClient;
	}


	public void setIdClient(Long idClient) {
		this.idClient = idClient;
	}


	public Long getIdCar() {
		return idCar;
	}


	public void setIdCar(Long idCar) {
		this.idCar = idCar;
	}


	public Long getId() {
		return id;
	}


	public void setId(Long id) {
		this.id = id;
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


	@Override
	public String toString() {
		return "Reservation [id=" + id + ", date=" + date + ", car=" + car + ", client=" + client + ", idClient="
				+ idClient + ", idCar=" + idCar + "]";
	}
	
	
	
}
