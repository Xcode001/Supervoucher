package com.geekbounty.engineeringinvoice;

/**
 * Created by Mussa on 5/29/2018.
 */

public class InvoiceModel {
    String deccription, qty, unit, rate, amount;

    public InvoiceModel(String deccription, String qty, String unit, String rate, String amount) {
        this.deccription = deccription;
        this.qty = qty;
        this.unit = unit;
        this.rate = rate;
        this.amount = amount;
    }

    public String getDeccription() {
        return deccription;
    }

    public void setDeccription(String deccription) {
        this.deccription = deccription;
    }

    public String getQty() {
        return qty;
    }

    public void setQty(String qty) {
        this.qty = qty;
    }

    public String getUnit() {
        return unit;
    }

    public void setUnit(String unit) {
        this.unit = unit;
    }

    public String getRate() {
        return rate;
    }

    public void setRate(String rate) {
        this.rate = rate;
    }

    public String getAmount() {
        return amount;
    }

    public void setAmount(String amount) {
        this.amount = amount;
    }
}
