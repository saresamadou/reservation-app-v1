package abouduou.samadou.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping(value="/")
public class HomeController
{
	@RequestMapping(method=RequestMethod.GET)
	public @ResponseBody String index()
	{
		return "Hello";
	}

}
