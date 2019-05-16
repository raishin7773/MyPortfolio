package com.raishin.controller;

import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import com.raishin.form.IndexForm;

@Controller
public class IndexController {

  @RequestMapping(value = "/", method = RequestMethod.GET)
  public String index(@ModelAttribute("indexForm") IndexForm form, BindingResult result) {
    return "redirect:/useTools/index";
  }

}
