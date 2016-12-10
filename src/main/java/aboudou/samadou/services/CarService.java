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
import aboudou.samadou.metier.Metier;
import aboudou.samadou.repositories.CarRepository;

@RestController
@RequestMapping("/cars")
@CrossOrigin
public class CarService {

	final static Logger logger = LoggerFactory.getLogger(CarService.class);
	
	@Autowired
	private Metier metier;
	
	@RequestMapping(value="/getCars", method=RequestMethod.GET)
	public List<Car> getAllCars()
	{
		return metier.getAllCars();
	}
	
	@RequestMapping(value = "/addCar", method = RequestMethod.POST)
	public @ResponseBody Car addNewCar(@RequestBody Car newCar)
	{
		logger.info(newCar.toString());
		
		if(newCar.equals(null))
		{
			logger.info("You must give me a Car");
			return null;
		} else {
			metier.addCar(newCar);
			logger.info("New car successfuly added !");
			return newCar;
		}
		
	}
	
	//TODO : Method to update a car properties
	
	//TODO : Method to delete a car from database
	
	//TODO : Method to get car by Id
}
