package com.example.contactbook;

import com.example.contactbook.models.Address;
import com.example.contactbook.models.Contact;
import com.example.contactbook.models.PhoneNumber;
import com.example.contactbook.models.PhoneType;
import com.example.contactbook.repositories.ContactRepository;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.ApplicationContext;


@SpringBootTest
class ContactTests {

    @Autowired
    private ApplicationContext applicationContext;

    @Test
    void shouldAddNewContact() {

        var contact = new Contact();
        contact.setFirstName("john");
        contact.setLastName("doe");

 /*       List<PhoneNumber> phoneNumberList = List.of(new PhoneNumber("0123456789", PhoneType.HOME,contact,
                new Address("J1/39, DDA Flats, KalkaJi","New Delhi","Delhi","India", "110019")),
                new PhoneNumber("1568046978", PhoneType.PERSONAL,contact,
                new Address("J1/39, DDA Flats, KalkaJi","New Delhi","Delhi","India", "110019")));

        contact.setPhoneNumbers(phoneNumberList);
*/
        ContactRepository contactRepository = applicationContext.getBean(ContactRepository.class);

        contactRepository.save(contact);

        assertTrue(contact.getId() != 0);

    }

}
