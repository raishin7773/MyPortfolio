package com.raishin.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import com.raishin.form.MemoForm;
import com.raishin.service.memo.MemoService;

@Controller
public class MemoController {

  @Autowired
  MemoService service;

  @RequestMapping(value = "/portfolio/memo/index")
  public String index(@ModelAttribute("memoForm") MemoForm form, BindingResult result,
      Model model)  throws Exception{
    service.initView(form);
    return "memo/index";
  }

  @RequestMapping(value = "/portfolio/memo/update")
  public String update(@ModelAttribute("memoForm") MemoForm form, BindingResult result,
      Model model)  throws Exception{
    service.update(form);
    return "memo/index";
  }
}
