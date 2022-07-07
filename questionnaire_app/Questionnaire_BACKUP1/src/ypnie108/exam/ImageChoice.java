package ypnie108.exam;

import question.Choice;

/**
 *
 * @author javat
 */
public class ImageChoice implements Choice {

    private static int NEXT_SERIAL = 101;

    private final int serial;
    private final String id;
    private final String content;
    private final int defaultOrder;
    //private final Question question;

    private ImageChoice(Builder b) {
        this.serial = NEXT_SERIAL++;
        this.id = b.id;
        this.content = b.content;
        this.defaultOrder = b.defaultOrder;
        //this.question = b.question;
    }

    @Override
    public int getSerial() {
        return serial;
    }

    @Override
    public String getId() {
        return id;
    }

    @Override
    public String getContent() {
        return content;
    }

    @Override
    public int getDefaultOrder() {
        return defaultOrder;
    }

//    @Override
//    public Question getQuestion() {
//        return question;
//    }

    @Override
    public boolean isImageContent() {
        return true;
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
        final ImageChoice other = (ImageChoice) obj;
        return this.serial == other.serial;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder("Choice{content=");
        sb.append(content.length() > 20 ? content.substring(0, 20) + "..." : content);
        sb.append(", defaultOrder=").append(defaultOrder).append('}');
        return sb.toString();
    }

    public static class Builder {

        private String id;
        private String content;
        private int defaultOrder;
//        private Question question;

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

//        public Builder question(Question question) {
//            this.question = question;
//            return this;
//        }

        public ImageChoice build() {
            return new ImageChoice(this);
        }
    }
}
