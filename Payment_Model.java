package com.example.miphy_navigation;

public class Payment_Model {

    private String received_from,sender_name,payment_date,received_amt;

    public String getReceived_from() {
        return received_from;
    }

    public void setReceived_from(String received_from) {
        this.received_from = received_from;
    }

    public String getSender_name() {
        return sender_name;
    }

    public void setSender_name(String sender_name) {
        this.sender_name = sender_name;
    }

    public String getPayment_date() {
        return payment_date;
    }

    public void setPayment_date(String payment_date) {
        this.payment_date = payment_date;
    }

    public String getReceived_amt() {
        return received_amt;
    }

    public void setReceived_amt(String received_amt) {
        this.received_amt = received_amt;
    }
}
