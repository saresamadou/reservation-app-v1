package aboudou.samadou.services;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import aboudou.samadou.entities.Car;
import aboudou.samadou.exceptions.CarAlreadyExistsException;
import aboudou.samadou.metier.Metier;

@RestController
@RequestMapping("/cars")
@CrossOrigin
public class CarService {

	static final Logger logger = LoggerFactory.getLogger(CarService.class);

	private static final Integer CAR_ALREADY_EXIST = 300;

	private static final Integer CAR_SUCCESSFULLY_ADDED = 200;

	@Autowired
	private Metier metier;

	@RequestMapping(value = "/getCars", method = RequestMethod.GET)
	public List<Car> getAllCars() {
		return metier.getAllCars();
	}

	@RequestMapping(value = "/addCar", method = RequestMethod.POST)
	@ResponseBody
	public Integer addNewCar(@RequestBody Car newCar) {

		if (newCar == null) {
			logger.info("You must give me a Car");
			return null;
		} else {
			try {
				metier.addCar(newCar);
				logger.info("New car successfuly added !");
				return CAR_SUCCESSFULLY_ADDED;
			} catch (CarAlreadyExistsException e) {
				logger.info(e.getMessage());
				return CAR_ALREADY_EXIST;

			}

		}

	}

	// TODO : Method to update a car properties

	// TODO : Method to delete a car from database

	// TODO : Method to get car by Id
}
