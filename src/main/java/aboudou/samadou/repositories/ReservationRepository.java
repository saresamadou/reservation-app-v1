package aboudou.samadou.repositories;

import org.springframework.data.repository.CrudRepository;

import aboudou.samadou.entities.Reservation;

public interface ReservationRepository extends CrudRepository<Reservation, Long>
{

}
