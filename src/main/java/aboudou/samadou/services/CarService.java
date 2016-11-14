package aboudou.samadou.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import aboudou.samadou.entities.Car;
import aboudou.samadou.metier.Metier;
import aboudou.samadou.repositories.CarRepository;

@RestController
@RequestMapping("/cars")
public class CarService {

	@Autowired
	private Metier metier;
	
	@RequestMapping(value="/getCars", method=RequestMethod.GET)
	private List<Car> getAllCars()
	{
		return metier.getAllCars();
	}
	
	@RequestMapping(value = "/addCar", method = RequestMethod.POST)
	private String addNewCar(@RequestBody Car newCar)
	{
		if(newCar.equals(null))
		{
			return "You must give me a Car";
		} else {
			metier.addCar(newCar);
			return "New car successfuly added !";
		}
		
	}
	
	//TODO : Method to update a car properties
	
	//TODO : Method to delete a car from database
	
	//TODO : Method to get car by Id
}
