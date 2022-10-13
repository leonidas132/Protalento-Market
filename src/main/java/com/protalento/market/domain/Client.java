package com.protalento.market.domain;

import java.util.List;

public class Client {

    private String idClient;
    private String name;
    private String lastName;
    private long phone;
    private String addres;
    private String email;
    private List<Purchase> listPurchases;

    public String getIdClient() {
        return idClient;
    }

    public void setIdClient(String idClient) {
        this.idClient = idClient;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public long getPhone() {
        return phone;
    }

    public void setPhone(long phone) {
        this.phone = phone;
    }

    public String getAddres() {
        return addres;
    }

    public void setAddres(String addres) {
        this.addres = addres;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public List<Purchase> getListPurchases() {
        return listPurchases;
    }

    public void setListPurchases(List<Purchase> listPurchases) {
        this.listPurchases = listPurchases;
    }
}
