package main;

import question.Answer;
import question.AnswerRecord;
import question.Question;
import question.Questionnaire;
import question.QuestionnaireResult;
import question.User;
import utils.DisplayUtils;
import static utils.DisplayUtils.printAnswerCommandMenu;
import static utils.DisplayUtils.printChoices;
import static utils.DisplayUtils.printCurrentAnswer;
import static utils.DisplayUtils.printQuest;
import static utils.DisplayUtils.printQuestList;
import static utils.DisplayUtils.printUnansweredQuestList;
import utils.ExamUtils;
import static utils.ExamUtils.parseAnswer;

/**
 *
 * @author javat
 */
public class Main {

    public static void main(String[] args) {
        Questionnaire qn = ExamUtils.createQuestionnaire();
        User user = ExamUtils.createUser();
        QuestionnaireResult examResult = ExamUtils.createExamResult(user, qn);
        // display this questionnaire
        java.util.Scanner scanner = new java.util.Scanner(System.in);
        DisplayUtils.printTitle();
        DisplayUtils.printDashboard(qn);
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
                printQuestList(qn, examResult);
                DisplayUtils.printDashboard(qn);
            } else if (command.equalsIgnoreCase("U")) {
                printUnansweredQuestList(qn, examResult);
                DisplayUtils.printDashboard(qn);
            } else if (command.equalsIgnoreCase("S")) {

            } else if (soundNumber) {
                Question q = qn.getQuestions()[num - 1];
                AnswerRecord record = examResult.getAnswerRecords()[num - 1];
                Answer answer = record.getAnswer();
                printQuest(q, num);
                printChoices(q);
                printCurrentAnswer(q, answer);
                printAnswerCommandMenu(q);
                String answerString;
                while (!(answerString = scanner.nextLine()).equalsIgnoreCase("X")) {
                    try {
                        parseAnswer(answerString, q, answer);
                    } catch (Exception ex) {
                        System.out.println("Invalid answer - " + ex.getMessage());
                    }
                    printCurrentAnswer(q, answer);
                    printAnswerCommandMenu(q);
                }
                DisplayUtils.printDashboard(qn);
            } else {
                System.out.println("Unknown command. Please try again!");
                DisplayUtils.printDashboard(qn);
            }
        }
        System.out.println("Thank you and see you soon!");
    }

}
