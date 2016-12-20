package aboudou.samadou.metier.test;

import static org.junit.Assert.*;

import java.util.List;

import org.junit.Ignore;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.SpringApplicationConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;

import aboudou.samadou.ReservationAppApplication;
import aboudou.samadou.entities.Car;
import aboudou.samadou.entities.Client;
import aboudou.samadou.entities.Reservation;
import aboudou.samadou.metier.IMetier;

/**
 * Class to test the IMetier functions
 * 
 * @author absare
 *
 */
@RunWith(SpringJUnit4ClassRunner.class)
@SpringApplicationConfiguration(classes = ReservationAppApplication.class)
@WebAppConfiguration
public class MetierTest {

	// Log what happened inside test method
	final static Logger logger = LoggerFactory.getLogger(MetierTest.class);

	@Autowired
	private IMetier metier;

	@Test
	@Ignore
	public void testClients() {
		// Test the retrieval all clients
		List<Client> clients = metier.getAllClients();
		display("CLIENTS ", clients);

	}
	
	@Test
	@Ignore
	public void testCars() throws Exception {
		//Test the retrieval of all cars
		List<Car> cars = metier.getAllCars();
		Car carAdded = cars.get(0);
		metier.addCar(carAdded);
		assertEquals(carAdded, metier.findCarById(Long.valueOf(1)));
		//display("CARS ", cars);
	}
	
	@Test
	@Ignore
	public void testReservation() {
		//Test the retrieval of all reservations
		List<Reservation> reservations = metier.getAllReservations();
		display("RESERVATIONS", reservations);
	}
	
	

	public void display(String message, Iterable<?> elements) {
		logger.info(message);
		for (Object element : elements) {
			logger.info(element.toString());
		}
	}

}
