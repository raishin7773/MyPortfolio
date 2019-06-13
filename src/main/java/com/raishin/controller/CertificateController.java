package com.raishin.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import com.raishin.form.DeckForm;

/**
 * 所有資格コントローラーA
 */
@Controller
public class CertificateController {

  /**
   * 所有資格画面初期表示メソッド
   * @param form
   * @param result
   * @param model
   * @return
   * @throws Exception
   */
  @RequestMapping(value = "/portfolio/certificate/index")
  public String index(@ModelAttribute("deckForm") DeckForm form, BindingResult result,
      Model model) throws Exception{
    return "certificate/index";
  }
}
