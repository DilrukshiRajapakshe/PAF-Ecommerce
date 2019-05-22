package com.sliit.paf.dilivery.entity;

import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import javax.persistence.Entity;
import javax.persistence.EntityListeners;
import javax.persistence.Id;

@EntityListeners(AuditingEntityListener.class)
@Entity
public class delivary  extends SuperEntity {
    @Id
    private int delivary_id;
    private int user_id;
    private int bill_id;
    private String receive_date;
    private String reveive_person;
    private String fromTo;
    private String date;

    public delivary()
    {

    }

    public delivary( int delivary_id,int user_id, int bill_id, String receive_date, String reveive_person, String fromTo, String date) {
        this.user_id = user_id;
        this.delivary_id = delivary_id;
        this.bill_id = bill_id;
        this.receive_date = receive_date;
        this.reveive_person = reveive_person;
        this.fromTo = fromTo;
        this.date = date;
    }

    public int getUser_id() {
        return user_id;
    }

    public void setUser_id(int user_id) {
        this.user_id = user_id;
    }

    public int getDelivary_id() {
        return delivary_id;
    }

    public void setDelivary_id(int delivary_id) {
        this.delivary_id = delivary_id;
    }

    public int getBill_id() {
        return bill_id;
    }

    public void setBill_id(int bill_id) {
        this.bill_id = bill_id;
    }

    public String getReceive_date() {
        return receive_date;
    }

    public void setReceive_date(String receive_date) {
        this.receive_date = receive_date;
    }

    public String getReveive_person() {
        return reveive_person;
    }

    public void setReveive_person(String reveive_person) {
        this.reveive_person = reveive_person;
    }

    public String getFromTo() {
        return fromTo;
    }

    public void setFromTo(String fromTo) {
        this.fromTo = fromTo;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    @Override
    public String toString() {
        return "delivaryDTO{" +
                "user_id='" + user_id + '\'' +
                "delivary_id='" + delivary_id + '\'' +
                "bill_id='" + bill_id + '\'' +
                "receive_date='" + receive_date + '\'' +
                "reveive_person='" + reveive_person + '\'' +
                "fromTo='" + fromTo + '\'' +
                "date='" + date + '\'' +
                '}';
    }
}
