package com.ivan.spring_context.repo_example;

import java.util.Optional;

import com.ivan.spring_context.domain.Person;
import com.ivan.spring_context.java_based_beans.BeanA;
import com.ivan.spring_context.java_based_beans.BeanB;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository(value = "personDao")
public class PersonDaoSimple implements PersonDao {

    private BeanA beanA;
    private BeanB beanB;

    @Autowired
    public PersonDaoSimple(BeanA beanA){
        this.beanA = beanA;
    }

    @Autowired
    public void setBeanB(BeanB beanB){
        this.beanB = beanB;
    }

    @Override
    public Optional<Person> findPersonByName(String name) {
        return Optional.of(new Person("Jim", 22));
    }
    
    public void display() {
        System.out.println(beanA);
        System.out.println(beanB);
    }
}
