package com.udemy.controller;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.udemy.component.ExampleComponent;
import com.udemy.service.ExampleService;

@Controller
@RequestMapping("/example")
public class ExampleController {

	private static final Log LOGGER = LogFactory.getLog(ExampleController.class);
	public static final String EXAMPLE_VIEW = "example";
	
	@Autowired		// indica a spring que vamos a inyectar un componente que se encuentra en su memoria
	@Qualifier("exampleService")	//indica a spring el nombre del bean que esta en su memoria.
	private ExampleService exampleService;	// declaramos el componente
	
	@Autowired // indica a spring que vamos a inyectar un componente que se encuentra en su memoria
	@Qualifier("exampleComponent")  //indica a spring el nombre del bean que esta en su memoria.
	private ExampleComponent exampleComponent;  // declaramos el componente
	
	//Primera forma
	@GetMapping("/exampleString")
	public String exampleString(Model model){
		LOGGER.info("METHOD: 'exampleString' -- PARAMS: 'model = " + model + "'");
		model.addAttribute("people",exampleService.getListPeople());
		LOGGER.info("TEMPLATE: '" + EXAMPLE_VIEW + "' -- DATA: '" + model + "'");
		return EXAMPLE_VIEW;
	}
	
	//Segunda forma
	@GetMapping("/exampleMAV")
	public ModelAndView exampleMAV(){
		LOGGER.info("METHOD: 'exampleMAV'");
		exampleComponent.sayHello();
		ModelAndView mav = new ModelAndView(EXAMPLE_VIEW);
		mav.addObject("people",exampleService.getListPeople());
		LOGGER.info("TEMPLATE: '" + EXAMPLE_VIEW + "' -- DATA: '" + mav.getModel() + "'");
		return mav;
	}
	
}
