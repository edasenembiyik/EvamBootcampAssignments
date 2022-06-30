package com;

import lombok.*;

// Lombok Library help us to create automaticly getter, setter, constructer, equals and hash code
// If we want to check all this methods implementations, we should check target package.

@Data   // Data creates getter and setter methods
@NoArgsConstructor  // NoArgsConstructor creates emty constructor
@AllArgsConstructor  // AllArgsConstructor creates constructer methods with all arguments
@EqualsAndHashCode  // override Equals And HashCode methods inside of the Object class
public class Student {

    private String name;
    private String surname;
    private int age;

}
