package aboudou.samadou.metier;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.google.common.collect.Lists;

import aboudou.samadou.entities.Car;
import aboudou.samadou.entities.Client;
import aboudou.samadou.entities.Reservation;
import aboudou.samadou.exceptions.CarAlreadyExistsException;
import aboudou.samadou.repositories.CarRepository;
import aboudou.samadou.repositories.ClientRepository;
import aboudou.samadou.repositories.ReservationRepository;

@Service("métier")
public class Metier implements IMetier {
	// repositories
	@Autowired
	private CarRepository carRepository;
	@Autowired
	private ClientRepository clientRepository;
	@Autowired
	private ReservationRepository reservationRepository;

	@Override
	public List<Client> getAllClients() {
		return Lists.newArrayList(clientRepository.findAll());
	}

	@Override
	public List<Car> getAllCars() {
		return Lists.newArrayList(carRepository.findAll());
	}

	@Override
	public List<Reservation> getAllReservations() {
		return Lists.newArrayList(reservationRepository.findAll());
	}

	@Override
	public void addCar(Car car) throws CarAlreadyExistsException {

		if (carRepository.findByMarque(car.getMarque()) != null) {
			throw new CarAlreadyExistsException("THIS CAR ALREADY EXISTS");
		} else {
			carRepository.saveAndFlush(car);
		}

	}

	@Override
	public void addClient(Client client) {
		clientRepository.saveAndFlush(client);
	}

	@Override
	public Client findClientByEmail(String email) {

		return clientRepository.findByEmail(email);
	}

	@Override
	public void changeCarDisponibility(Car car) {
		carRepository.save(car);

	}

	@Override
	public void addReservation(Reservation reservation) {
		reservationRepository.saveAndFlush(reservation);

	}

	@Override
	public Car findCarById(Long id) {

		return carRepository.findOne(id);
	}

}
