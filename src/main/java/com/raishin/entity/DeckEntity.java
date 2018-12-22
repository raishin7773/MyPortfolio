package com.raishin.entity;

import java.sql.Date;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "mydeck")
public class DeckEntity {

  @Id
  private int id;

  private String deckname;

  private int win;

  private int lose;

  private int draw;

  private Date create_Date;

  private Date update_Date;

  public int getId() {
    return id;
  }

  public void setId(int id) {
    this.id = id;
  }

  public String getDeckName() {
    return deckname;
  }

  public void setDeckName(String deckName) {
    this.deckname = deckName;
  }

  public int getWin() {
    return win;
  }

  public void setWin(int win) {
    this.win = win;
  }

  public int getLose() {
    return lose;
  }

  public void setLose(int lose) {
    this.lose = lose;
  }

  public int getDraw() {
    return draw;
  }

  public void setDraw(int draw) {
    this.draw = draw;
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
