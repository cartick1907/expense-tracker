package com.kartik.expenseTracker.service;

import com.kartik.expenseTracker.entity.Person;

import java.util.List;
import java.util.Optional;

public interface PersonService {
    Person savePerson(Person person);

    List<Person> getPerson();

    Optional<Person> getPersonById(Long Id);

    void deletePerson(Long id);

    Person updateUser(Long id, Person person);
}
