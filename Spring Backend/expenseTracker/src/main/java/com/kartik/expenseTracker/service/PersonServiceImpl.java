package com.kartik.expenseTracker.service;

import com.kartik.expenseTracker.entity.Person;
import com.kartik.expenseTracker.repository.PersonRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Objects;
import java.util.Optional;

@Service
public class PersonServiceImpl implements PersonService {

    @Autowired
    private PersonRepository personRepository;
    @Override
    public Person savePerson(Person person) {
        return personRepository.save(person);
    }

    @Override
    public List<Person> getPerson() {
        return personRepository.findAll();
    }

    @Override
    public Optional<Person> getPersonById(Long Id) {
        return personRepository.findById(Id);
    }

    @Override
    public void deletePerson(Long id) {
        personRepository.deleteById(id);
    }

    @Override
    public Person updateUser(Long id, Person person) {
        Person personDB = personRepository.findById(id).get();

        if(Objects.nonNull(person.getName()) && !"".equalsIgnoreCase(person.getName())){
            personDB.setName(person.getName());
        }
        if(Objects.nonNull(person.getBalance())){
            personDB.setBalance(person.getBalance());
        }
        return personRepository.save(personDB);
    }
}
