 
package utils;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import question.Answer;
import question.Choice;
import ypnie108.exam.Exam;
import question.Question;
import question.QuestionType;
import question.Questionnaire;
import ypnie108.exam.ExamQuestion;
import ypnie108.exam.GeneralAnswer;
import ypnie108.exam.TextChoice;

/**
 *
 * @author javat
 */
public class QuestionUtils {

    public static Question createQuestion(String q_content, List<String> choice_contents, List<Integer> correct_answers, List<String> tags) {

        ExamQuestion.Builder qb = new ExamQuestion.Builder();
        qb.id("ExamQuestion")
                .content(q_content)
                .type(correct_answers.size() > 1 ? QuestionType.MULTIPLE : QuestionType.SINGLE)
                .create_time(LocalDateTime.now())
                .tags(tags.toArray(String[]::new));
        ExamQuestion q1 = qb.build();
        List<Choice> choiceList = new ArrayList<>();
        List<Choice> correctAnswerList = new ArrayList<>();
        int i = 0;
        for (String choice_content : choice_contents) {
            TextChoice.Builder cb = new TextChoice.Builder();
            cb.id("TextChoice")
                    .content(choice_content)
                    .defaultOrder(i);
            TextChoice c1 = cb.build();
            choiceList.add(c1);
            if (correct_answers.contains(i)) {
                correctAnswerList.add(c1);
            }
            i++;
        }
        //store in an array
        q1.setChoices(choiceList.toArray(Choice[]::new));
        //correct answer
        GeneralAnswer.Builder cab = new GeneralAnswer.Builder();
        cab.id("CorrectAnswer")
                .choiceAnswer(correctAnswerList.toArray(Choice[]::new));
        Answer correctAnswer = cab.build();
        q1.setCorrectAnswer(correctAnswer);
        return q1;
    }

    public static Questionnaire createQuestionnaire() {
        Question q1 = createQuestion("Which of the following are not valid variable names? (Choose two.)",
                List.of("_", "_blue", "2blue", "blue$", "Blue"), List.of(2, 3), List.of("Java", "JavaBasic"));
        Question q2 = createQuestion("Which is equivalent to var q = 4.0f;?",
                List.of("float q = 4.0f;", "Float q = 4.0f;", "double q = 4.0f;", "Double q = 4.0f;", "Object q = 4.0f;"),
                List.of(0), List.of("Java", "JavaBasic"));
        Question q3 = createQuestion("Which can fill in the blank? (Choose two.)\npublic void math() {\n_____ pi = 3.14;\n} \n",
                List.of("byte", "double", "float", "short", "var"),
                List.of(1, 4), List.of("Java", "JavaBasic"));
        List<Question> qList = List.of(q1, q2, q3);
        List<Double> scoreList = List.of(33., 33., 34.);
        double[] d_arr = new double[scoreList.size()];
        Arrays.setAll(d_arr, i -> scoreList.get(i));
        Exam.Builder qb = new Exam.Builder();
        qb.id("JavaQuestionnaire1")
                .title("Java Certification Mock Test - 1")
                .questions(qList.toArray(Question[]::new))
                .questionScores(d_arr)
                .passScore(70)
                .randomOrder(true)
                .durationInSecs(10)
                .createTime(LocalDateTime.now())
                .scheduleTime(LocalDateTime.now());
        Questionnaire qn = qb.build();
        return qn;
    }

}
