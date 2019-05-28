package com.raishin.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import com.raishin.form.DeckForm;

/**
 * 使用技術画面コントローラー
 */
@Controller
public class UseToolsController {

  /**
   * 初期表示メソッド
   * @param form
   * @param result
   * @param model
   * @return
   * @throws Exception
   */
  @RequestMapping(value = "/portfolio/useTools/index")
  public String index(@ModelAttribute("deckForm") DeckForm form, BindingResult result,
      Model model)  throws Exception{
    return "useTools/index";
  }
}
