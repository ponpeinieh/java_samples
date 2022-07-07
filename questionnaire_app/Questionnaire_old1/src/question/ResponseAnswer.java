/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package question;

/**
 *
 * @author javat
 */
public class ResponseAnswer extends Answer {

    private final boolean answered;
    private final double ratingAnswer;

    private ResponseAnswer(Builder b) {
        super(b);
        this.answered = b.answered;
        this.ratingAnswer = b.ratingAnswer;
    }

    public boolean isAnswered() {
        return answered;
    }

    public double getRatingAnswer() {
        return ratingAnswer;
    }

    public static class Builder extends Answer.Builder {

        private boolean answered;
        private double ratingAnswer;

        public Builder answered(boolean answered) {
            this.answered = answered;
            return this;
        }

        public Builder ratingAnswer(double ratingAnswer) {
            this.ratingAnswer = ratingAnswer;
            return this;
        }

        public ResponseAnswer build() {
            return new ResponseAnswer(this);
        }

    }
}
