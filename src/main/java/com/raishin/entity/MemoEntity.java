package com.raishin.entity;

import java.sql.Date;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "memo", schema="public")
public class MemoEntity {

  @GeneratedValue
  @Id
  private int id;

  private String memo;

  private Date create_Date;

  private Date update_Date;

  public int getId() {
    return id;
  }

  public void setId(int id) {
    this.id = id;
  }

  public String getMemo() {
    return memo;
  }

  public void setMemo(String memo) {
    this.memo = memo;
  }

  public Date getCreate_Date() {
    return create_Date;
  }

  public void setCreate_Date(Date create_Date) {
    this.create_Date = create_Date;
  }

  public Date getUpdate_Date() {
    return update_Date;
  }

  public void setUpdate_Date(Date update_Date) {
    this.update_Date = update_Date;
  }



}
