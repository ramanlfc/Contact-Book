package com.example.contactbook.repositories;

import com.example.contactbook.models.Contact;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface ContactRepository extends JpaRepository<Contact, Integer> {

    List<Contact> findContactsByFirstName(String firstName);
    List<Contact> findContactsByLastName(String lastName);
    Optional<Contact> findContactByEmail(String email);

}


