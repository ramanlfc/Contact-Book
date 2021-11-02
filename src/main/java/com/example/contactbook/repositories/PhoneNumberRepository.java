package com.example.contactbook.repositories;

import com.example.contactbook.models.Contact;
import com.example.contactbook.models.PhoneNumber;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;
import java.util.Optional;

public interface PhoneNumberRepository extends JpaRepository<PhoneNumber, Integer> {

    List<PhoneNumber> findPhoneNumbersByContact(Contact contact);

    @Query(value = "select * from phone_number p where p.contact_id = :contactId", nativeQuery = true)
    List<PhoneNumber> findPhoneNumbersByContactId(@Param("contactId") int contactId);

}
