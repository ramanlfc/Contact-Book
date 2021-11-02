package com.example.contactbook.models;


import javax.persistence.*;

@Entity
public class PhoneNumber {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(unique = true)
    private String number;

    @Enumerated(EnumType.STRING)
    private PhoneType phoneType;

    @ManyToOne
    private Contact contact;

    @Embedded
    private Address address;

    public PhoneNumber() {
    }

    public PhoneNumber(String number, PhoneType phoneType, Contact contact, Address address) {
        this.number = number;
        this.phoneType = phoneType;
        this.contact = contact;
        this.address = address;
    }

    public int getId() {
        return id;
    }

    public String getNumber() {
        return number;
    }

    public void setNumber(String number) {
        this.number = number;
    }

    public PhoneType getPhoneType() {
        return phoneType;
    }

    public void setPhoneType(PhoneType phoneType) {
        this.phoneType = phoneType;
    }

    public Contact getContact() {
        return contact;
    }

    public void setContact(Contact contact) {
        this.contact = contact;
    }

    public Address getAddress() {
        return address;
    }

    public void setAddress(Address address) {
        this.address = address;
    }
}
