package spractice.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping("/info")
public class HWController {
	private String word;

	public HWController() {
	}

	public String getWord() {
		return word;
	}

	public void setWord(String word) {
		this.word = word;
	}

	@RequestMapping(method = RequestMethod.GET)
	public ModelAndView getInfo() {
		System.out.println("hi");
		ModelAndView modelAndView = new ModelAndView("result");
		modelAndView.addObject("info", "Hi");
		return modelAndView;
	}
}
