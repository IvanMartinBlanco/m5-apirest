package com.example.demo.rest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

// @Controller Spring MVC con redirección a la plastillas html dentro del proyecto.
//@Component Anotación genérica para clases que no recaen en ninguna capa.

//@RequestMapping("/api")//Enrutado
@RestController
public class HelloController {

	private final Logger log=LoggerFactory.getLogger(HelloController.class);
	
	
	
	@GetMapping("/")
	public String index(){
		log.info("Index");
		return "API REST is at /api/...";
}
	
	
	
	/**
	 * http://localhost:8080/api/hello
	 * @return
	 */
	@GetMapping("/api/hello")
	public String hello(){
		log.info("Excecuting hello world method");
		return "Hola mundo";
}
	


}