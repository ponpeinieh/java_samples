package utils;

import questionnaire.QuestionnaireProvider;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import questionnaire.Answer;
import questionnaire.AnswerRecord;
import questionnaire.Choice;
import questionnaire.Question;
import questionnaire.QuestionType;
import questionnaire.Questionnaire;
import questionnaire.QuestionnaireResult;
import questionnaire.User;
import ypnie108.exam.Exam;
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
public class ExamProvider implements QuestionnaireProvider {

    @Override
    public User createUser() {
        return new ExamTaker("ExamTaker", "abc@def.com", "Abc", "Def");
    }

    @Override
    public QuestionnaireResult createQuestionnaireResult(User user, Questionnaire qn) {
        List<AnswerRecord> recordList = new ArrayList<>();
        for (var q : qn.getQuestions()) {
            GeneralAnswer.Builder answerBuilder = new GeneralAnswer.Builder();
            Answer answer = answerBuilder.id("GeneralAnswer")
                    .questionType(q.getType())
                    .question(q)
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
                .answerRecords(recordList)
                .build();
        return result;
    }

    @Override
    public Question createTextQuestion(String questContent, String correctTextAnswer, List<String> tags) {
        return _createTextQuestion(questContent, correctTextAnswer, false, tags);
    }

    @Override
    public Question createMultiTextQuestion(String questContent, String correctMultiTextAnswer, List<String> tags) {
        return _createTextQuestion(questContent, correctMultiTextAnswer, true, tags);
    }

    private Question _createTextQuestion(String questContent, String correctTextAnswer, boolean isMultiText, List<String> tags) {
        ExamQuestion.Builder examQuestBuilder = new ExamQuestion.Builder();
        examQuestBuilder.id("ExamQuestion")
                .content(questContent)
                .type(isMultiText ? QuestionType.TEXTFIELD : QuestionType.TEXT)
                .create_time(LocalDateTime.now())
                .tags(tags);
        ExamQuestion examQuest = examQuestBuilder.build();
        //correct answer
        GeneralAnswer.Builder correctAnswerBuilder = new GeneralAnswer.Builder();
        correctAnswerBuilder.id("GeneralAnswer")
                .questionType(examQuest.getType())
                .question(examQuest)
                .textAnswer(correctTextAnswer)
                .correctAnswer(true);
        Answer correctAnswer = correctAnswerBuilder.build();
        examQuest.setCorrectAnswer(correctAnswer);
        return examQuest;
    }

    @Override
    public Question createBinaryQuestion(String questContent, boolean correctBinaryAnswer, List<String> tags) {
        ExamQuestion.Builder examQuestBuilder = new ExamQuestion.Builder();
        examQuestBuilder.id("ExamQuestion")
                .content(questContent)
                .type(QuestionType.BINARY)
                .create_time(LocalDateTime.now())
                .tags(tags);
        ExamQuestion examQuest = examQuestBuilder.build();

        //correct answer
        GeneralAnswer.Builder correctAnswerBuilder = new GeneralAnswer.Builder();
        correctAnswerBuilder.id("GeneralAnswer")
                .questionType(examQuest.getType())
                .question(examQuest)
                .binaryAnswer(correctBinaryAnswer)
                .correctAnswer(true);
        Answer correctAnswer = correctAnswerBuilder.build();
        examQuest.setCorrectAnswer(correctAnswer);
        return examQuest;
    }

    @Override
    public Question createChoiceQuestion(String questContent, List<String> choiceContents,
            List<Integer> correctAnswers, List<String> tags
    ) {

        ExamQuestion.Builder examQuestBuilder = new ExamQuestion.Builder();
        examQuestBuilder.id("ExamQuestion")
                .content(questContent)
                .type(correctAnswers.size() > 1 ? QuestionType.MULTIPLE : QuestionType.SINGLE)
                .create_time(LocalDateTime.now())
                .tags(tags);
        ExamQuestion examQuest = examQuestBuilder.build();
        List<Choice> choiceList = new ArrayList<>();
        List<Choice> correctAnswerList = new ArrayList<>();
        int choiceIndex = 0;
        for (String choice_content : choiceContents) {
            TextChoice.Builder cb = new TextChoice.Builder();
            cb.id("TextChoice")
                    .content(choice_content)
                    .question(examQuest)
                    .defaultOrder(choiceIndex);
            TextChoice choice = cb.build();
            choiceList.add(choice);
            if (correctAnswers.contains(choiceIndex)) {
                correctAnswerList.add(choice);
            }
            choiceIndex++;
        }
        //store in an array
        examQuest.setChoices(choiceList);
        //correct answer
        GeneralAnswer.Builder correctAnswerBuilder = new GeneralAnswer.Builder();
        correctAnswerBuilder.id("GeneralAnswer")
                .questionType(examQuest.getType())
                .question(examQuest)
                .choiceAnswer(correctAnswerList)
                .correctAnswer(true);
        Answer correctAnswer = correctAnswerBuilder.build();
        examQuest.setCorrectAnswer(correctAnswer);
        return examQuest;
    }

    @Override
    public Questionnaire createQuestionnaire() {
        Question q1 = createChoiceQuestion("Which of the following are not valid variable names? (Choose two.)",
                List.of("_", "_blue", "2blue", "blue$", "Blue"), List.of(2, 3), List.of("Java", "JavaBasic"));
        Question q2 = createChoiceQuestion("Which is equivalent to var q = 4.0f;?",
                List.of("float q = 4.0f;", "Float q = 4.0f;", "double q = 4.0f;", "Double q = 4.0f;", "Object q = 4.0f;"),
                List.of(0), List.of("Java", "JavaBasic"));
        Question q3 = createChoiceQuestion("Which can fill in the blank? (Choose two.)\npublic void math() {\n_____ pi = 3.14;\n} \n",
                List.of("byte", "double", "float", "short", "var"),
                List.of(1, 4), List.of("Java", "JavaBasic"));
        Question q4 = createTextQuestion("What is the output of the following?\nvar teams = new StringBuilder(\"333\");\n"
                + "teams.append(\" 806\");\nteams.append(\" 1601\");\nSystem.out.print(teams);\n",
                "333 806 1601", List.of("Java", "JavaBasic"));
        Question q5 = createBinaryQuestion("The 'throw' keyword is used in method declarations, while\n"
                + "the 'throws' keyword is used to send an exception to calling method.\n", false, List.of("Java", "JavaBasic"));
        List<Question> questList = List.of(q1, q2, q3, q4, q5);
        List<Double> scoreList = List.of(20., 20., 20., 20., 20.);
        //
        Exam.Builder examBuilder = new Exam.Builder();
        examBuilder.id("Exam")
                .title("Java Certification Mock Test - 1")
                .questions(questList)
                .questionScores(scoreList)
                .passScore(70)
                .randomOrder(true)
                .durationInSecs(600)
                .createTime(LocalDateTime.now())
                .scheduleTime(LocalDateTime.now());
        Questionnaire qn = examBuilder.build();
        return qn;
    }

    @Override
    public void parseAnswer(String answerString, Answer answer) throws Exception {
        Question q = answer.getQuestion();
        answerString = answerString.strip().toUpperCase();
        if (answerString.length() == 0) {
            throw new Exception("Input Error: input is empty.");
        }
        switch (q.getType()) {
            case SINGLE:
                int index = checkChoiceAnswerSingle(answerString, q);
                answer.setChoiceAnswer(List.of(q.getChoices().get(index)));
                answer.setUserAnswered(true);
                break;
            case MULTIPLE:
                List<Integer> indices = checkChoiceAnswerMultiple(answerString, q);
                List<Choice> answerChoices = indices.stream().mapToInt(Integer::intValue).mapToObj(i -> q.getChoices().get(i)).collect(Collectors.toList());
                answer.setChoiceAnswer(answerChoices);
                answer.setUserAnswered(true);
                break;
            case BINARY:
                boolean binaryAnswer = checkBinaryAnswer(answerString, q);
                answer.setBinaryAnswer(binaryAnswer);
                answer.setUserAnswered(true);
                break;
            case TEXT:
            case TEXTFIELD:
                String textAnswer = checkTextAnswer(answerString, q);
                answer.setTextAnswer(textAnswer);
                answer.setUserAnswered(true);
                break;
        }
    }

    @Override
    public boolean checkBinaryAnswer(String answerString, Question q) throws Exception {
        if (answerString.length() != 1) {
            throw new Exception("Input Error: length is not exactly equal to 1.");
        } else if (!"0".equals(answerString) && !"1".equals(answerString)) {
            throw new Exception("Input Error: not a valid answer.");
        }
        return "1".equals(answerString);
    }

    @Override
    public String checkTextAnswer(String answerString, Question q) throws Exception {
        if (answerString.length() == 0) {
            throw new Exception("Input Error: answer content is empty.");
        }
        return answerString;
    }

    @Override
    public int checkChoiceAnswerSingle(String answerString, Question q) throws Exception {
        if (answerString.length() != 1) {
            throw new Exception("Input Error: length is not exactly equal to 1.");
        }
        int length = q.getChoices().size();
        List<String> choiceLetters = IntStream.range(0, length).mapToObj(i -> String.valueOf((char) (i + 'A'))).collect(Collectors.toList());
        int index = choiceLetters.indexOf(answerString);
        if (index < 0) {
            throw new Exception("Input Error: not a valid answer.");
        } else {
            return index;
        }
    }

    @Override
    public List<Integer> checkChoiceAnswerMultiple(String answerString, Question q) throws Exception {
        String[] answers = answerString.split("\\W+");
        //if (Stream.of(answers).filter(a -> a.length() != 1).findAny().isPresent()) { //or use Arrays.stream()
        if (Arrays.stream(answers).filter(a -> a.length() != 1).findAny().isPresent()) {
            throw new Exception("Input Error: Some answer is not exactly one character long.");
        }
        int length = q.getChoices().size();
        List<String> choiceLetters = IntStream.range(0, length).mapToObj(i -> String.valueOf((char) (i + 'A'))).collect(Collectors.toList());
        //if (Stream.of(answers).filter(a -> !choiceLetters.contains(a)).findAny().isPresent()) { //or use Arrays.stream()
        if (Arrays.stream(answers).filter(a -> !choiceLetters.contains(a)).findAny().isPresent()) {
            throw new Exception("Input Error: Some answer is not a valid answer");
        }
        //List<Integer> answerIndices = Stream.of(answers).mapToInt(a -> choiceLetters.indexOf(a)).boxed().collect(Collectors.toList()); 
        //Above use mapToInt() to get a IntStream and then boxed() into Stream<Integer>, since IntStream has no collect(Collector) method
        //Or as below use map() directly, which is simpler
        List<Integer> answerIndices = Arrays.stream(answers).map(a -> choiceLetters.indexOf(a)).collect(Collectors.toList());
        answerIndices.sort(Integer::compareTo); //Integer also has a static compare() , so we can use Integer::compare here too.
        return answerIndices;
    }

}
