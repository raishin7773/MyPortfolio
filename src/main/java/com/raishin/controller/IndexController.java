package com.raishin.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import com.raishin.form.IndexForm;
import com.raishin.mapper.IndexMapper;

@Controller
public class IndexController {

  @Autowired
  IndexMapper indexMapper;

  @RequestMapping(value = "/", method = RequestMethod.GET)
  public String index(@ModelAttribute("indexForm") IndexForm form, BindingResult result) {
    return "redirect:/useTools/index";
  }

  // @RequestMapping(value = "/login")
  // public String login(@ModelAttribute("indexForm") @Validated IndexForm form, BindingResult
  // result,
  // Model model) {
  // if (result.hasErrors()) {
  // return "index";
  // }
  // IndexEntity entity = indexMapper.selectLogin(form);
  // if (entity == null || !entity.getEmail().equals(form.getEmail())
  // || !entity.getPassword().equals(form.getPassword())) {
  // result.rejectValue("email", "notlogin");
  // return "index";
  // }
  //
  // // return "redirect:/deck/list";
  // return "redirect:/useTools/index";
  // }

}
