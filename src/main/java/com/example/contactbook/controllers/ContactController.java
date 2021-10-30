package com.example.contactbook.controllers;

import com.example.contactbook.models.Contact;
import com.example.contactbook.services.ContactService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/contacts")
public class ContactController {

    private final ContactService contactService;

    public ContactController(ContactService contactService) {
        this.contactService = contactService;
    }

    @GetMapping
    public List<Contact> findAllContacts(){
        return contactService.findAllContacts();
    }

    @GetMapping("/{id:[0-9]+}")
    public Contact findContactById(@PathVariable int id){
        return contactService.findContactById(id);
    }

    @GetMapping("/searchEmail")
    public Contact findContactByEmail(@RequestParam("email") String email){
        return contactService.findContactByEmail(email);
    }

    @GetMapping("/searchName")
    public List<Contact> findContactsByFirstNameOrLastName(@RequestParam("name") String name){
        return contactService.findContactsByFirstNameOrLastName(name);
    }

    @PostMapping
    public void addNewContact(@RequestBody Contact contact){
        contactService.addNewContact(contact);
    }

    @PutMapping("/{id}")
    public void updateContactById(@PathVariable int id,@RequestBody Contact contact){
        contactService.updateContactById(id, contact);
    }

}



