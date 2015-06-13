package spractice.controller;

import java.util.logging.Logger;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping(value = "/square")
public class AdditionController {
	private static final Logger logger = Logger.getLogger(AdditionController.class.getName());
	private static final String msg="";
	
	@RequestMapping(value = "/{n1}", method = RequestMethod.GET)
	public ModelAndView square(@PathVariable("n1") int n1) {
		logger.info(msg);
		ModelAndView modelAndView = new ModelAndView("result");
		modelAndView.addObject("info", n1 * n1);
		return modelAndView;
	}
}
