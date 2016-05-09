package aboudou.samadou.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import aboudou.samadou.entities.Client;

public interface ClientRepository extends JpaRepository<Client, Long>
{

}
