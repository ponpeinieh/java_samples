/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package question;

import java.time.LocalDateTime;

public abstract class Questionnaire {

    private static int NEXT_ID = 101;

    public int getSerial() {
        return serial;
    }

    public String getId() {
        return id;
    }

    public String getTitle() {
        return title;
    }

    public Question[] getQuestions() {
        return questions;
    }

    public double[] getQuestionScores() {
        return questionScores;
    }

    public boolean isRandomOrder() {
        return randomOrder;
    }

    public int getDurationInSecs() {
        return durationInSecs;
    }

    public double getPassScore() {
        return passScore;
    }

    public LocalDateTime getCreateTime() {
        return createTime;
    }

    public LocalDateTime getScheduleTime() {
        return scheduleTime;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder("Questionnaire{title=");
        sb.append(title.length() > 20 ? title.substring(0, 20) + "..." : title);
        sb.append(", questions=");
        if (questions != null) {
            for (var v : questions) {
                sb.append(v).append(",");
            }
        }
        sb.append('}');
        return sb.toString();
    }

    private final int serial;
    final private String id;
    final private String title;
    final private Question[] questions;
    final private double[] questionScores;
    final private boolean randomOrder;
    final private int durationInSecs;
    final private double passScore;
    final private LocalDateTime createTime;
    final private LocalDateTime scheduleTime;

    protected Questionnaire(Builder b) {
        this.serial = NEXT_ID++;
        this.id = b.id;
        this.title = b.title;
        this.questions = b.questions;
        this.questionScores = b.questionScores;
        this.randomOrder = b.randomOrder;
        this.durationInSecs = b.durationInSecs;
        this.passScore = b.passScore;
        this.createTime = b.createTime;
        this.scheduleTime = b.scheduleTime;
    }

    public static class Builder {

        private String id;
        private String title;
        private Question[] questions;
        private double[] questionScores;
        private boolean randomOrder;
        private int durationInSecs;
        private double passScore;
        private LocalDateTime createTime;
        private LocalDateTime scheduleTime;

        /*
        public Questionnaire build() {
            return new Questionnaire(this);
        }
         */
        public Builder id(String id) {
            this.id = id;
            return this;
        }

        public Builder title(String title) {
            this.title = title;
            return this;
        }

        public Builder questions(Question[] questions) {
            this.questions = questions;
            return this;
        }

        public Builder questionScores(double[] questionScores) {
            this.questionScores = questionScores;
            return this;
        }

        public Builder randomOrder(boolean randomOrder) {
            this.randomOrder = randomOrder;
            return this;
        }

        public Builder durationInSecs(int durationInSecs) {
            this.durationInSecs = durationInSecs;
            return this;
        }

        public Builder passScore(double passScore) {
            this.passScore = passScore;
            return this;
        }

        public Builder createTime(LocalDateTime createTime) {
            this.createTime = createTime;
            return this;
        }

        public Builder scheduleTime(LocalDateTime scheduleTime) {
            this.scheduleTime = scheduleTime;
            return this;
        }
    }
}
