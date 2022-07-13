package ypnie108.exam;

import questionnaire.Answer;
import questionnaire.AnswerRecord;
import questionnaire.Question;
import questionnaire.Questionnaire;
import questionnaire.User;

/**
 *
 * @author javat
 */
public class ExamAnswerRecord implements AnswerRecord {

    private final Questionnaire questionnaire;
    private final Question question;
    private final Answer answer;
    private final User user;
    private double score;

    private ExamAnswerRecord(Builder b) {
        this.questionnaire = b.questionnaire;
        this.question = b.question;
        this.answer = b.answer;
        this.user = b.user;
        this.score = b.score;
    }

    @Override
    public Questionnaire getQuestionnaire() {
        return questionnaire;
    }

    @Override
    public Question getQuestion() {
        return question;
    }

    @Override
    public Answer getAnswer() {
        return answer;
    }

    @Override
    public User getUser() {
        return user;
    }

    @Override
    public double getScore() {
        return score;
    }

    @Override
    public void setScore(double score) {
        this.score = score;
    }

    public static class Builder {

        private Questionnaire questionnaire;
        private Question question;
        private Answer answer;
        private User user;
        private double score;

        public ExamAnswerRecord build() {
            return new ExamAnswerRecord(this);
        }

        public Builder questionnaire(Questionnaire questionnaire) {
            this.questionnaire = questionnaire;
            return this;
        }

        public Builder question(Question question) {
            this.question = question;
            return this;
        }

        public Builder answer(Answer answer) {
            this.answer = answer;
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
