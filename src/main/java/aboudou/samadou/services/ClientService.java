package aboudou.samadou.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import aboudou.samadou.entities.Client;
import aboudou.samadou.repositories.ClientRepository;

@RestController
public class ClientService {

	@Autowired
	private ClientRepository clientRepository;
	
	@RequestMapping(value="/getClients", method=RequestMethod.GET)
	public List<Client> getAllClients()
	{
		return clientRepository.findAll();
	}
}
