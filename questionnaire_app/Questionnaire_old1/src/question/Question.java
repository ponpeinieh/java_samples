/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package question;

import java.time.LocalDateTime;

public abstract class Question {

    private static int NEXT_ID = 101;

    public int getSerial() {
        return serial;
    }

    public String getId() {
        return id;
    }

    public String getContent() {
        return content;
    }

    public QuestionType getType() {
        return type;
    }

    public String[] getTags() {
        return tags;
    }

    public LocalDateTime getCreate_time() {
        return create_time;
    }

    public Choice[] getChoices() {
        return choices;
    }

    public RatingType getRatingType() {
        return ratingType;
    }

    public void setChoices(Choice[] choices) {
        this.choices = choices;
    }

    public abstract CorrectAnswer getCorrectAnswer();

    public abstract boolean hasCorrectAnswer();

    @Override
    public int hashCode() {
        int hash = 5;
        hash = 11 * hash + this.serial;
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
        final Question other = (Question) obj;
        return this.serial == other.serial;
    }

    private final int serial;
    private final String id;
    private final String content;
    private final QuestionType type;
    private final String[] tags;
    private final LocalDateTime create_time;
    private Choice[] choices;
    private final RatingType ratingType;

    protected Question(Builder b) {
        this.serial = Question.NEXT_ID++;
        this.id = b.id;
        this.content = b.content;
        this.type = b.type;
        this.tags = b.tags;
        this.choices = b.choices;
        this.create_time = b.create_time;
        this.ratingType = b.ratingType;
    }

    protected static class Builder {

        private String id;
        private String content;
        private QuestionType type;
        private String[] tags;
        private LocalDateTime create_time;
        private Choice[] choices;
        private RatingType ratingType;

        public Builder id(String id) {
            this.id = id;
            return this;
        }

        public Builder content(String content) {
            this.content = content;
            return this;
        }

        public Builder type(QuestionType type) {
            this.type = type;
            return this;
        }

        public Builder tags(String[] tags) {
            this.tags = tags;
            return this;
        }

        public Builder create_time(LocalDateTime create_time) {
            this.create_time = create_time;
            return this;
        }

        public Builder choices(Choice[] choices) {
            this.choices = choices;
            return this;
        }

        public Builder ratingType(RatingType ratingType) {
            this.ratingType = ratingType;
            return this;
        }
    }
}
