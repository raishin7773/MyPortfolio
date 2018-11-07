package com.raishin.controller;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import com.raishin.entity.DeckEntity;
import com.raishin.form.DeckForm;
import com.raishin.mapper.DeckMapper;

@Controller
public class DeckController {

  @Autowired
  DeckMapper mapper;

  @RequestMapping(value = "/deck/list")
  public String index(@ModelAttribute("deckForm") DeckForm form, BindingResult result) {
    List<DeckEntity> entityList = mapper.selectAll();
    form.setDeckList(entityList);
    return "starter";
  }
}
