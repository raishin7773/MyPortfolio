package com.raishin.controller;

import java.util.ArrayList;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
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
  public String index(@ModelAttribute("deckForm") DeckForm form, BindingResult result,
      Model model) {
    List<String> deckNameList = new ArrayList<>();
    List<Integer> duelNumberList = new ArrayList<>();
    List<DeckEntity> entityList = mapper.selectAll();
    entityList.stream().forEach(x -> deckNameList.add(x.getDeckName()));
    entityList.stream().forEach(x -> duelNumberList.add(x.getWin() + x.getLose() + x.getDraw()));
    model.addAttribute("deckNameList", deckNameList);
    model.addAttribute("duelNumberList", duelNumberList);
    form.setDeckList(entityList);
    return "starter";
  }
}
