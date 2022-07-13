/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package questionnaire;

import java.time.LocalDateTime;
import java.util.List;

public interface Questionnaire {

    public int getSerial();

    public String getId();

    public String getTitle();

    public List<Question>  getQuestions();

    public List<Double>  getQuestionScores();

    public boolean isRandomOrder();

    public int getDurationInSecs();

    public double getPassScore();

    public LocalDateTime getCreateTime();

    public LocalDateTime getScheduleTime();

}
