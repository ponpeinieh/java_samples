package questionnaire;

import java.time.LocalDateTime;
import java.util.List;

/**
 *
 * @author javat
 */
public interface QuestionnaireResult {

    public String getId();

    public Questionnaire getQuestionnaire();

    public User getUser();

    public double getScore();

    public boolean isPassed();

    public LocalDateTime getQuestionnaireTime();

    public List<AnswerRecord> getAnswerRecords();

    public void setScore(double score);

    public void setPassed(boolean passed);

}
