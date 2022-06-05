package com.example;

import java.util.List;
import java.util.function.Predicate;

/**
 *
 *
 */
public class RoboCall05 {

    public static void main(String[] args) {

        List<Person> pl = Person.createShortList();
        RoboCall05 robo = new RoboCall05();
        // Predicates
        Predicate<Person> allDrivers = p -> p.getAge() >= 16;
        Predicate<Person> allDraftees = p -> p.getAge() >= 18
                && p.getAge() <= 25 && p.getGender() == Gender.MALE;
        Predicate<Person> allPilots = p -> p.getAge() >= 23
                && p.getAge() <= 65;

        System.out.println("\n=== Calling all Drivers ===");
        robo.phoneContacts(pl, allDrivers);

        System.out.println("\n=== Emailing all Draftees ===");
        robo.emailContacts(pl, allDraftees);

        System.out.println("\n=== Mail all Pilots ===");
        robo.mailContacts(pl, allPilots);

    }

    public void phoneContacts(List<Person> pl, Predicate<Person> aTest) {
        for (Person p : pl) {
            if (aTest.test(p)) {
                roboCall(p);
            }
        }
    }

    public void emailContacts(List<Person> pl, Predicate<Person> aTest) {
        for (Person p : pl) {
            if (aTest.test(p)) {
                roboEmail(p);
            }
        }
    }

    public void mailContacts(List<Person> pl, Predicate<Person> aTest) {
        for (Person p : pl) {
            if (aTest.test(p)) {
                roboMail(p);
            }
        }
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
