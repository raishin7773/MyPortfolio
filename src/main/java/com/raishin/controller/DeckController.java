package com.raishin.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import com.raishin.form.DeckForm;
import com.raishin.repository.DeckRepository;
import com.raishin.service.DeckService;

@Controller
public class DeckController {

  // @Autowired
  // DeckMapper mapper;

  @Autowired
  DeckRepository deckRepository;

  @Autowired
  DeckService deckService;



  @RequestMapping(value = "/deck/list")
  public String index(@ModelAttribute("deckForm") DeckForm form, BindingResult result,
      Model model) {
    deckService.initView(form, model);
    return "deck/starter";
  }

  @RequestMapping(value = "/deck/delete")
  public String delete(@ModelAttribute("deckForm") DeckForm form, BindingResult result,
      Model model) {
    deckService.deckDelete(form);
    model.addAttribute("message", "削除しました");
    deckService.initView(form, model);
    return "deck/starter";
  }
}
