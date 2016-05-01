package aboduou.samadou.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.mysql.fabric.FabricCommunicationException;
import com.mysql.fabric.Response;

import aboudou.samadou.metier.Metier;

@RestController
public class ReservationApi
{
	@Autowired
	private Metier metier;

	@RequestMapping(value = "/getAllClients", method = RequestMethod.GET)
	public Response getAllClients()
	{
		Response response = null;
		try {
			response = new Response(metier.getAllClients());
		} catch (FabricCommunicationException e) {
			e.printStackTrace();
		}
		return response;
	}
}
