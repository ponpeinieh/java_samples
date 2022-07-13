package questionnaire;

import java.time.LocalDateTime;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import questionnaire.Answer;
import questionnaire.Choice;
import questionnaire.Question;
import questionnaire.Questionnaire;
import questionnaire.QuestionnaireResult;
import questionnaire.User;
import ypnie108.exam.Exam;

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

    public void parseAnswer(String answerString, Question q, Answer answer) throws Exception;

    public int checkChoiceAnswerSingle(String answerString, Question q) throws Exception;

    public List<Integer> checkChoiceAnswerMultiple(String answerString, Question q) throws Exception;

    public boolean checkBinaryAnswer(String answerString, Question q) throws Exception;

    public String checkTextAnswer(String answerString, Question q) throws Exception;
}
