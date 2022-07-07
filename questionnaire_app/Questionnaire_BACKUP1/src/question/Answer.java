package question;

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

    public boolean isChoiceAnswer();

    public Choice[] getChoiceAnswer();

    public boolean isTextAnswer();

    public String getTextAnswer();

    public boolean isRatingAnswer();

    public double getRatingAnswer();

    public boolean isUserAnswered();

    public boolean isCorrectAnswer();

}
