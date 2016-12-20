package aboudou.samadou.services;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import com.google.common.collect.Lists;
import aboudou.samadou.entities.Car;
import aboudou.samadou.entities.Reservation;
import aboudou.samadou.metier.IMetier;

@RestController
@CrossOrigin
@RequestMapping("/rsv")
public class ReservationService {

	
	@Autowired
	private IMetier metier;
	
	@RequestMapping(value="/getReservations", method=RequestMethod.GET)
	public List<Reservation> getAllReservations()
	{
		return Lists.newArrayList(metier.getAllReservations());
	}
	
	@RequestMapping(value="/addReservation", method=RequestMethod.POST)
	@ResponseBody public  Reservation addReservation(@RequestBody Reservation reservation) {
		
		if(reservation.equals(null)) {
			return null;
		} else {
			Car carChanged = reservation.getCar();
			carChanged.setdisponibilite(false);
			metier.changeCarDisponibility(carChanged);
			metier.addReservation(reservation);
			return reservation;
		}
	}
}
