package com.ivan.spring_context.repo_example;

import java.util.Optional;

import com.ivan.spring_context.domain.Person;
import org.springframework.stereotype.Repository;

@Repository(value = "personDao")
public class PersonDaoSimple implements PersonDao {

    @Override
    public Optional<Person> findPersonByName(String name) {
        return Optional.of(new Person("Jim", 22));
    }
    
}
