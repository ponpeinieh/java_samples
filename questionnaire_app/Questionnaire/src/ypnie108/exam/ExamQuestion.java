package ypnie108.exam;

import java.time.LocalDateTime;
import java.util.List;
import questionnaire.Choice;
import questionnaire.Answer;
import questionnaire.Question;
import questionnaire.QuestionType;
import questionnaire.RatingType;

public class ExamQuestion implements Question {

    private static int NEXT_SERIAL = 101;

    private final int serial;
    private final String id;
    private final String content;
    private final QuestionType type;
    private final List<String> tags;
    private final LocalDateTime create_time;
    private List<Choice> choices;
    private final RatingType ratingType;
    private Answer correctAnswer;

    private ExamQuestion(Builder b) {
        this.serial = ExamQuestion.NEXT_SERIAL++;
        this.id = b.id;
        this.content = b.content;
        this.type = b.type;
        this.tags = b.tags;
        this.choices = b.choices;
        this.create_time = b.create_time;
        this.ratingType = b.ratingType;
        this.correctAnswer = b.correctAnswer;
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
    public QuestionType getType() {
        return type;
    }

    @Override
    public List<String> getTags() {
        return tags;
    }

    @Override
    public LocalDateTime getCreate_time() {
        return create_time;
    }

    @Override
    public List<Choice> getChoices() {
        return choices;
    }

    @Override
    public RatingType getRatingType() {
        return ratingType;
    }

    @Override
    public void setChoices(List<Choice> choices) {
        this.choices = choices;
    }

    @Override
    public Answer getCorrectAnswer() {
        return this.correctAnswer;
    }

    @Override
    public boolean hasCorrectAnswer() {
        return true;
    }

    public void setCorrectAnswer(Answer correctAnswer) {
        this.correctAnswer = correctAnswer;
    }

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
        final ExamQuestion other = (ExamQuestion) obj;
        return this.serial == other.serial;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder("Question{content=");
        sb.append(content.length() > 20 ? content.substring(0, 20) + "..." : content);
        sb.append(", type=").append(type);
        sb.append(", choices=");
        if (choices != null) {
            for (var v : choices) {
                sb.append(v).append(",");
            }
        }
        sb.append(hasCorrectAnswer() ? ", correctAnswer=" + getCorrectAnswer() : "").append('}');
        return sb.toString();
    }

    public static class Builder {

        private String id;
        private String content;
        private QuestionType type;
        private List<String> tags;
        private LocalDateTime create_time;
        private List<Choice> choices;
        private RatingType ratingType;
        private Answer correctAnswer;

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

        public Builder tags(List<String> tags) {
            this.tags = tags;
            return this;
        }

        public Builder create_time(LocalDateTime create_time) {
            this.create_time = create_time;
            return this;
        }

        public Builder choices(List<Choice> choices) {
            this.choices = choices;
            return this;
        }

        public Builder ratingType(RatingType ratingType) {
            this.ratingType = ratingType;
            return this;
        }

        public Builder correctAnswer(Answer correctAnswer) {
            this.correctAnswer = correctAnswer;
            return this;
        }

        public ExamQuestion build() {
            return new ExamQuestion(this);
        }

    }
}
