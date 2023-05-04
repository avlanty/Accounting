package org.yup.accountant;

import java.time.LocalDate;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;

public class Transactions {

    private String description;
    private String vendor;
    private double amount;
    private LocalTime curTime;
    private LocalDate curDate;
    private boolean isDeb;

    public Transactions(String description, String vendor, double amount, LocalTime curTime, LocalDate curDate, boolean isDeb){
        this.description = description;
        this.vendor = vendor;
        this.amount = amount;
        this.curTime = curTime;
        this.curDate = curDate;
        this.isDeb = isDeb;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getVendor() {
        return vendor;
    }

    public void setVendor(String vendor) {
        this.vendor = vendor;
    }

    public double getAmount() {
        return amount;
    }

    public void setAmount(double amount) {
        this.amount = amount;
    }

    public LocalTime getCurTime() {
        return curTime;
    }

    public void setCurTime(LocalTime curTime) {
        this.curTime = curTime;
    }

    public LocalDate getCurDate() {
        return curDate;
    }

    public void setCurDate(LocalDate curDate) {
        this.curDate = curDate;
    }

    public boolean isDeb() {
        return isDeb;
    }

    public void setDeb(boolean deb) {
        isDeb = deb;
    }

    public String getFormattedTime(){
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("HH:mm:ss");
        return curTime.format(formatter);
    }

}