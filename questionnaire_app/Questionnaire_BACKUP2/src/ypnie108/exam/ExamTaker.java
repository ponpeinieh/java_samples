/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ypnie108.exam;

import questionnaire.User;

/**
 *
 * @author javat
 */
public class ExamTaker implements User {

    private static int NEXT_SERIAL = 101;
    private final int serial;
    private final String id;
    private final String email;
    private final String firstName;
    private final String lastName;

    @Override
    public int getSerial() {
        return serial;
    }

    @Override
    public String getId() {
        return id;
    }

    @Override
    public String getEmail() {
        return email;
    }

    @Override
    public String getFirstName() {
        return firstName;
    }

    @Override
    public String getLastName() {
        return lastName;
    }

    public ExamTaker(String id, String email, String firstName, String lastName) {
        this.serial = NEXT_SERIAL++;
        this.id = id;
        this.email = email;
        this.firstName = firstName;
        this.lastName = lastName;
    }
}
