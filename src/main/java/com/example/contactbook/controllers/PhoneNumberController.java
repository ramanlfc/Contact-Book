package com.example.contactbook.controllers;

import com.example.contactbook.models.PhoneNumber;
import com.example.contactbook.services.PhoneNumberService;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/phonenumbers")
public class PhoneNumberController {

    private final PhoneNumberService phoneNumberService;

    public PhoneNumberController(PhoneNumberService phoneNumberService) {
        this.phoneNumberService = phoneNumberService;
    }

    @GetMapping
    public List<PhoneNumber> findAllPhoneNumbers(){
        return phoneNumberService.findAllPhoneNumbers();
    }

    @GetMapping("/{id}")
    public PhoneNumber findPhoneNumberById(@PathVariable int id){
        return phoneNumberService.findPhoneNumberById(id);
    }

    @DeleteMapping("/{id}")
    public void deletePhoneNumberById(@PathVariable int id){
        phoneNumberService.deletePhoneNumberById(id);
    }

    @PostMapping
    public void addNewPhoneNumber(@RequestBody PhoneNumber phoneNumber){
        System.out.println("");
        phoneNumberService.addPhoneNumber(phoneNumber);
    }

    @PutMapping("/{id}")
    public void updatePhoneNumberById(@PathVariable int id,@RequestBody PhoneNumber phoneNumber){
        phoneNumberService.updatePhoneNumberById(id, phoneNumber);
    }

    @GetMapping("/search")
    public List<PhoneNumber> findPhoneNumbersByContactId(@RequestParam int contactId){
        return phoneNumberService.findPhoneNumbersByContactId(contactId);
    }

}
