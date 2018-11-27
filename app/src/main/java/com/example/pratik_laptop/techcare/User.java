package com.example.pratik_laptop.techcare;


public class User {

    private String username, name,email, dob,gender,weight,height,address,bloodgroup,phone;
    private int id;

    public User(int id, String username, String name,String email, String dob,String gender,String weight,String height,String address,String bloodgroup,String phone) {
        this.id=id;
        this.username = username;
        this.name=name;
        this.email = email;
        this.dob=dob;
        this.gender = gender;
        this.weight=weight;
        this.height=height;
        this.address=address;
        this.bloodgroup=bloodgroup;
        this.phone=phone;
    }

    public String getUsername() {
        return username;
    }
    public String getName() {
        return name;
    }
    public String getEmail() {
        return email;
    }
    public String getDob() {
        return dob;
    }
    public String getGender() {
        return gender;
    }
    public String getWeight() {
        return weight;
    }
    public String getHeight() {
        return height;
    }
    public String getAddress() {
        return address;
    }
    public String getBloodgroup() {
        return bloodgroup;
    }
    public String getPhone() {
        return phone;
    }
    public int getId() {
        return id;
    }
}