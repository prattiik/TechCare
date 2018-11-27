package com.example.pratik_laptop.techcare;

/**
 * Created by PRATIK-laptop on 15-Mar-18.
 */

public class Doc {
    private String name, special,address, contact;
    private int id;

    public Doc(int id, String name, String special,String address, String contact) {
        this.id=id;
        this.name = name;
        this.special=special;
        this.address = address;
        this.contact=contact;
    }

    public String getName() {
        return name;
    }
    public String getSpecial() {
        return special;
    }
    public String getAddress() {
        return address;
    }
    public String getContact() {
        return contact;
    }
    public int getId() {
        return id;
    }
}
