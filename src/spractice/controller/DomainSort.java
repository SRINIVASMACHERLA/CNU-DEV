package spractice.controller;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import spractice.model.Domain;

@Controller
@RequestMapping("/sort")
public class DomainSort {
	@RequestMapping(method = RequestMethod.GET)
	public ModelAndView sort(@RequestParam("emailIDs") String emailIDs) {
		String[] emails = emailIDs.split("\n");
		System.out.println("Length: " + emails.length);
		List<Domain> domains = new ArrayList<>(emails.length);
		for (String email : emails) {
			if (!email.isEmpty()) {
				domains.add(new Domain(email.trim()));
			}
		}
		Collections.sort(domains);
		ModelAndView modelAndView = new ModelAndView("result");
		modelAndView.addObject("info", domains);
		return modelAndView;
	}
}
