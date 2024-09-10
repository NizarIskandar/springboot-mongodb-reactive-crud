package com.example.reactivepatient.model;

import java.time.LocalDate;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document
public class Patient {

    @Id
    private String id;

    private String name;
    private String phonenumber;
    private String gender;  
    private LocalDate birthdate;
    private Address address;  

    public Patient() {
    }

    public Patient(String name, String phonenumber, String gender, LocalDate birthdate, Address address) {
        this.name = name;
        this.phonenumber = phonenumber;
        this.setGender(gender); 
        this.birthdate = birthdate;
        this.address = address;
    }

    // Getters and Setters 
    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPhonenumber() {
        return phonenumber;
    }

    public void setPhonenumber(String phonenumber) {
        this.phonenumber = phonenumber;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        if (gender != null) {
            if (gender.equalsIgnoreCase("M")) {
                this.gender = "male";
            } else if (gender.equalsIgnoreCase("F")) {
                this.gender = "female";
            } else {
                this.gender = gender;
            }
        }
    }

    public LocalDate getBirthdate() {
        return birthdate;
    }

    public void setBirthdate(LocalDate birthdate) {
        this.birthdate = birthdate;
    }

    public Address getAddress() {
        return address;
    }

    public void setAddress(Address address) {
        this.address = address;
    }

    @Override
    public String toString() {
        return "Patient [id=" + id + ", name=" + name + ", phonenumber=" + phonenumber + ", gender=" + gender
                + ", birthdate=" + birthdate + ", address=" + address + "]";
    }
}

