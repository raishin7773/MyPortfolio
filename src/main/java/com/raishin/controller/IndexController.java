package com.raishin.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.raishin.entity.IndexEntity;
import com.raishin.form.IndexForm;
import com.raishin.mapper.IndexMapper;

@Controller
public class IndexController {

	@Autowired
	IndexMapper indexMapper;

	@RequestMapping(value = "/", method = RequestMethod.GET)
	public String index(@ModelAttribute("indexForm") IndexForm form, BindingResult result) {
		// Logger logger = LoggerFactory.getLogger("Main");
		// logger.info("loggerTest");
		// List<Fruit> list = fruitMapper.selectAll();
		// model.addAttribute("fruits", list);
		return "index";
	}

	@RequestMapping(value = "/login")
	public String login(@ModelAttribute("indexForm") @Validated IndexForm form, BindingResult result) {
		if (result.hasErrors()) {
			return "index";
		}
		System.out.println(form.getEmail());
		System.out.println(form.getPassword());
		// Logger logger = LoggerFactory.getLogger("Main");
		// logger.info("loggerTest");
		IndexEntity entity = indexMapper.selectLogin(form);
		if (entity != null && entity.getEmail().equals(form.getEmail())) {
			System.out.println("success");
		}
		return "starter";
	}

}