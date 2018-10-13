package com.raishin.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.raishin.domain.Fruit;
import com.raishin.mapper.FruitMapper;

@Controller
public class IndexController {

	@Autowired
	FruitMapper fruitMapper;
	
	@RequestMapping(value = "/", method = RequestMethod.GET)
	public String index(Model model) {
		List<Fruit> list = fruitMapper.selectAll();
		model.addAttribute("fruits", list);
		return "index";
	}
	
}