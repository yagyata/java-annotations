package com.bridgelabz.annotations;

class Animal {
    void makeSound() {
        System.out.println("Animal makes a sound");
    }
}

class Dog extends Animal {
    @Override
    void makeSound() {
        System.out.println("Dog Barks");
    }
}

public class OverrideAnnotation {
    public static void main(String[] args) {
        Dog dog = new Dog();
        dog.makeSound();
    }
}
