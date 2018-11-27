package com.raishin.form;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotEmpty;


public class InquiryForm {

  @Email
  private String email;

  @NotEmpty
  private String name;

  @NotEmpty
  private String inquiry;

  public String getEmail() {
    return email;
  }

  public void setEmail(String email) {
    this.email = email;
  }

  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public String getInquiry() {
    return inquiry;
  }

  public void setInquiry(String inquiry) {
    this.inquiry = inquiry;
  }


}
