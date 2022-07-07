/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package question;

/**
 *
 * @author javat
 */
public class SurveyQuestion extends Question {

    private SurveyQuestion(Builder b) {
        super(b);
    }

    @Override
    public CorrectAnswer getCorrectAnswer() {
        return null;
    }

    @Override
    public boolean hasCorrectAnswer() {
        return false;
    }

    public static class Builder extends Question.Builder {

        public SurveyQuestion build() {
            return new SurveyQuestion(this);
        }

    }
}
