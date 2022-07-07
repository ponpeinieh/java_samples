/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package question;

/**
 *
 * @author javat
 */
public abstract class Answer {

    private static int NEXT_ID = 101;
    private final int serial;
    private final String id;
    private final Question question;
    private final boolean binaryAnswer;
    private final Choice[] choiceAnswer;
    private final String textAnswer;

    protected Answer(Builder b) {
        this.serial = NEXT_ID++;
        this.id = b.id;
        this.question = b.question;
        this.binaryAnswer = b.binaryAnswer;
        this.choiceAnswer = b.choiceAnswer;
        this.textAnswer = b.textAnswer;
    }

    public int getSerial() {
        return serial;
    }

    public String getId() {
        return id;
    }

    public Question getQuestion() {
        return question;
    }

    public boolean isBinaryAnswer() {
        return binaryAnswer;
    }

    public Choice[] getChoiceAnswer() {
        return choiceAnswer;
    }

    public String getTextAnswer() {
        return textAnswer;
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
        final Answer other = (Answer) obj;
        return this.serial == other.serial;
    }

    protected static class Builder {

        private String id;
        private Question question;
        private boolean binaryAnswer;
        private Choice[] choiceAnswer;
        private String textAnswer;

        public Builder id(String id) {
            this.id = id;
            return this;
        }

        public Builder question(Question question) {
            this.question = question;
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
    }
}
