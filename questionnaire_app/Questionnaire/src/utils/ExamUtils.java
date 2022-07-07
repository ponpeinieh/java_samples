package utils;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;
import question.Answer;
import question.Choice;
import ypnie108.exam.Exam;
import question.Question;
import question.QuestionType;
import question.Questionnaire;
import question.User;
import ypnie108.exam.ExamAnswerRecord;
import ypnie108.exam.ExamQuestion;
import ypnie108.exam.ExamResult;
import ypnie108.exam.ExamTaker;
import ypnie108.exam.GeneralAnswer;
import ypnie108.exam.TextChoice;

/**
 *
 * @author javat
 */
public class ExamUtils {

    public static User createUser() {
        return new ExamTaker("ExamTaker", "abc@def.com", "Abc", "Def");
    }

    public static ExamResult createExamResult(User user, Questionnaire qn) {
        List<ExamAnswerRecord> recordList = new ArrayList<>();
        for (var q : qn.getQuestions()) {
            GeneralAnswer.Builder answerBuilder = new GeneralAnswer.Builder();
            Answer answer = answerBuilder.id("GeneralAnswer")
                    .questionType(q.getType())
                    .correctAnswer(false)
                    .userAnswered(false)
                    .build();
            ExamAnswerRecord.Builder recordBuilder = new ExamAnswerRecord.Builder();
            ExamAnswerRecord record = recordBuilder.question(q).answer(answer).build();
            recordList.add(record);
        }
        ExamResult.Builder resultBuilder = new ExamResult.Builder();
        ExamResult result = resultBuilder.id("ExamResult").questionnaire(qn)
                .user(user)
                .questionnaireTime(LocalDateTime.now())
                .passed(false)
                .answerRecords(recordList.toArray(ExamAnswerRecord[]::new))
                .build();
        return result;
    }

    public static Question createChoiceQuestion(String questContent, List<String> choiceContents, List<Integer> correctAnswers, List<String> tags) {

        ExamQuestion.Builder examQuestBuilder = new ExamQuestion.Builder();
        examQuestBuilder.id("ExamQuestion")
                .content(questContent)
                .type(correctAnswers.size() > 1 ? QuestionType.MULTIPLE : QuestionType.SINGLE)
                .create_time(LocalDateTime.now())
                .tags(tags.toArray(String[]::new));
        ExamQuestion examQuest = examQuestBuilder.build();
        List<Choice> choiceList = new ArrayList<>();
        List<Choice> correctAnswerList = new ArrayList<>();
        int choiceIndex = 0;
        for (String choice_content : choiceContents) {
            TextChoice.Builder cb = new TextChoice.Builder();
            cb.id("TextChoice")
                    .content(choice_content)
                    .defaultOrder(choiceIndex);
            TextChoice choice = cb.build();
            choiceList.add(choice);
            if (correctAnswers.contains(choiceIndex)) {
                correctAnswerList.add(choice);
            }
            choiceIndex++;
        }
        //store in an array
        examQuest.setChoices(choiceList.toArray(Choice[]::new));
        //correct answer
        GeneralAnswer.Builder correctAnswerBuilder = new GeneralAnswer.Builder();
        correctAnswerBuilder.id("GeneralAnswer")
                .choiceAnswer(correctAnswerList.toArray(Choice[]::new));
        Answer correctAnswer = correctAnswerBuilder.build();
        examQuest.setCorrectAnswer(correctAnswer);
        return examQuest;
    }

    public static Questionnaire createQuestionnaire() {
        Question q1 = createChoiceQuestion("Which of the following are not valid variable names? (Choose two.)",
                List.of("_", "_blue", "2blue", "blue$", "Blue"), List.of(2, 3), List.of("Java", "JavaBasic"));
        Question q2 = createChoiceQuestion("Which is equivalent to var q = 4.0f;?",
                List.of("float q = 4.0f;", "Float q = 4.0f;", "double q = 4.0f;", "Double q = 4.0f;", "Object q = 4.0f;"),
                List.of(0), List.of("Java", "JavaBasic"));
        Question q3 = createChoiceQuestion("Which can fill in the blank? (Choose two.)\npublic void math() {\n_____ pi = 3.14;\n} \n",
                List.of("byte", "double", "float", "short", "var"),
                List.of(1, 4), List.of("Java", "JavaBasic"));
        List<Question> questList = List.of(q1, q2, q3);
        List<Double> scoreList = List.of(33., 33., 34.);
        // transform List<Double> into double[]
        double[] doubleArray = new double[scoreList.size()];
        Arrays.setAll(doubleArray, i -> scoreList.get(i));
        //
        Exam.Builder examBuilder = new Exam.Builder();
        examBuilder.id("Exam")
                .title("Java Certification Mock Test - 1")
                .questions(questList.toArray(Question[]::new))
                .questionScores(doubleArray)
                .passScore(70)
                .randomOrder(true)
                .durationInSecs(600)
                .createTime(LocalDateTime.now())
                .scheduleTime(LocalDateTime.now());
        Questionnaire qn = examBuilder.build();
        return qn;
    }

    public static void parseAnswer(String answerString, Question q, Answer answer) throws Exception {
        List<Choice> questionChoices = List.of(q.getChoices());
        answerString = answerString.strip().toUpperCase();
        if (answerString.length() == 0) {
            throw new Exception("Input Error: input is empty.");
        }
        switch (q.getType()) {
            case SINGLE:
                int index = checkChoiceAnswerSingle(answerString, q);
                answer.setChoiceAnswer(new Choice[]{q.getChoices()[index]});
                answer.setUserAnswered(true);
                break;
            case MULTIPLE:
                List<Integer> indices = checkChoiceAnswerMultiple(answerString, q);
                List<Choice> answerChoices = indices.stream().mapToInt(Integer::intValue).mapToObj(i -> questionChoices.get(i)).collect(Collectors.toList());
                answer.setChoiceAnswer(answerChoices.toArray(Choice[]::new));
                answer.setUserAnswered(true);
                break;
        }
    }

    public static int checkChoiceAnswerSingle(String answerString, Question q) throws Exception {
        if (answerString.length() != 1) {
            throw new Exception("Input Error: length is not exactly equal to 1.");
        }
        int length = q.getChoices().length;
        List<String> choiceLetters = IntStream.range(0, length).mapToObj(i -> String.valueOf((char) (i + 'A'))).collect(Collectors.toList());
        int index = choiceLetters.indexOf(answerString);
        if (index < 0) {
            throw new Exception("Input Error: not a valid answer.");
        } else {
            return index;
        }
    }

    public static List<Integer> checkChoiceAnswerMultiple(String answerString, Question q) throws Exception {
        String[] answers = answerString.split("\\W+");
        if (Stream.of(answers).filter(a -> a.length() != 1).findAny().isPresent()) {
            throw new Exception("Input Error: Some answer is not exactly one character long.");
        }
        int length = q.getChoices().length;
        List<String> choiceLetters = IntStream.range(0, length).mapToObj(i -> String.valueOf((char) (i + 'A'))).collect(Collectors.toList());
        if (Stream.of(answers).filter(a -> !choiceLetters.contains(a)).findAny().isPresent()) {
            throw new Exception("Input Error: Some answer is not a valid answer");
        }
        List<Integer> answerIndices = Stream.of(answers).map(a -> choiceLetters.indexOf(a)).collect(Collectors.toList());
        answerIndices.sort(Integer::compare);
        return answerIndices;
    }
}
