package com.example.contactbook;

import com.example.contactbook.models.Address;
import com.example.contactbook.models.Contact;
import com.example.contactbook.models.PhoneNumber;
import com.example.contactbook.models.PhoneType;
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

        Contact johnDoe = new Contact("john", "doe", "johndoe@gmail.com", null);
        List<PhoneNumber> johnDoePhoneNumbers = List.of(new PhoneNumber("123456", PhoneType.HOME, johnDoe,new Address("abc street","New Delhi","Delhi","India","110019")));
        johnDoe.setPhoneNumbers(johnDoePhoneNumbers);

        contactRepository.save(johnDoe);

        Contact peterDoe = new Contact("peter", "doe", "peterdoe@gmail.com", null);
        List<PhoneNumber> peterDoePhoneNumbers = List.of(new PhoneNumber("235946", PhoneType.PERSONAL, peterDoe,new Address("xyz street","New Delhi","Delhi","India","110009")));
        peterDoe.setPhoneNumbers(peterDoePhoneNumbers);

        contactRepository.save(peterDoe);

    }
}
