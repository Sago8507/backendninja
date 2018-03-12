package com.udemy.controller;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.view.RedirectView;

import com.udemy.service.EjercicioService;

@Controller
@RequestMapping("/ejercicio")
public class EjercicioController {

	private static final Log LOGGER = LogFactory.getLog(EjercicioController.class);
	public static final String EJERCICIO_VIEW = "ejercicio";
	
	@Autowired
	@Qualifier("ejercicioService")
	private EjercicioService ejercicioService;
	
	@GetMapping("/vistaUno")
	public RedirectView metodoUno(){
		LOGGER.info("METHOD: 'metodoUno'");
		return new RedirectView("/ejercicio/vistaDos");
	}
	
	@GetMapping("/vistaDos")
	public String metodoDos(Model model){
		LOGGER.info("METHOD: 'metodoDos'");
		long start = System.currentTimeMillis();
		String mensaje = "Hello from 'metodoDos()' this is a message";
		ejercicioService.muestraMensaje();
		
		model.addAttribute("mensaje", mensaje);
		
		LOGGER.info("El metodo tardo " + (System.currentTimeMillis() - start) + " ms");
		return EJERCICIO_VIEW;
	}
	
}
