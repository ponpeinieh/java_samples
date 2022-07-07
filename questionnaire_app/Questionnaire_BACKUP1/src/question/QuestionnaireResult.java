
package question;

import java.time.LocalDateTime;

/**
 *
 * @author javat
 */
public interface QuestionnaireResult {

    public Questionnaire getQuestionnaire();

    public User getUser();

    public double getScore();

    public boolean isPassed();

    public LocalDateTime getQuestionnaireTime();

    public AnswerRecord[] getAnswerRecords();

    public void setScore(double score);

    public void setPassed(boolean passed);

}
