package com.raishin.entity;

import java.sql.Date;
import javax.persistence.*;

@Entity
@Table(name = "mydeck")
public class DeckEntity {

  @Id
  @GeneratedValue(strategy = GenerationType.SEQUENCE,generator = "deckid_seq")
  @SequenceGenerator(name = "deckid_seq", sequenceName = "deckid_seq", allocationSize = 1)
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

  public String getDeckname() {
    return deckname;
  }

  public void setDeckname(String deckname) {
    this.deckname = deckname;
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
