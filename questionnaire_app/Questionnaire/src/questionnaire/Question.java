package questionnaire;

import java.time.LocalDateTime;
import java.util.List;

public interface Question {

    public int getSerial();

    public String getId();

    public String getContent();

    public QuestionType getType();

    public List<String> getTags();

    public LocalDateTime getCreate_time();

    public List<Choice> getChoices();

    public RatingType getRatingType();

    public void setChoices(List<Choice> choices);

    public Answer getCorrectAnswer();

    public boolean hasCorrectAnswer();

}
