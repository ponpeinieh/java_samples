/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package question;

/**
 *
 * @author javat
 */
public class QuestionnaireRecord {

    private final Questionnaire questionnaire;
    private final Question question;
    private final ResponseAnswer responseAnswer;
    private final User user;
    private double score;

    private QuestionnaireRecord(Builder b) {
        this.questionnaire = b.questionnaire;
        this.question = b.question;
        this.responseAnswer = b.responseAnswer;
        this.user = b.user;
        this.score = b.score;
    }

    public Questionnaire getQuestionnaire() {
        return questionnaire;
    }

    public Question getQuestion() {
        return question;
    }

    public ResponseAnswer getResponseAnswer() {
        return responseAnswer;
    }

    public User getUser() {
        return user;
    }

    public double getScore() {
        return score;
    }

    public void setScore(double score) {
        this.score = score;
    }

    public static class Builder {

        private Questionnaire questionnaire;
        private Question question;
        private ResponseAnswer responseAnswer;
        private User user;
        private double score;

        public QuestionnaireRecord build() {
            return new QuestionnaireRecord(this);
        }

        public Builder questionnaire(Questionnaire questionnaire) {
            this.questionnaire = questionnaire;
            return this;
        }

        public Builder question(Question question) {
            this.question = question;
            return this;
        }

        public Builder responseAnswer(ResponseAnswer responseAnswer) {
            this.responseAnswer = responseAnswer;
            return this;
        }

        public Builder user(User user) {
            this.user = user;
            return this;
        }

        public Builder score(double score) {
            this.score = score;
            return this;
        }
    }
}
