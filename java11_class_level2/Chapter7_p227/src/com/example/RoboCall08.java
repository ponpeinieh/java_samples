package com.example;

import java.util.List;
import java.util.function.Predicate;

/**
 *
 *
 */
public class RoboCall08 {

    public static void main(String[] args) {

        List<Person> pl = Person.createShortList();

        RoboCall08 robo = new RoboCall08();
        // Predicates
        Predicate<Person> allPilots
                = p -> p.getAge() >= 23 && p.getAge() <= 65;
        System.out.println("\n=== Calling all Pilots Lambda ===");
        pl.stream()
                .filter(allPilots)
                .forEach(p -> robo.roboCall(p));

        System.out.println("\n=== Mail all Pilots ===");
        robo.mailContacts(pl, allPilots);
        
    }

    public void phoneContacts(List<Person> pl, Predicate<Person> aTest) {
        pl.stream().filter(aTest).forEach(p -> roboCall(p));
    }

    public void emailContacts(List<Person> pl, Predicate<Person> aTest) {
        pl.stream().filter(aTest).forEach(p -> roboEmail(p));
    }

    public void mailContacts(List<Person> pl, Predicate<Person> aTest) {
        pl.stream().filter(aTest).forEach(p -> roboMail(p));
    }

    public void roboCall(Person p) {
        System.out.println("Calling " + p.getGivenName() + " " + p.getSurName() + " age " + p.getAge() + " at " + p.getPhone());
    }

    public void roboEmail(Person p) {
        System.out.println("EMailing " + p.getGivenName() + " " + p.getSurName() + " age " + p.getAge() + " at " + p.getEmail());
    }

    public void roboMail(Person p) {
        System.out.println("Mailing " + p.getGivenName() + " " + p.getSurName() + " age " + p.getAge() + " at " + p.getAddress() + ", " + p.getCity() + ", " + p.getState() + " " + p.getCode());
    }

}
