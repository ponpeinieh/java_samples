package questionnaire;

/**
 *
 * @author javat
 */
public interface Answer {

    public int getSerial();

    public String getId();

//    public Question getQuestion();
    public boolean isBinaryAnswer();

    public boolean getBinaryAnswer();

    public void setBinaryAnswer(boolean binaryAnswer);

    public boolean isChoiceAnswer();

    public Choice[] getChoiceAnswer();

    public void setChoiceAnswer(Choice[] choiceAnswer);

    public boolean isTextAnswer();

    public String getTextAnswer();

    public void setTextAnswer(String textAnswer);

    public boolean isRatingAnswer();

    public double getRatingAnswer();

    public void setRatingAnswer(double ratingAnswer);

    public boolean isUserAnswered();

    public void setUserAnswered(boolean userAnswered);

    public boolean isCorrectAnswer();

}
