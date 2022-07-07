/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package question;

/**
 *
 * @author javat
 */
public abstract class Choice {

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

    public int getDefaultOrder() {
        return defaultOrder;
    }

    public Question getQuestion() {
        return question;
    }

    public abstract boolean isImageContent();

    private final int serial;
    private final String id;
    private final String content;
    private final int defaultOrder;
    private final Question question;

    protected Choice(Builder b) {
        this.serial = NEXT_ID++;
        this.id = b.id;
        this.content = b.content;
        this.defaultOrder = b.defaultOrder;
        this.question = b.question;
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 89 * hash + this.serial;
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
        final Choice other = (Choice) obj;
        return this.serial == other.serial;
    }

    protected static class Builder {

        private String id;
        private String content;
        private int defaultOrder;
        private Question question;

        public Builder id(String id) {
            this.id = id;
            return this;
        }

        public Builder content(String content) {
            this.content = content;
            return this;
        }

        public Builder defaultOrder(int defaultOrder) {
            this.defaultOrder = defaultOrder;
            return this;
        }

        public Builder question(Question question) {
            this.question = question;
            return this;
        }
    }
}
