package com.raishin.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.MailSender;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import com.raishin.form.InquiryForm;

@Controller
public class InquiryController {

  @RequestMapping(value = "/inquiry/index")
  public String index(@ModelAttribute("inquiryForm") InquiryForm form, BindingResult result,
      Model model) {
    return "inquiry_index";
  }

  @RequestMapping(value = "/inquiry/send")
  public String send(@ModelAttribute("inquiryForm") InquiryForm form, BindingResult result,
      Model model) {
    return "inquiry_result";
  }

  @RequestMapping(value = "/inquiry/result", params = "cansel", method = RequestMethod.POST)
  public String cansel(@ModelAttribute("inquiryForm") InquiryForm form, BindingResult result,
      Model model) {
    return "inquiry_index";
  }

  @Autowired
  private MailSender sender;

  @RequestMapping(value = "/inquiry/result", params = "send", method = RequestMethod.POST)
  public String sendmail(@ModelAttribute("inquiryForm") InquiryForm form, BindingResult result,
      Model model) {
    SimpleMailMessage msg = new SimpleMailMessage();

    msg.setFrom("test@mail.com");
    msg.setTo("raishin7773@gmail.com");
    msg.setSubject("テストメール"); // タイトルの設定
    msg.setText("Spring Boot より本文送信"); // 本文の設定

    this.sender.send(msg);
    return "inquiry_result";
  }
}
