package com.example.contactbook.services;

import com.example.contactbook.exceptions.NoSuchcontactException;
import com.example.contactbook.models.Contact;
import com.example.contactbook.repositories.ContactRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ContactService {

    private ContactRepository contactRepository;

    public ContactService(ContactRepository contactRepository) {
        this.contactRepository = contactRepository;
    }

    public List<Contact> getAllContacts(){
       return contactRepository.findAll();
    }

    public Contact findContactById(int id){
        return contactRepository.findById(id)
                .orElseThrow(() -> new NoSuchcontactException("no contact available with id: " + id));
    }

    public Contact findContactByEmail(String email){
        return contactRepository.findContactByEmail(email)
                .orElseThrow(() -> new NoSuchcontactException("no contact with email: " + email));
    }

    public List<Contact> getContactsByFirstName(String firstName){
        return contactRepository.findContactsByFirstName(firstName);
    }

    public List<Contact> getContactsByLastName(String lastName){
        return contactRepository.findContactsByLastName(lastName);
    }


    public void addNewContact(Contact contact){
        contactRepository.save(contact);
    }

    public void deleteContactById(int id){
        contactRepository.deleteById(id);
    }

    public void updateContact(int id, Contact contact){
        Contact contactById = findContactById(id);

        contactById.setLastName(contact.getLastName());
        contactById.setFirstName(contact.getFirstName());
        contactById.setEmail(contact.getEmail());

        contactRepository.save(contactById);
    }



}
