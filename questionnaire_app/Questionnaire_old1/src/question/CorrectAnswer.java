/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package question;

/**
 *
 * @author javat
 */
public class CorrectAnswer extends Answer {

    private CorrectAnswer(Builder b) {
        super(b);
    }

    public static class Builder extends Answer.Builder {
 
        public CorrectAnswer build() {
            return new CorrectAnswer(this);
        }

    }
}
