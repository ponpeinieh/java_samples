package ypnie108.exam;

import java.time.LocalDateTime;
import java.util.List;
import questionnaire.AnswerRecord;
import questionnaire.Questionnaire;
import questionnaire.QuestionnaireResult;
import questionnaire.User;

/**
 *
 * @author javat
 */
public class ExamResult implements QuestionnaireResult {

    private final String id;
    private final Questionnaire questionnaire;
    private final User user;
    private double score;
    private boolean passed;
    private final LocalDateTime questionnaireTime;
    private final List<AnswerRecord> answerRecords;

    private ExamResult(Builder b) {
        this.id = b.id;
        this.questionnaire = b.questionnaire;
        this.user = b.user;
        this.score = b.score;
        this.passed = b.passed;
        this.questionnaireTime = b.questionnaireTime;
        this.answerRecords = b.answerRecords;
    }

    @Override
    public String getId() {
        return id;
    }

    @Override
    public Questionnaire getQuestionnaire() {
        return questionnaire;
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
    public boolean isPassed() {
        return passed;
    }

    @Override
    public LocalDateTime getQuestionnaireTime() {
        return questionnaireTime;
    }

    @Override
    public List<AnswerRecord> getAnswerRecords() {
        return answerRecords;
    }

    @Override
    public void setScore(double score) {
        this.score = score;
    }

    @Override
    public void setPassed(boolean passed) {
        this.passed = passed;
    }

    public static class Builder {

        private String id;
        private Questionnaire questionnaire;
        private User user;
        private double score;
        private boolean passed;
        private LocalDateTime questionnaireTime;
        private List<AnswerRecord> answerRecords;

        public ExamResult build() {
            return new ExamResult(this);
        }

        public Builder id(String id) {
            this.id = id;
            return this;
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

        public Builder answerRecords(List<AnswerRecord> answerRecords) {
            this.answerRecords = answerRecords;
            return this;
        }

    }
}
