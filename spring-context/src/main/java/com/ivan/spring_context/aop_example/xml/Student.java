package com.ivan.spring_context.aop_example.xml;

public class Student {
    private Integer age;
    private String name;
    private Executor executor;

    public void setAge(Integer age) {
        this.age = age;
    }

    public Integer getAge() {
        System.out.println("Age : " + age);
        return age;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getName() {
        System.out.println("Name : " + name);
        return name;
    }

    
    
    public int getExecutorResult() {
        return executor.execute();
    }

    public void setExecutor(Executor executor) {
        this.executor = executor;
    }

    public void printThrowException() {
        System.out.println("Exception raised");
        throw new IllegalArgumentException();
    }
}
