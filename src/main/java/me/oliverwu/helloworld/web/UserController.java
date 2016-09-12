package me.oliverwu.helloworld.web;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import me.oliverwu.helloworld.service.UserService;

@Controller
public class UserController {

	private static final Logger log = LoggerFactory.getLogger(UserController.class);

	@Autowired
	private UserService userService;

	@RequestMapping(value = "/user/{login:.+}", method = RequestMethod.GET)
	public ModelAndView user(@PathVariable("login") String login) {

		boolean result = userService.isUserExisted(login);

		ModelAndView model = new ModelAndView();
		model.setViewName("index");
		model.addObject("isUserExisted", result);

		log.debug("The User Login: " + login + " existed or not: " + result);

		return model;
	}

}
