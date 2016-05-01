package aboudou.samadou.repositories;

import org.springframework.data.repository.CrudRepository;

import aboudou.samadou.entities.Client;

public interface ClientRepository extends CrudRepository<Client, Long>
{

}
