package com.raishin.controller;

import com.raishin.entity.DeckEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;
import com.raishin.excel.DeckExcelBuilder;
import com.raishin.form.DeckForm;
import com.raishin.repository.DeckRepository;
import com.raishin.service.DeckService;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Controller
public class DeckController {

  // @Autowired
  // DeckMapper mapper;

  @Autowired
  DeckRepository deckRepository;

  @Autowired
  DeckService deckService;



  @RequestMapping(value = "/portfolio/deck/list")
  public String index(@ModelAttribute("deckForm") DeckForm form, BindingResult result,
      Model model) {
    deckService.initView(form, model);
    return "deck/starter";
  }

  @RequestMapping(value = "/portfolio/deck/delete")
  public String delete(@ModelAttribute("deckForm") DeckForm form, BindingResult result,
      Model model) {
    deckService.deckDelete(form);
    model.addAttribute("message", "削除しました");
    deckService.initView(form, model);
    return "deck/starter";
  }

  @RequestMapping(value = "/portfolio/deck/update")
  public String update(@ModelAttribute("deckForm") DeckForm form, BindingResult result,
      Model model) throws Exception {
    deckService.deckUpdate(form);
    model.addAttribute("message", "更新しました");
    deckService.initView(form, model);
    return "deck/starter";
  }
  
  @RequestMapping(value = "/portfolio/deck/insert")
  public String insert(@ModelAttribute("deckForm") DeckForm form, BindingResult result,
      Model model) throws Exception {
    deckService.deckInsert(form);
    model.addAttribute("message", "更新しました");
    deckService.initView(form, model);
    return "deck/starter";
  }

  @RequestMapping(value = "/portfolio/deck/excel")
  public ModelAndView excel(@ModelAttribute("deckForm") DeckForm form, BindingResult result,
      Model model) throws Exception {
    List<DeckEntity> deckEntityList = deckService.getAll();
    Map map = new HashMap<String,List<DeckEntity>>();
    map.put("deckList",deckEntityList);
    ModelAndView mav = new ModelAndView(new DeckExcelBuilder(),map);
    mav.addObject("fileName", "testExcel" + ".xls");
    return mav;
  }
}
