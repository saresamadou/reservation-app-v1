package aboudou.samadou.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import aboudou.samadou.entities.Car;

public interface CarRepository extends JpaRepository<Car, Long>
{

}
