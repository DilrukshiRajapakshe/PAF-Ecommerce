package com.sliit.paf.wishlist.entity;


import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class wishlistDetail extends superEntity {

    @Id
    private String itemCode;
    private String itemDes;
    private int qty;
    private double itemPrice;

    public wishlistDetail() {
    }

    public wishlistDetail(String itemCode,String itemDes, int qty, double itemPrice) {

        this.itemCode = itemCode;
        this.itemDes = itemDes;
        this.qty = qty;
        this.itemPrice = itemPrice;
    }

    public String getItemCode() {
        return itemCode;
    }

    public void setItemCode(String itemCode) {
        this.itemCode = itemCode;
    }
    public String getItemDes() {
        return itemDes;
    }

    public void setItemDes(String itemDes) {
        this.itemDes = itemDes;
    }


    public int getQty() {
        return qty;
    }

    public void setQty(int qty) {
        this.qty = qty;
    }

    public double getItemPrice() {
        return itemPrice;
    }

    public void setItemPrice(double itemPrice) {
        this.itemPrice = itemPrice;
    }

    @Override
    public String toString() {
        return "wishlistDTO{" +

                ", itemCode='" + itemCode + '\'' +
                "itemDes='" + itemDes + '\'' +
                ", qty=" + qty +
                ", itemPrice=" + itemPrice +
                '}';
    }
}
