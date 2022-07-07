package utils;

import java.util.List;
import java.util.Optional;
import question.Answer;
import question.AnswerRecord;
import question.Choice;
import question.Question;
import question.QuestionType;
import question.Questionnaire;
import question.QuestionnaireResult;

/**
 *
 * @author javat
 */
public class DisplayUtils {

    public static void printTitle() {
        System.out.println("**************************************************");
        System.out.println("*         Welcome to Questionnaire System!       *");
        System.out.println("**************************************************");
    }

    public static void printDashboard(Questionnaire qn) {
        int numQuest = qn.getQuestions().length;
        System.out.println("* Command List: ");
        System.out.println("* Show complete question list (L)");
        System.out.println("* Show unanswered question list U)");
        System.out.printf("* Show the Nth question (1~%d)\n", numQuest);
        System.out.println("* Submit the questionnaire (S)");
        System.out.println("* Quit and exit (Q)");
        System.out.print(">>>");
    }

    public static void printQuestList(Questionnaire qn, QuestionnaireResult result) {

        AnswerRecord[] records = result.getAnswerRecords();
        int order = 1;
        for (var q : qn.getQuestions()) {
            printQuestSimple(q, records[order - 1].getAnswer(), order);
            order++;
        }
    }

    public static void printUnansweredQuestList(Questionnaire qn, QuestionnaireResult result) {
        AnswerRecord[] records = result.getAnswerRecords();
        int order = 1;
        for (var q : qn.getQuestions()) {
            Answer answer = records[order - 1].getAnswer();
            if (! answer.isUserAnswered()) {
                printQuestSimple(q, answer, order);
            }
            order++;
        }
    }

    public static void printQuestSimple(Question q, Answer answer, int order) {
        StringBuilder sb = new StringBuilder("Q." + order + " :");
        String content = q.getContent();
        int indexNewLine = content.indexOf("\n");
        if (indexNewLine < 0) {
            sb.append(content.length() > 80 ? content.substring(0, 80) + "..." : content);
        } else {
            sb.append(content.substring(0, indexNewLine)).append("...");
        }
        sb.append(answer.isUserAnswered() ? " (Done)" : "");
        System.out.println(sb.toString());
    }

    public static void printQuest(Question q, int order) {
        StringBuilder sb = new StringBuilder("Q." + order + " :");
        String content = q.getContent();
        sb.append(content);
        System.out.println(sb.toString());
    }

    public static void printChoices(Question q) {
        if (q.getType() == QuestionType.MULTIPLE || q.getType() == QuestionType.SINGLE) {
            Choice[] choices = q.getChoices();
            int order = 'A';
            for (var choice : choices) {
                System.out.print("(" + (char) order + ") : ");
                System.out.println(choice.getContent());
                order++;
            }
        }
    }

    public static void printCurrentAnswer(Question q, Answer answer) {
        System.out.print("* Your current answer : ");
        if (answer.isUserAnswered()) {
            List<Choice> choiceAnswers = List.of(answer.getChoiceAnswer());
            List<Choice> questionChoices = List.of(q.getChoices());
            switch (q.getType()) {
                case SINGLE:
                    Optional<Integer> index = choiceAnswers.stream().map(e -> questionChoices.indexOf(e)).findFirst();
                    if (index.isPresent()) {
                        System.out.println((char) (index.get() + 'A'));
                    }
                    break;
                case MULTIPLE:
                    choiceAnswers.stream().map(e -> questionChoices.indexOf(e)).forEach(i -> System.out.print((char) (i + 'A') + " "));
                    System.out.println();
                    break;
            }
        } else {
            System.out.println("None");
        }

    }

    public static void printAnswerCommandMenu(Question q) {
        switch (q.getType()) {
            case SINGLE: {
                int numChoices = q.getChoices().length;
                System.out.printf("* Your answer (%c to %c) please (single answer). ", 'A', (char) ('A' + numChoices - 1));
                break;
            }
            case MULTIPLE: {
                int numChoices = q.getChoices().length;
                System.out.printf("* Your answer (%c to %c) please (multiple answers, separated by space). ", 'A', (char) ('A' + numChoices - 1));
                break;
            }
        }
        System.out.println("Or Press 'X' to exit and back to command dashboard.");
        System.out.print(">>>");
    }
}
