package aboudou.samadou.services;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import aboudou.samadou.entities.Car;
import aboudou.samadou.entities.Client;
import aboudou.samadou.metier.Metier;
import aboudou.samadou.repositories.ClientRepository;

@RestController
@RequestMapping("/clients")
@CrossOrigin
public class ClientService {

	final static Logger logger = LoggerFactory.getLogger(ClientService.class);

	@Autowired
	private Metier metier;

	@Autowired
	private ClientRepository clientRepository;

	@RequestMapping(value = "/getClients", method = RequestMethod.GET)
	public List<Client> getAllClients() {
		return clientRepository.findAll();
	}

	@RequestMapping(value = "/addClient", method = RequestMethod.POST)
	public @ResponseBody Client addNewClient(@RequestBody Client newClient) {
		logger.info(newClient.toString());

		if (newClient.equals(null)) {
			logger.info("You must give me a client");
			return null;
		} else {
			metier.addClient(newClient);
			logger.info("New client successfuly added !");
			return newClient;
		}

	}

	@RequestMapping(value = "/login", method = RequestMethod.POST)
	public @ResponseBody Client login(@RequestBody String email) {
		if (email.equals(null)) {
			return null;
		} else {
			Client client = metier.findClientByEmail(email);
			if (client.equals(null)) {
				return null;
			} else {
				return client;
			}

		}
	}

}
