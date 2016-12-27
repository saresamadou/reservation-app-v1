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

import aboudou.samadou.entities.Client;
import aboudou.samadou.metier.Metier;

@RestController
@RequestMapping("/clients")
@CrossOrigin
public class ClientService {

	static final Logger logger = LoggerFactory.getLogger(ClientService.class);

	@Autowired
	private Metier metier;

	@RequestMapping(value = "/getClients", method = RequestMethod.GET)
	public List<Client> getAllClients() {
		return metier.getAllClients();
	}

	@RequestMapping(value = "/addClient", method = RequestMethod.POST)
	@ResponseBody
	public Client addNewClient(@RequestBody Client newClient) {

		if (newClient == null) {
			logger.info("You must give me a client");
			return null;
		} else {
			metier.addClient(newClient);
			logger.info("New client successfuly added !");
			return newClient;
		}

	}

	@RequestMapping(value = "/login", method = RequestMethod.POST)
	@ResponseBody
	public Client login(@RequestBody String email) {
		if (email == null) {
			return null;
		} else {
			Client client = metier.findClientByEmail(email);
			if (client == null) {
				return null;
			} else {
				return client;
			}

		}
	}

}
