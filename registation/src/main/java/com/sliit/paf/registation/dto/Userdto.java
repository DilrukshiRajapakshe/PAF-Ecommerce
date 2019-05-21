package com.sliit.paf.registation.dto;

public class Userdto extends SuperDTO {

    private String userID;
    private String password;
    private String loginStatues;

    public Userdto(String userID, String password, String loginStatues) {
        this.userID = userID;
        this.password = password;
        this.loginStatues = loginStatues;
    }

    public Userdto() {
    }


    public String getUserID() {
        return userID;
    }

    public void setUserID(String userID) {
        this.userID = userID;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getLoginStatues() {
        return loginStatues;
    }

    public void setLoginStatues(String loginStatues) {
        this.loginStatues = loginStatues;
    }


    @Override
    public String toString() {
        return "Userdto{" +
                "userID='" + userID + '\'' +
                ", password='" + password + '\'' +
                ", loginStatues='" + loginStatues + '\'' +

                '}';
    }

}
