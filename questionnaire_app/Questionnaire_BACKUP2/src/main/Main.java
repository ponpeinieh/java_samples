package main;

import questionnaire.Answer;
import questionnaire.AnswerRecord;
import questionnaire.Question;
import questionnaire.Questionnaire;
import questionnaire.QuestionnaireResult;
import questionnaire.User;
import questionnaire.DisplayProvider;
import utils.ExamDisplayProvider;
import utils.ExamProvider;
import questionnaire.QuestionnaireProvider;

/**
 *
 * @author javat
 */
public class Main {

    public static void main(String[] args) {
        QuestionnaireProvider theProvider = new ExamProvider();
        DisplayProvider theDisplayProvider = new ExamDisplayProvider();
        Questionnaire qn = theProvider.createQuestionnaire();
        User user = theProvider.createUser();
        QuestionnaireResult examResult = theProvider.createQuestionnaireResult(user, qn);
        // display this questionnaire
        java.util.Scanner scanner = new java.util.Scanner(System.in);
        theDisplayProvider.printTitle();
        theDisplayProvider.printDashboard(qn);
        int numQuest = qn.getQuestions().length;
        String command;
        while (!(command = scanner.nextLine()).equalsIgnoreCase("Q")) {
            int num = 0;
            boolean soundNumber = false;
            try {
                num = Integer.parseInt(command);
                if (num > 0 && num <= numQuest) {
                    soundNumber = true;
                }
            } catch (NumberFormatException nfe) {
            }
            //
            if (command.equalsIgnoreCase("L")) {
                theDisplayProvider.printQuestList(qn, examResult);
                theDisplayProvider.printDashboard(qn);
            } else if (command.equalsIgnoreCase("U")) {
                theDisplayProvider.printUnansweredQuestList(qn, examResult);
                theDisplayProvider.printDashboard(qn);
            } else if (command.equalsIgnoreCase("S")) {

            } else if (soundNumber) {
                Question q = qn.getQuestions()[num - 1];
                AnswerRecord record = examResult.getAnswerRecords()[num - 1];
                Answer answer = record.getAnswer();
                theDisplayProvider.printQuest(q, num);
                theDisplayProvider.printCurrentAnswer(q, answer);
                theDisplayProvider.printAnswerCommandMenu(q);
                String answerString;
                while (!(answerString = scanner.nextLine()).equalsIgnoreCase("Q")) {
                    try {
                        theProvider.parseAnswer(answerString, q, answer);
                    } catch (Exception ex) {
                        System.out.println("Invalid answer - " + ex.getMessage());
                    }
                    theDisplayProvider.printCurrentAnswer(q, answer);
                    theDisplayProvider.printAnswerCommandMenu(q);
                }
                theDisplayProvider.printDashboard(qn);
            } else {
                System.out.println("Unknown command. Please try again!");
                theDisplayProvider.printDashboard(qn);
            }
        }
        System.out.println("Thank you and see you soon!");
    }

}
