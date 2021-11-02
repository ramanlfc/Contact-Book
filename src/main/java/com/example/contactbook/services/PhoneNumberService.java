package com.example.contactbook.services;

import com.example.contactbook.exceptions.NoSuchContactFoundException;
import com.example.contactbook.exceptions.NoSuchPhoneNumberFoundException;
import com.example.contactbook.models.Contact;
import com.example.contactbook.models.PhoneNumber;
import com.example.contactbook.repositories.ContactRepository;
import com.example.contactbook.repositories.PhoneNumberRepository;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;

@Service
public class PhoneNumberService {

    private final  PhoneNumberRepository phoneNumberRepository;
    private final ContactRepository contactRepository;

    public PhoneNumberService(PhoneNumberRepository phoneNumberRepository, ContactRepository contactRepository) {
        this.phoneNumberRepository = phoneNumberRepository;
        this.contactRepository = contactRepository;
    }

    public List<PhoneNumber> findAllPhoneNumbers(){
        return phoneNumberRepository.findAll();
    }

    public PhoneNumber findPhoneNumberById(int id){
        return phoneNumberRepository.findById(id)
                .orElseThrow(() -> new NoSuchPhoneNumberFoundException("no such phone number found by id: "+ id));
    }


    public void addPhoneNumber(PhoneNumber phoneNumber){
        phoneNumberRepository.save(phoneNumber);
    }

    public void deletePhoneNumberById(int id){
        phoneNumberRepository.deleteById(id);
    }

    public void updatePhoneNumberById(int id, PhoneNumber phoneNumber){
        PhoneNumber phoneNumberById = phoneNumberRepository.findById(id)
                .orElseThrow(() -> new NoSuchPhoneNumberFoundException("no such phone number found by id: " + id));

        phoneNumberById.setNumber(phoneNumber.getNumber());
        phoneNumberById.setPhoneType(phoneNumber.getPhoneType());
        phoneNumberById.setAddress(phoneNumber.getAddress());

        phoneNumberRepository.save(phoneNumberById);
    }

    public List<PhoneNumber> findPhoneNumbersByContactId(int contactId){
        return phoneNumberRepository.findPhoneNumbersByContactId(contactId);
    }

}
