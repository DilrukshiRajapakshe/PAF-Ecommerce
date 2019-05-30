package com.sliit.paf.registation.dto;

public class Customerdto extends SuperDTO {

    private String userID;
    private String userName;
    private String userAddress;
    private int phone;
    private String creditCardInfo;

    public Customerdto(String userID, String userName, String userAddress, int phone, String creditCardInfo) {
        this.userID = userID;
        this.userName = userName;
        this.userAddress = userAddress;
        this.phone = phone;
        this.creditCardInfo = creditCardInfo;
    }

    public Customerdto() {
    }


    public String getUserID() {
        return userID;
    }

    public void setUserID(String userID) {
        this.userID = userID;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getUserAddress() {
        return userAddress;
    }

    public void setUserAddress(String userAddress) {
        this.userAddress = userAddress;
    }

    public int getPhone() {
        return phone;
    }

    public void setPhone(int phone) {
        this.phone = phone;
    }

    public String getCreditCardInfo() {
        return creditCardInfo;
    }

    public void setCreditCardInfo(String creditCardInfo) {
        this.creditCardInfo = creditCardInfo;
    }

    @Override
    public String toString() {
        return "Customerdto{" +
                "userID='" + userID + '\'' +
                ", userName='" + userName + '\'' +
                ", userAddress='" + userAddress + '\'' +
                ", phone='" + phone +
                ", creditCardInfo='" + creditCardInfo + '\'' +
                '}';
    }
}
