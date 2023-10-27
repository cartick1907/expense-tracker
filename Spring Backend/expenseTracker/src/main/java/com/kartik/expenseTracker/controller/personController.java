package com.kartik.expenseTracker.controller;

import com.kartik.expenseTracker.entity.Person;
import com.kartik.expenseTracker.service.PersonService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
public class personController {

    @Autowired
    private PersonService personService;

    @PostMapping("/persons")
    public Person savePerson(@RequestBody Person person){
        return personService.savePerson(person);
    }

    @GetMapping("/persons")
    public List<Person> getPerson(){
        return personService.getPerson();

    }

    @GetMapping("/persons/{id}")
    public Optional<Person> getPersonByID(@PathVariable("id") Long Id){
        return personService.getPersonById(Id);
    }

    @DeleteMapping("/persons/{id}")
    public String deleteUser(@PathVariable("id") Long Id){
        personService.deletePerson(Id);
        return "User removed";
    }

    @PutMapping("/persons/{id}")
    public Person updateUser(@PathVariable("id") Long id,
                             @RequestBody Person person){
        return personService.updateUser(id,person);
    }
}
