package aboudou.samadou.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import aboudou.samadou.entities.Reservation;

public interface ReservationRepository extends JpaRepository<Reservation, Long>
{

}
