package com.example.lab4.DB;

import javafx.beans.property.IntegerProperty;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;

public class Employees {

    IntegerProperty num;
    StringProperty name;
    StringProperty manager;
    IntegerProperty pay;
    IntegerProperty numrazd;
    StringProperty namerazd;
    StringProperty city;
    IntegerProperty razryad;

    public Employees(){
        num = new SimpleIntegerProperty();
        name = new SimpleStringProperty();
        manager = new SimpleStringProperty();
        pay = new SimpleIntegerProperty();
        numrazd = new SimpleIntegerProperty();
        namerazd = new SimpleStringProperty();
        city = new SimpleStringProperty();
        razryad = new SimpleIntegerProperty();
    }
    public void setName(String name) {
        this.name.set(name);
    }

    public void setNum(int num) {
        this.num.set(num);
    }

    public void setCity(String city) {
        this.city.set(city);
    }

    public void setManager(String manager) {
        this.manager.set(manager);
    }

    public void setNamerazd(String namerazd) {
        this.namerazd.set(namerazd);
    }

    public void setNumrazd(int numrazd) {
        this.numrazd.set(numrazd);
    }

    public void setPay(int pay) {
        this.pay.set(pay);
    }

    public void setRazryad(int razryad) {
        this.razryad.set(razryad);
    }

    public int getNum() {
        return num.get();
    }

    public String getName() {
        return name.get();
    }

    public String getManager() {
        return manager.get();
    }

    public int getNumrazd() {
        return numrazd.get();
    }

    public int getPay() {
        return pay.get();
    }

    public int getRazryad() {
        return razryad.get();
    }

    public String getCity() {
        return city.get();
    }

    public String getNamerazd() {
        return namerazd.get();
    }
}
