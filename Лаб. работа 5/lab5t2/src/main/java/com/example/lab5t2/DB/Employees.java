package com.example.lab5t2.DB;



public class Employees {

    public int num;
    public String nameE;
    public String manager;
    public int pay;
    public int numrazd;
    public String namerazd;
    public String city;
    public int razryad;

    public Employees(){
        num = 0;
        nameE = "";
        manager = "";
        pay = 0;
        numrazd = 0;
        namerazd = "";
        city = "";
        razryad = 0;
    }
    public void setNameE(String nameE) {
        this.nameE = nameE;
    }

    public void setNum(int num) {
        this.num = num;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public void setManager(String manager) {
        this.manager = manager;
    }

    public void setNamerazd(String namerazd) {
        this.namerazd = namerazd;
    }

    public void setNumrazd(int numrazd) {
        this.numrazd = numrazd;
    }

    public void setPay(int pay) {
        this.pay = pay;
    }

    public void setRazryad(int razryad) {
        this.razryad = razryad;
    }

    public int getNum() {
        return num;
    }

    public String getNameE() {
        return nameE;
    }

    public String getManager() {
        return manager;
    }

    public int getNumrazd() {
        return numrazd;
    }

    public int getPay() {
        return pay;
    }

    public int getRazryad() {
        return razryad;
    }

    public String getCity() {
        return city;
    }

    public String getNamerazd() {
        return namerazd;
    }
}
