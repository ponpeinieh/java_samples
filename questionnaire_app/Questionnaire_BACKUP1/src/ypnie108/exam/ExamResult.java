
package ypnie108.exam;

import java.time.LocalDateTime;
import question.AnswerRecord;
import question.Questionnaire;
import question.QuestionnaireResult;
import question.User;

/**
 *
 * @author javat
 */
public class ExamResult implements QuestionnaireResult {

    private final Questionnaire questionnaire;
    private final User user;
    private double score;
    private boolean passed;
    private final LocalDateTime questionnaireTime;
    private final AnswerRecord[] answerRecords;

    private ExamResult(Builder b) {
        this.questionnaire = b.questionnaire;
        this.user = b.user;
        this.score = b.score;
        this.passed = b.passed;
        this.questionnaireTime = b.questionnaireTime;
        this.answerRecords = b.answerRecords;
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
    public AnswerRecord[] getAnswerRecords() {
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

        private Questionnaire questionnaire;
        private User user;
        private double score;
        private boolean passed;
        private LocalDateTime questionnaireTime;
        private AnswerRecord[] answerRecords;

        public ExamResult build() {
            return new ExamResult(this);
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

        public Builder answerRecords(AnswerRecord[] answerRecords) {
            this.answerRecords = answerRecords;
            return this;
        }

    }
}
