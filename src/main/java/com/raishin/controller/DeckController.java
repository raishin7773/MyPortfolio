package com.raishin.controller;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.stream.Collectors;
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

  Random random = new Random();

  @RequestMapping(value = "/deck/list")
  public String index(@ModelAttribute("deckForm") DeckForm form, BindingResult result,
      Model model) {
    List<String> deckNameList = new ArrayList<>();
    List<String> backColorList = new ArrayList<>();
    List<Integer> duelNumberList = new ArrayList<>();
    List<DeckEntity> entityList = mapper.selectAll();
    entityList.stream().forEach(x -> deckNameList.add(x.getDeckName()));
    entityList.stream().forEach(x -> duelNumberList.add(x.getWin() + x.getLose() + x.getDraw()));
    entityList.stream().forEach(x -> backColorList.add("rgb(" + random.nextInt(256) + ", "
        + random.nextInt(256) + ", " + random.nextInt(256) + ")"));

    model.addAttribute("backColorList", backColorList);
    model.addAttribute("deckNameList", deckNameList);
    model.addAttribute("duelNumberList", duelNumberList);
    model.addAttribute("TopFiveNameList",
        deckNameList.stream().limit(5).collect(Collectors.toList()));
    model.addAttribute("TopFiveNumberList",
        duelNumberList.stream().limit(5).collect(Collectors.toList()));
    form.setDeckList(entityList);
    return "starter";
  }
}
