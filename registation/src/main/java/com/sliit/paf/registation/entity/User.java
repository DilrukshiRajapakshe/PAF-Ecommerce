package com.sliit.paf.registation.entity;

import javax.persistence.*;


@Entity
@Table(name="user")
public class User extends SuperEntity {
    @Id
    private String userID;
    private String password;
    private String loginStatues;

    public User(String userID, String password, String loginStatues) {
        this.userID = userID;
        this.password = password;
        this.loginStatues = loginStatues;
    }

    public User() {
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
        return "Customerdto{" +
                "userID='" + userID + '\'' +
                ", password='" + password + '\'' +
                ", loginStatues='" + loginStatues + '\'' +

                '}';
    }
}

