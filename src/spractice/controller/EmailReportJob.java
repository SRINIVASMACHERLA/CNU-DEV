package spractice.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping("/admin/email")
public class EmailReportJob {
	private static int i;

	@RequestMapping(value = "/{count}", method = RequestMethod.GET)
	public ModelAndView get(@PathVariable("count") int count) {
		ModelAndView mav = new ModelAndView("/result");
		i += count * 10;
		mav.addObject("info", i);
		return mav;
	}

	@RequestMapping(method = RequestMethod.GET)
	public ModelAndView get() {
		ModelAndView mav = new ModelAndView("/result");
		mav.addObject("info", i);
		return mav;
	}
}
