package com.raishin.form;

import java.sql.Date;
import java.util.List;
import javax.validation.constraints.NotEmpty;
import com.raishin.entity.DeckEntity;

public class DeckForm {

  private Integer id;

  @NotEmpty
  private String deckName;

  private Integer win;

  private Integer lose;

  private Integer draw;

  private String winningPercentage;

  private Date createDate;

  private Date updateDate;

  private List<DeckEntity> deckList;

  public Integer getId() {
    return id;
  }

  public void setId(Integer id) {
    this.id = id;
  }

  public String getDeckName() {
    return deckName;
  }

  public void setDeckName(String deckName) {
    this.deckName = deckName;
  }

  public Integer getWin() {
    return win;
  }

  public void setWin(Integer win) {
    this.win = win;
  }

  public Integer getLose() {
    return lose;
  }

  public void setLose(Integer lose) {
    this.lose = lose;
  }

  public Integer getDraw() {
    return draw;
  }

  public void setDraw(Integer draw) {
    this.draw = draw;
  }

  public Date getCreateDate() {
    return createDate;
  }

  public void setCreateDate(Date createDate) {
    this.createDate = createDate;
  }

  public Date getUpdateDate() {
    return updateDate;
  }

  public void setUpdateDate(Date updateDate) {
    this.updateDate = updateDate;
  }

  public List<DeckEntity> getDeckList() {
    return deckList;
  }

  public void setDeckList(List<DeckEntity> deckList) {
    this.deckList = deckList;
  }

  public String getWinningPercentage() {
    return new Integer(Math.round(win / (win + lose + draw) * 100)).toString();
  }

  public void setWinningPercentage(String winningPercentage) {
    this.winningPercentage = winningPercentage;
  }
}
