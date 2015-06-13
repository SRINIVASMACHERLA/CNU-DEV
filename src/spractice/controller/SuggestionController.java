package spractice.controller;

import java.util.List;
import java.util.logging.Logger;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import spractice.dao.SuggestionDAO;
import spractice.model.Suggestion;

@Controller
@RequestMapping("/suggestion")
public class SuggestionController {
	@Autowired
	private SuggestionDAO dao;

	public SuggestionDAO getDao() {
		return dao;
	}

	public void setDao(SuggestionDAO dao) {
		this.dao = dao;
	}

	@RequestMapping(value = "/add", method = RequestMethod.POST)
	public ModelAndView addSuggestion(
			@RequestParam("category") String category,
			@RequestParam("information") String information) {
		
		Suggestion suggestion = new Suggestion();
		suggestion.setCategory(category);
		suggestion.setInformation(information);

		logger.warning(String.format(info_msg, suggestion.toString()));
		
		dao.add(suggestion);

		logger.warning(String.format(success_msg, suggestion.toString()));
		
		ModelAndView modelAndView = new ModelAndView("/result");
		modelAndView.addObject("info", "Suggestion added Successfully");
		return modelAndView;
	}

	@RequestMapping(value = "/all", method = RequestMethod.GET)
	public ModelAndView getAllSuggestions() {
		List<Suggestion> suggestions = dao.getAllSuggestions();
		ModelAndView modelAndView = new ModelAndView("/suggestions");
		modelAndView.addObject("info", suggestions);
		return modelAndView;
	}

private final static String info_msg="Addiing suggestion %s";	
private final static String success_msg="Added suggestion %s successfully";	
private final static Logger logger = Logger.getLogger(SuggestionController.class.getName());
}
