package com.raishin.controller;

import java.io.FileInputStream;
import java.io.InputStream;
import java.util.Properties;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import com.raishin.form.InquiryForm;

@Controller
public class InquiryController {

  @Autowired
  private Environment eivironment;

  @RequestMapping(value = "/inquiry/index")
  public String index(@ModelAttribute("inquiryForm") InquiryForm form, BindingResult result,
      Model model) {


    System.out.println("hostname=" + System.getenv("hostname"));
    System.out.println("dbname=" + System.getenv("dbname"));
    System.out.println("username=" + System.getenv("username"));
    System.out.println("password=" + System.getenv("password"));

    // 値の取得
    System.out.println(eivironment.getProperty("spring.datasource.url"));
    
    return "inquiry/index";
  }

  @RequestMapping(value = "/inquiry/send")
  public String send(@ModelAttribute("inquiryForm") InquiryForm form, BindingResult result,
      Model model) {
    return "inquiry/confirm";
  }

  @RequestMapping(value = "/inquiry/confirm", params = "cansel", method = RequestMethod.POST)
  public String cansel(@ModelAttribute("inquiryForm") InquiryForm form, BindingResult result,
      Model model) {

    return "inquiry/index";
  }

  // @Autowired
  // private MailSender sender;

  @RequestMapping(value = "/inquiry/confirm", params = "send", method = RequestMethod.POST)
  public String sendmail(@ModelAttribute("inquiryForm") InquiryForm form, BindingResult result,
      Model model) {
    // SimpleMailMessage msg = new SimpleMailMessage();
    //
    // msg.setFrom(form.getEmail());
    // msg.setTo("raishin7773@gmail.com");
    // msg.setSubject("問い合わせ"); // タイトルの設定
    // msg.setText("email:" + form.getEmail() + " 問い合わせ内容" + form.getInquiry()); // 本文の設定
    //
    // this.sender.send(msg);
    return "inquiry/result";
  }
}
