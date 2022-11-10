package com.akurey;

import io.micronaut.core.annotation.Introspected;
import io.micronaut.core.annotation.NonNull;

/**
 * Person
 */
@Introspected
public class Person {
    @NonNull
    private final String name;
    private final String lastName;
    private final int age;

    public Person(final String name, final String lastName, final int age) {
        this.name = name;
        this.lastName = lastName;
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public String getLastName() {
        return lastName;
    }

    public int getAge() {
        return age;
    }
    
}
