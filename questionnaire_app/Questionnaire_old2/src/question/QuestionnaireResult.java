/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package question;

import java.time.LocalDateTime;

/**
 *
 * @author javat
 */
public class QuestionnaireResult {

    private final Questionnaire questionnaire;
    private final User user;
    private double score;
    private boolean passed;
    private final LocalDateTime questionnaireTime;
    private final QuestionnaireRecord[] questionnaireRecords;

    private QuestionnaireResult(Builder b) {
        this.questionnaire = b.questionnaire;
        this.user = b.user;
        this.score = b.score;
        this.passed=b.passed;
        this.questionnaireTime = b.questionnaireTime;
        this.questionnaireRecords=b.questionnaireRecords;
    }
    public Questionnaire getQuestionnaire() {
        return questionnaire;
    }

    public User getUser() {
        return user;
    }

    public double getScore() {
        return score;
    }

    public boolean isPassed() {
        return passed;
    }

    public LocalDateTime getQuestionnaireTime() {
        return questionnaireTime;
    }

    public QuestionnaireRecord[] getQuestionnaireRecords() {
        return questionnaireRecords;
    }

    public void setScore(double score) {
        this.score = score;
    }

    public void setPassed(boolean passed) {
        this.passed = passed;
    }

    public static class Builder {

        private Questionnaire questionnaire;
        private User user;
        private double score;
        private boolean passed;
        private LocalDateTime questionnaireTime;
        private QuestionnaireRecord[] questionnaireRecords;

        public QuestionnaireResult build() {
            return new QuestionnaireResult(this);
        }
        public Builder questionnaire(Questionnaire questionnaire) {
            this.questionnaire = questionnaire;
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

        public Builder passed(boolean passed) {
            this.passed = passed;
            return this;
        }

        public Builder questionnaireTime(LocalDateTime questionnaireTime) {
            this.questionnaireTime = questionnaireTime;
            return this;
        }

        public Builder questionnaireRecords(QuestionnaireRecord[] questionnaireRecords) {
            this.questionnaireRecords = questionnaireRecords;
            return this;
        }

    }
}
