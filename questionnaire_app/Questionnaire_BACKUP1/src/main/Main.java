/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package main;

import question.Questionnaire;
import utils.QuestionUtils;

/**
 *
 * @author javat
 */
public class Main {
    
    public static void main(String[] args) {
        Questionnaire q = QuestionUtils.createQuestionnaire();
        System.out.println(q);
    }
}
