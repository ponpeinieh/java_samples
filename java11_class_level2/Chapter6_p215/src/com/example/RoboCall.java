package com.example;

import java.util.List;
import java.util.function.Predicate;

public class RoboCall {

    public static void main(String[] args) {

        robocallEligible((Person p) -> p.getGender() == Gender.MALE && p.getAge() >= 18 && p.getAge() <= 25);
    }

    public static void robocallEligible(Predicate<Person> tester) {

        List<Person> pl = Person.createShortList();
        for (Person p : pl) {
            if (tester.test(p)) { //call test() method in Predicate
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
