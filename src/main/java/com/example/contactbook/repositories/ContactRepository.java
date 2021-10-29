package com.example.contactbook.repositories;

import com.example.contactbook.models.Contact;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ContactRepository extends JpaRepository<Contact, Integer> {

    List<Contact> findContactsByFirstName(String firstName);
    List<Contact> findContactsByLastName(String lastName);

}


