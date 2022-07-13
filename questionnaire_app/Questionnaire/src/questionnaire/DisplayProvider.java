package questionnaire;

/**
 *
 * @author javat
 */
public interface DisplayProvider {

    public void printTitle();

    public void printDashboard(Questionnaire qn);

    public void printQuestList(Questionnaire qn, QuestionnaireResult result);

    public void printUnansweredQuestList(Questionnaire qn, QuestionnaireResult result);

    public void printQuestSimple(Question q, Answer answer, int order);

    public void printQuest(Question q, int order);

    public void printCurrentAnswer( Answer answer);

    public void printAnswerCommandMenu(Question q);
}
