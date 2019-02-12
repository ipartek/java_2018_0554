package com.ipartek.formacion.tienda.api;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import springfox.documentation.annotations.ApiIgnore;

@ApiIgnore
@Controller
public class HomeController {
// Prueba
	@RequestMapping(value = "/", method = RequestMethod.GET)
	public String home() {
		return "index";
	}

}
