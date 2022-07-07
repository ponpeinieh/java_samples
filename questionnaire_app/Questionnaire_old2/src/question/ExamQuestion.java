/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package question;

/**
 *
 * @author javat
 */
public class ExamQuestion extends Question {

    private CorrectAnswer correctAnswer;

    private ExamQuestion(Builder b) {
        super(b);
        this.correctAnswer = b.correctAnswer;
    }

    @Override
    public CorrectAnswer getCorrectAnswer() {
        return this.correctAnswer;
    }

    @Override
    public boolean hasCorrectAnswer() {
        return true;
    }

    public void setCorrectAnswer(CorrectAnswer correctAnswer) {
        this.correctAnswer = correctAnswer;
    }

    public static class Builder extends Question.Builder {

        private CorrectAnswer correctAnswer;

        public ExamQuestion build() {
            return new ExamQuestion(this);
        }

        public Builder correctAnswer(CorrectAnswer correctAnswer) {
            this.correctAnswer = correctAnswer;
            return this;
        }
    }
}
