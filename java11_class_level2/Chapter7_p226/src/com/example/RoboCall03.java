package com.example;

import java.util.List;
import java.util.function.Predicate;

/**
 *
 *
 */
public class RoboCall03 {

    public static void main(String[] args) {

        List<Person> pl = Person.createShortList();
        RoboCall03 robo = new RoboCall03();

        System.out.println("\n=== Calling all Drivers ===");
        robo.phoneContacts(pl,
                new Predicate<Person>() {
            @Override
            public boolean test(Person p) {
                return p.getAge() >= 16;
            }
        }
        );

        System.out.println("\n=== Emailing all Draftees ===");
        robo.emailContacts(pl,
                new Predicate<Person>() {
            @Override
            public boolean test(Person p) {
                return p.getAge() >= 18 && p.getAge() <= 25 && p.getGender() == Gender.MALE;
            }
        }
        );

        System.out.println("\n=== Mail all Pilots ===");
        robo.mailContacts(pl,
                new Predicate<Person>() {
            @Override
            public boolean test(Person p) {
                return p.getAge() >= 23 && p.getAge() <= 65;
            }
        }
        );

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
