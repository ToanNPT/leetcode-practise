package com.javacore.practise;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * ReferenceTest
 * <p>
 * This class demonstrates how reference works in Java. In Java, the arguments will be pass to methods in only mode pass by value.
 * The primitive data types are passed by value, and the objects also passed by value, but the value is the reference of the object.
 * <p>
 * In the example, the main method creates a Dog object with the name "Chau", then they call the changeReference method
 * and make a copy of reference of the Dog then pass to changeReference method. Inside the changeReference method,
 * the dog reference is changed to a new Dog object with the name "Alex". But the original dog object is not changed.
 * Because the reassignment of the reference inside the changeReference method does not affect the original reference in the main method
 */
public class ReferenceTest {


    public static void main(String[] args) {
        Dog dog = new Dog("Chau");
        System.out.println("Before change reference: " + dog.getName());

        //make a copy of reference to heap, then pass to changeReference method
        changeReference(dog);
        System.out.println("After change reference: " + dog.getName());


        //EXAMPLE 2:
        Integer number = 100;
        System.out.println("Before change primitive: " + number);
        changeWrapperClass(number);
        System.out.println("After change primitive: " + number);

        //EXAMPLE 3:
        int numberPrimitive = 100;
        System.out.println("Before change primitive: " + numberPrimitive);
        changePrimitive(numberPrimitive);
        System.out.println("After change primitive: " + numberPrimitive);

        //SOLUTION FOR EXAMPLE 2 AND 3:
        //If you want to change the value of the primitive data type, you can return the new value from the method
        //or use the mutable object as AtomicInteger, AtomicLong, AtomicBoolean, etc.
        AtomicInteger numAtomic = new AtomicInteger(100);
        System.out.println("Before change atomic type: " + numAtomic.get());
        changeAtomicType(numAtomic);
        System.out.println("After change atomic type: " + numAtomic.get());

        //EXAMPLE 4:
        List<Integer> list = new ArrayList<>();
        list.add(0);
        list.add(2);
        System.out.println("Before change collection: " + Arrays.toString(list.toArray()));
        changeCollection(list);
        System.out.println("After change collection: " + Arrays.toString(list.toArray()));

    }

    public static void changeReference(Dog dog) {
        //the changeReference method will not affect the original reference in the main method
        //only reassigned the reference in local scope (this is stored in stack) to a new Dog object
        //when get out this, the reference will be removed from stack, and the original still refer to the old object
        dog = new Dog("Alex");
    }

    //EXAMPLE 2
    public static void changeWrapperClass(Integer number) {
        number = 99;
    }

    //EXAMPLE 3
    //because the Java will take a copy, then pass to the changePrimitive(), so this will be placed on another location in stack memory
    //the modify only affect the copy (local variable), but when get out the method, the copy will be removed with the method, and the original still refer to the old value
    public static void changePrimitive(int number) {
        number = 99;
    }

    public static void changeAtomicType(AtomicInteger number) {
        number.set(99);
    }

    public static void changeCollection(List<Integer> list) {
        list = new ArrayList<>();
        list.add(1);
    }

    public static class Dog {
        private String name;

        public Dog(String name) {
            this.name = name;
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }
    }
}


