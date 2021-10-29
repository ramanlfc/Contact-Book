package com.example.contactbook.repositories;

import com.example.contactbook.models.PhoneNumber;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface PhoneNumberRepository extends JpaRepository<PhoneNumber, Integer> {

    Optional<PhoneNumber> findPhoneNumberByNumber(String number);

}
