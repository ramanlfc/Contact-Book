package com.example.contactbook.services;

import com.example.contactbook.exceptions.NoSuchContactFoundException;
import com.example.contactbook.models.Contact;
import com.example.contactbook.repositories.ContactRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ContactService {

    private final ContactRepository contactRepository;

    public ContactService(ContactRepository contactRepository) {
        this.contactRepository = contactRepository;
    }

    public List<Contact> findAllContacts(){
       return contactRepository.findAll();
    }

    public Contact findContactById(int id){
        return contactRepository.findById(id)
                .orElseThrow(() -> new NoSuchContactFoundException("no contact available with id: " + id));
    }

    public Contact findContactByEmail(String email){
        return contactRepository.findContactByEmail(email)
                .orElseThrow(() -> new NoSuchContactFoundException("no contact with email: " + email));
    }

    public List<Contact> findContactsByFirstNameOrLastName(String name){
        return contactRepository.findContactByFirstNameOrLastName(name);
    }


    public void addNewContact(Contact contact){
        contactRepository.save(contact);
    }

    public void deleteContactById(int id){
        contactRepository.deleteById(id);
    }

    public void updateContactById(int id, Contact contact){
        Contact contactById = findContactById(id);

        contactById.setLastName(contact.getLastName());
        contactById.setFirstName(contact.getFirstName());
        contactById.setEmail(contact.getEmail());

        contactRepository.save(contactById);
    }



}
