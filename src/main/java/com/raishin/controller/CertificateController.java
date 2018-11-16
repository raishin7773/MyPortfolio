package com.raishin.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import com.raishin.form.DeckForm;

@Controller
public class CertificateController {

  @RequestMapping(value = "/certificate/index")
  public String index(@ModelAttribute("deckForm") DeckForm form, BindingResult result,
      Model model) {
    return "certificate_index";
  }
}
