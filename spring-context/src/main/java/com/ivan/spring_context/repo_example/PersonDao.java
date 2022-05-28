package com.ivan.spring_context.repo_example;

import java.util.Optional;

import com.ivan.spring_context.domain.Person;

public interface PersonDao {
    Optional<Person> findPersonByName(String name);
}
