package utils;

import questionnaire.DisplayProvider;
import java.util.List;
import java.util.OptionalInt;
import java.util.stream.Collectors;
import questionnaire.Answer;
import questionnaire.AnswerRecord;
import questionnaire.Choice;
import questionnaire.Question;
import questionnaire.Questionnaire;
import questionnaire.QuestionnaireResult;

/**
 *
 * @author javat
 */
public class ExamDisplayProvider implements DisplayProvider {

    @Override
    public void printTitle() {
        System.out.println("**************************************************");
        System.out.println("*         Welcome to Questionnaire System!       *");
        System.out.println("**************************************************");
    }

    @Override
    public void printDashboard(Questionnaire qn) {
        int numQuest = qn.getQuestions().length;
        System.out.println("* Command List: ");
        System.out.println("* Show complete question list (L)");
        System.out.println("* Show unanswered question list U)");
        System.out.printf("* Show the Nth question (1~%d)\n", numQuest);
        System.out.println("* Submit the questionnaire (S)");
        System.out.println("* Quit and exit (Q)");
        System.out.print(">>>");
    }

    @Override
    public void printQuestList(Questionnaire qn, QuestionnaireResult result) {
        AnswerRecord[] records = result.getAnswerRecords();
        int order = 1;
        for (var q : qn.getQuestions()) {
            printQuestSimple(q, records[order - 1].getAnswer(), order);
            order++;
        }
    }

    @Override
    public void printUnansweredQuestList(Questionnaire qn, QuestionnaireResult result) {
        AnswerRecord[] records = result.getAnswerRecords();
        int order = 1;
        for (var q : qn.getQuestions()) {
            Answer answer = records[order - 1].getAnswer();
            if (!answer.isUserAnswered()) {
                printQuestSimple(q, answer, order);
            }
            order++;
        }
    }

    @Override
    public void printQuestSimple(Question q, Answer answer, int order) {
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

    @Override
    public void printQuest(Question q, int order) {
        StringBuilder sb = new StringBuilder("Q." + order + " :");
        String content = q.getContent();
        sb.append(content);
        System.out.println(sb.toString());
        switch (q.getType()) {
            case SINGLE:
            case MULTIPLE:
                Choice[] choices = q.getChoices();
                int choiceOrder = 'A';
                for (var choice : choices) {
                    System.out.print("(" + (char) choiceOrder + ") : ");
                    System.out.println(choice.getContent());
                    choiceOrder++;
                }
                break;
            case TEXT:
            case TEXTFIELD:
                System.out.println(" ______ ");
                break;
            case BINARY:
                System.out.println("(0 for False, 1 for True)");
                break;
        }
    }

    @Override
    public void printCurrentAnswer(Question q, Answer answer) {
        System.out.print("* Your current answer : ");
        if (answer.isUserAnswered()) {
            switch (q.getType()) {
                case SINGLE: {
                    List<Choice> choiceAnswers = List.of(answer.getChoiceAnswer());
                    List<Choice> questionChoices = List.of(q.getChoices());
                    // below code also works, but since we are dealing with primitive integers here, so OptionalInt is better       
//                    Optional<Integer> index = choiceAnswers.stream().map(e -> questionChoices.indexOf(e)).findFirst();
//                    if (index.isPresent()) {
//                        System.out.println((char) (index.get() + 'A'));
//                    }
                    // IntStream.findFirst() return a OptionalInt(). And use getAsInt() to get the int value
                    OptionalInt index = choiceAnswers.stream().mapToInt(e -> questionChoices.indexOf(e)).findFirst();
                    if (index.isPresent()) {
                        System.out.println((char) (index.getAsInt() + 'A'));
                    }
                    break;
                }
                case MULTIPLE: {
                    List<Choice> choiceAnswers = List.of(answer.getChoiceAnswer());
                    List<Choice> questionChoices = List.of(q.getChoices());
                    //choiceAnswers.stream().mapToInt(e -> questionChoices.indexOf(e)).forEach(i -> System.out.print((char) (i + 'A') + " "));
                    //System.out.println();
                    System.out.println(choiceAnswers.stream().map(e -> String.valueOf((char) (questionChoices.indexOf(e) + 'A'))).collect(Collectors.joining(", ")));
                    break;
                }
                case BINARY:
                    System.out.println(answer.getBinaryAnswer() ? "1 (True)" : "0 (False)");
                    break;
                case TEXT:
                case TEXTFIELD:
                    System.out.println(answer.getTextAnswer());
                    break;
            }
        } else {
            System.out.println("None");
        }

    }

    @Override
    public void printAnswerCommandMenu(Question q) {
        switch (q.getType()) {
            case SINGLE: {
                int numChoices = q.getChoices().length;
                System.out.printf("* Your answer (%c to %c) please (single answer) : ", 'A', (char) ('A' + numChoices - 1));
                break;
            }
            case MULTIPLE: {
                int numChoices = q.getChoices().length;
                System.out.printf("* Your answer (%c to %c) please (multiple answers, separated by space) : ", 'A', (char) ('A' + numChoices - 1));
                break;
            }
            case BINARY:
                System.out.printf("* Your answer please (1 (True), 0 (False) : ");
                break;
            case TEXT:
            case TEXTFIELD:
                System.out.printf("* Your answer please (text) : ");
                break;
        }
        System.out.println("Or Press 'Q' to exit and back to command dashboard.");
        System.out.print(">>>");
    }
}
