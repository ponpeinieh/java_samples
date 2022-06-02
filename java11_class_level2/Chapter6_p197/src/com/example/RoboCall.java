package com.example;

import java.util.List;

public class RoboCall {

    public static void main(String[] args) {
        // Pass isEligible method wrapped within an object
        EligiblePerson eTester = new DriverEligibilityTester();
        robocallEligible(eTester);
    }

    public static void robocallEligible(EligiblePerson tester) {

        List<Person> pl = Person.createShortList();
        for (Person p : pl) {
            if (tester.isEligible(p)) { 
                RoboCall.roboCall(p);
            } else {
                System.out.println(p.getGivenName()
                        + " " + p.getSurName() + " age "
                        + p.getAge() + " 不符合資格!");
            }
        }
    }

    public static void roboCall(Person p) {
        System.out.println("打給 " + p.getGivenName()
                + " " + p.getSurName() + " age "
                + p.getAge() + " at " + p.getPhone());
    }
}
interface EligiblePerson {
    public boolean isEligible(Person p);
}

class DriverEligibilityTester implements EligiblePerson{

    @Override
    public boolean isEligible(Person p) {
        return p.getAge() >= 16;
    }
}
