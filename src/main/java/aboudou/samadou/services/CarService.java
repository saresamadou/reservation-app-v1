package aboudou.samadou.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import aboudou.samadou.entities.Car;
import aboudou.samadou.repositories.CarRepository;

@RestController
public class CarService {

	@Autowired
	private CarRepository carRepository;
	
	@RequestMapping(value="/getCars", method=RequestMethod.GET)
	private List<Car> getAllCars()
	{
		return carRepository.findAll();
	}
}
