package aboudou.samadou.metier;

import java.util.List;



import aboudou.samadou.entities.Car;
import aboudou.samadou.entities.Client;
import aboudou.samadou.entities.Reservation;
import aboudou.samadou.exceptions.CarAlreadyExistsException;

public interface IMetier
{
	/** Retrieve all clients from DB*/
	public List<Client> getAllClients();
	
	/** Retrieve all Cars from DB*/
	public List<Car> getAllCars();
	
	/** Retrieve all reservations from DB*/
	public List<Reservation> getAllReservations();
	
	/** Method to add a new  car into DB*/
	public void addCar(Car car) throws CarAlreadyExistsException;
	
	/** Method to add a new  client into DB*/
	public void addClient(Client client);
	
	/** Method to find a  client by his email*/
	Client findClientByEmail(String email);
	
	/** Method to change car disponibility */
	void changeCarDisponibility(Car car);
	
	/** Method to add a new  reservation into DB*/
	public void addReservation(Reservation reservation);
	
	/** Method to find a car by it id DB*/
	public Car findCarById(Long id);
}
