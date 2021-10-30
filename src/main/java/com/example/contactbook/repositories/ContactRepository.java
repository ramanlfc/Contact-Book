package com.example.contactbook.repositories;

import com.example.contactbook.models.Contact;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;
import java.util.Optional;

public interface ContactRepository extends JpaRepository<Contact, Integer> {

    List<Contact> findContactsByFirstName(String firstName);
    List<Contact> findContactsByLastName(String lastName);
    @Query("select c from Contact c where c.firstName like %:name% or c.lastName like %:name%")
    List<Contact> findContactByFirstNameOrLastName(@Param("name") String name);
    Optional<Contact> findContactByEmail(String email);



}


