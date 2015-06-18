package spractice.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import spractice.dao.SuggestionDAO;
import spractice.model.Suggestion;

@Controller
@RequestMapping("/search")
public class SearchController {
	@RequestMapping(method=RequestMethod.GET)
	public ModelAndView search(@RequestParam("keyword") String keyword) {
		ModelAndView mav = new ModelAndView("/SearchResult");
		List<Suggestion> suggestions = dao.get(keyword);
		mav.addObject("info", suggestions);
		return mav;
	}

	public SuggestionDAO getDao() {
		return dao;
	}

	public void setDao(SuggestionDAO dao) {
		this.dao = dao;
	}

	@Autowired
	private SuggestionDAO dao;
}
