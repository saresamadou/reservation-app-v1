package aboudou.samadou.metier;

import java.util.List;

import aboudou.samadou.entities.Car;
import aboudou.samadou.entities.Client;
import aboudou.samadou.entities.Reservation;

public interface IMetier
{
	public List<Client> getAllClients();
	
	public List<Car> getAllCars();
	
	public List<Reservation> getAllReservations();
	
	public void addCar(Car car);
}
