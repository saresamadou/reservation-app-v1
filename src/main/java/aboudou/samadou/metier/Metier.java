package aboudou.samadou.metier;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.google.common.collect.Lists;

import aboudou.samadou.entities.Car;
import aboudou.samadou.entities.Client;
import aboudou.samadou.entities.Reservation;
import aboudou.samadou.repositories.CarRepository;
import aboudou.samadou.repositories.ClientRepository;
import aboudou.samadou.repositories.ReservationRepository;

@Service("métier")
public class Metier implements IMetier
{
	//repositories
	@Autowired
	private CarRepository carRepository;
	@Autowired
	private ClientRepository clientRepository;
	@Autowired
	private ReservationRepository reservationRepository;
	
	@Override
	public List<Client> getAllClients()
	{
		return Lists.newArrayList(clientRepository.findAll());
	}

	@Override
	public List<Car> getAllCars()
	{
		return Lists.newArrayList(carRepository.findAll());
	}

	@Override
	public List<Reservation> getAllReservations()
	{
		return Lists.newArrayList(reservationRepository.findAll());
	}

	@Override
	public void addCar(Car car) {
		// TODO Auto-generated method stub
		
	}

}
