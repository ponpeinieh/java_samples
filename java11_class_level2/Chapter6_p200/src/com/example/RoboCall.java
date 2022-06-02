package com.example;

import java.util.List;

public class RoboCall {

    public static void main(String[] args) {

        //robocallEligible((Person p) -> p.getAge() >= 16);
        //robocallEligible((Person p) -> p.getAge() >= 18);
        //robocallEligible((Person p) -> p.getAge() >= 21);
        robocallEligible((Person p) -> p.getGender() == Gender.MALE && p.getAge() >= 18 && p.getAge() <= 25);
        //robocallEligible((Person p) -> { return p.getGender() == Gender.MALE && p.getAge() >= 18 && p.getAge() <= 25;});
        //robocallEligible((p) -> p.getGender() == Gender.MALE && p.getAge() >= 18 && p.getAge() <= 25);
        //robocallEligible((var p) -> p.getGender() == Gender.MALE && p.getAge() >= 18 && p.getAge() <= 25);
    }

    public static void robocallEligible(EligiblePerson tester) {

        List<Person> pl = Person.createShortList();
        for (Person p : pl) {
            if (tester.isEligible(p)) {
                RoboCall.roboCall(p);
            } else {
                System.out.println(p.getGivenName()
                        + " " + p.getSurName() + " age "
                        + p.getAge() + " gender " + p.getGender() + " 不符合資格!");
            }
        }
    }

    public static void roboCall(Person p) {
        System.out.println("打給 " + p.getGivenName()
                + " " + p.getSurName() + " age "
                + p.getAge() + " gender " + p.getGender() + " at " + p.getPhone());
    }
}

interface EligiblePerson {

    public boolean isEligible(Person p);
}
