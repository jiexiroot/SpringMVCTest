package com.springmvc.pojo;

import org.apache.ibatis.type.Alias;

import java.io.Serializable;

/**
 * Books类与mybookshop数据库中的books表对应
 * 包含id，title，author,unitPrice及种类
 */
@Alias("books")
public class Books implements Serializable {

  private long id;
  private String title;
  private String author;
  private String iSBN;



  private double unitPrice;
  private long categoryId;


  @Override
  public String toString() {
    return "Books{" +
            "id=" + id +
            ", title='" + title + '\'' +
            ", author='" + author + '\'' +
            ", iSBN='" + iSBN + '\'' +
            ", unitPrice=" + unitPrice +
            ", categoryId=" + categoryId +
            '}'+"\n";
  }

  public long getId() {
    return id;
  }

  public void setId(long id) {
    this.id = id;
  }

  public String getTitle() {
    return title;
  }

  public void setTitle(String title) {
    this.title = title;
  }

  public String getAuthor() {
    return author;
  }

  public void setAuthor(String author) {
    this.author = author;
  }

  public double getUnitPrice() {
    return unitPrice;
  }

  public void setUnitPrice(double unitPrice) {
    this.unitPrice = unitPrice;
  }

  public long getCategoryId() {
    return categoryId;
  }

  public void setCategoryId(long categoryId) {
    this.categoryId = categoryId;
  }

  public String getiSBN() {
    return iSBN;
  }

  public void setiSBN(String iSBN) {
    this.iSBN = iSBN;
  }
}
