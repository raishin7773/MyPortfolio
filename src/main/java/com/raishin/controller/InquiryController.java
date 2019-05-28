package com.raishin.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.mail.MailSender;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import com.raishin.form.InquiryForm;

/**
 * 問い合わせ画面コントローラー
 */
@Controller
public class InquiryController {

    @Autowired
    private Environment eivironment;

    /**
     * 初期表示メソッド
     * @param form
     * @param result
     * @param model
     * @return
     * @throws Exception
     */
    @RequestMapping(value = "/portfolio/inquiry/index")
    public String index(@ModelAttribute("inquiryForm") InquiryForm form, BindingResult result,
                        Model model) throws Exception {

        return "inquiry/index";
    }

    /**
     * 問い合わせ確認画面遷移用メソッド
     * @param form
     * @param result
     * @param model
     * @return
     * @throws Exception
     */
    @RequestMapping(value = "/portfolio/inquiry/send")
    public String send(@ModelAttribute("inquiryForm") InquiryForm form, BindingResult result,
                       Model model) throws Exception {
        return "inquiry/confirm";
    }

    /**
     * 問い合わせキャンセル用メソッド
     * @param form
     * @param result
     * @param model
     * @return
     * @throws Exception
     */
    @RequestMapping(value = "/portfolio/inquiry/confirm", params = "cansel", method = RequestMethod.POST)
    public String cansel(@ModelAttribute("inquiryForm") InquiryForm form, BindingResult result,
                         Model model) throws Exception {

        return "inquiry/index";
    }

    @Autowired
    private MailSender sender;

    /**
     * 問い合わせ送信メソッド
     * @param form
     * @param result
     * @param model
     * @return
     * @throws Exception
     */
    @RequestMapping(value = "/portfolio/inquiry/confirm", params = "send", method = RequestMethod.POST)
    public String sendmail(@ModelAttribute("inquiryForm") InquiryForm form, BindingResult result,
                           Model model) throws Exception {
        SimpleMailMessage msg = new SimpleMailMessage();

        msg.setFrom(form.getEmail());
        msg.setTo("raishin7773@gmail.com");
        msg.setSubject("問い合わせ"); // タイトルの設定
        msg.setText("email:" + form.getEmail() + " 問い合わせ内容" + form.getInquiry()); // 本文の設定

        this.sender.send(msg);
        return "inquiry/result";
    }
}
