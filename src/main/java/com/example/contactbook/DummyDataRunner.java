package com.example.contactbook;

import com.example.contactbook.models.Contact;
import com.example.contactbook.repositories.ContactRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class DummyDataRunner implements CommandLineRunner {

    @Autowired
    private ContactRepository contactRepository;

    @Override
    public void run(String... args) throws Exception {

        contactRepository.deleteAll();

        List<Contact> contacts = List.of(new Contact("john", "doe", "johndoe@gmail.com", null)
                ,new Contact("peter", "doe", "peterdoe@gmail.com", null) );

        contactRepository.saveAll(contacts);

    }
}
