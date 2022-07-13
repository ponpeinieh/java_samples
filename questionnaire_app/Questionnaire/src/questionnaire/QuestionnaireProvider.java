package questionnaire;

import java.util.List;

/**
 *
 * @author javat
 */
public interface QuestionnaireProvider {

    public User createUser();

    public QuestionnaireResult createQuestionnaireResult(User user, Questionnaire qn);

    public Question createChoiceQuestion(String questContent, List<String> choiceContents, List<Integer> correctAnswers, List<String> tags);

    public Question createTextQuestion(String questContent, String correctTextAnswer, List<String> tags);

    public Question createMultiTextQuestion(String questContent, String correctMultiTextAnswer, List<String> tags);

    public Question createBinaryQuestion(String questContent, boolean correctBinaryAnswer, List<String> tags);

    public Questionnaire createQuestionnaire();

    public void parseAnswer(String answerString, Answer answer) throws Exception;

    public int checkChoiceAnswerSingle(String answerString, Question q) throws Exception;

    public List<Integer> checkChoiceAnswerMultiple(String answerString, Question q) throws Exception;

    public boolean checkBinaryAnswer(String answerString, Question q) throws Exception;

    public String checkTextAnswer(String answerString, Question q) throws Exception;
}
