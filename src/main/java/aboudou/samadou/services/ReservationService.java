package aboudou.samadou.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import aboudou.samadou.entities.Reservation;
import aboudou.samadou.repositories.ReservationRepository;

@RestController
public class ReservationService {

	@Autowired
	private ReservationRepository reservationRepository;
	
	@RequestMapping(value="/getReservations", method=RequestMethod.GET)
	public List<Reservation> getAllReservations()
	{
		return reservationRepository.findAll();
	}
}
