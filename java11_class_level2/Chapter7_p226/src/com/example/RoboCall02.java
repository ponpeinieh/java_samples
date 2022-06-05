package com.example;

import java.util.List;

/**
 *
 *
 */
public class RoboCall02 {

    public static void main(String[] args) {

        List<Person> pl = Person.createShortList();
        RoboCall02 robo = new RoboCall02();

        System.out.println("\n=== Calling all Drivers ===");
        robo.callDrivers(pl);

        System.out.println("\n=== Emailing all Draftees ===");
        robo.emailDraftees(pl);

        System.out.println("\n=== Mail all Pilots ===");
        robo.mailPilots(pl);

    }

    public void callDrivers(List<Person> pl) {
        for (Person p : pl) {
            if (isDriver(p)) {
                roboCall(p);
            }
        }
    }

    public void emailDraftees(List<Person> pl) {
        for (Person p : pl) {
            if (isDraftee(p)) {
                roboEmail(p);
            }
        }
    }

    public void mailPilots(List<Person> pl) {
        for (Person p : pl) {
            if (isPilot(p)) {
                roboMail(p);
            }
        }
    }

    public boolean isDriver(Person p) {
        return p.getAge() >= 16;
    }

    public boolean isDraftee(Person p) {
        return p.getAge() >= 18 && p.getAge() <= 25 && p.getGender() == Gender.MALE;
    }

    public boolean isPilot(Person p) {
        return p.getAge() >= 23 && p.getAge() <= 65;
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
