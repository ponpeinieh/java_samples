package questionnaire;

/**
 *
 * @author javat
 */
public interface AnswerRecord {

    public Questionnaire getQuestionnaire();

    public Question getQuestion();

    public Answer getAnswer();

    public User getUser();

    public double getScore();

    public void setScore(double score);

}
