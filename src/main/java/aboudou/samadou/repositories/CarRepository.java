package aboudou.samadou.repositories;

import org.springframework.data.repository.CrudRepository;
import aboudou.samadou.entities.Car;

public interface CarRepository extends CrudRepository<Car, Long>
{

}
