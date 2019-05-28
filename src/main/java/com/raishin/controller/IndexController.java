package com.raishin.controller;

import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import com.raishin.form.IndexForm;

/**
 * 初期表示コントローラー
 */
@Controller
public class IndexController {

  /**
   * 初期表示メソッド
   * @param form
   * @param result
   * @return
   * @throws Exception
   */
  @RequestMapping(value = "/", method = RequestMethod.GET)
  public String index(@ModelAttribute("indexForm") IndexForm form, BindingResult result) throws Exception{

    return "redirect:/portfolio/useTools/index";
  }

  /**
   * エラーテスト用メソッド
   * @param form
   * @param result
   * @return
   * @throws Exception
   */
  @RequestMapping(value = "portfolio/error", method = RequestMethod.GET)
  public String error(@ModelAttribute("indexForm") IndexForm form, BindingResult result) throws Exception {
    throw new Exception("エラー発生");
  }

}
