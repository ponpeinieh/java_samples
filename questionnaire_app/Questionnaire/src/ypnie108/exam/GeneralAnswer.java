package ypnie108.exam;

import question.Answer;
import question.Choice;
import question.QuestionType;

/**
 *
 * @author javat
 */
public class GeneralAnswer implements Answer {

    private static int NEXT_SERIAL = 101;
    private final int serial;
    private final String id;
//    private final Question question;
    private final QuestionType type;
    private boolean binaryAnswer;
    private Choice[] choiceAnswer;
    private String textAnswer;
    private double ratingAnswer;
    private final boolean correctAnswer;
    private boolean userAnswered;

    private GeneralAnswer(Builder b) {
        this.serial = NEXT_SERIAL++;
        this.id = b.id;
//        this.question = b.question;
        this.type = b.type;
        this.binaryAnswer = b.binaryAnswer;
        this.choiceAnswer = b.choiceAnswer;
        this.textAnswer = b.textAnswer;
//        this.ratingAnswer = b.ratingAnswer;
        this.correctAnswer = b.correctAnswer;
        this.userAnswered = b.userAnswered;
    }

    @Override
    public int getSerial() {
        return serial;
    }

    @Override
    public String getId() {
        return id;
    }

//    @Override
//    public Question getQuestion() {
//        return question;
//    }

    @Override
    public boolean isBinaryAnswer() {
        return type == QuestionType.BINARY;
    }

    @Override
    public boolean getBinaryAnswer() {
        if (isBinaryAnswer()) {
            return binaryAnswer;
        } else {
            throw new UnsupportedOperationException("Not a binary answer!");
        }
    }

    @Override
    public boolean isChoiceAnswer() {
        return type == QuestionType.MULTIPLE || type == QuestionType.SINGLE;
    }

    @Override
    public Choice[] getChoiceAnswer() {
        if (isChoiceAnswer()) {
            return choiceAnswer;
        } else {
            throw new UnsupportedOperationException("Not a choice answer!");
        }
    }

    @Override
    public boolean isTextAnswer() {
        return type == QuestionType.TEXT || type == QuestionType.TEXTFIELD;
    }

    @Override
    public String getTextAnswer() {
        if (isTextAnswer()) {
            return textAnswer;
        } else {
            throw new UnsupportedOperationException("Not a text answer!");
        }
    }

    @Override
    public boolean isCorrectAnswer() {
        return correctAnswer;
    }

    @Override
    public boolean isRatingAnswer() {
        return type == QuestionType.RATING;
    }

    @Override
    public double getRatingAnswer() {
        if (isRatingAnswer()) {
            return ratingAnswer;
        } else {
            throw new UnsupportedOperationException("Not a rating answer!");
        }
    }

    @Override
    public boolean isUserAnswered() {
        return userAnswered;
    }

    @Override
    public void setBinaryAnswer(boolean binaryAnswer) {
        this.binaryAnswer = binaryAnswer;
    }

    @Override
    public void setChoiceAnswer(Choice[] choiceAnswer) {
        this.choiceAnswer = choiceAnswer;
    }

    @Override
    public void setTextAnswer(String textAnswer) {
        this.textAnswer = textAnswer;
    }

    @Override
    public void setRatingAnswer(double ratingAnswer) {
        this.ratingAnswer = ratingAnswer;
    }

    @Override
    public void setUserAnswered(boolean userAnswered) {
        this.userAnswered = userAnswered;
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 29 * hash + this.serial;
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final GeneralAnswer other = (GeneralAnswer) obj;
        return this.serial == other.serial;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder("Answer{binaryAnswer=");
        sb.append(binaryAnswer);
        sb.append(", choiceAnswer=");
        if (choiceAnswer != null) {
            for (var v : choiceAnswer) {
                sb.append(v).append(",");
            }
        }
        sb.append(", textAnswer=").append(textAnswer).append('}');
        return sb.toString();
    }

    public static class Builder {

        private String id;
//        private Question question;
        private QuestionType type;
        private boolean binaryAnswer;
        private Choice[] choiceAnswer;
        private String textAnswer;
//        private double ratingAnswer;
        private boolean correctAnswer;
        private boolean userAnswered;

        public Builder id(String id) {
            this.id = id;
            return this;
        }
//
//        public Builder question(Question question) {
//            this.question = question;
//            return this;
//        }

        public Builder questionType(QuestionType type) {
            this.type = type;
            return this;
        }

        public Builder binaryAnswer(boolean binaryAnswer) {
            this.binaryAnswer = binaryAnswer;
            return this;
        }

        public Builder choiceAnswer(Choice[] choiceAnswer) {
            this.choiceAnswer = choiceAnswer;
            return this;
        }

        public Builder textAnswer(String textAnswer) {
            this.textAnswer = textAnswer;
            return this;
        }

//        public Builder ratingAnswer(double ratingAnswer) {
//            this.ratingAnswer = ratingAnswer;
//            return this;
//        }

        public Builder correctAnswer(boolean correctAnswer) {
            this.correctAnswer = correctAnswer;
            return this;
        }

        public Builder userAnswered(boolean userAnswered) {
            this.userAnswered = userAnswered;
            return this;
        }
        public GeneralAnswer build() {
            return new GeneralAnswer(this);
        }
    }
}
