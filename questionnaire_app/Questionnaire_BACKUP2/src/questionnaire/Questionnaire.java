/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package questionnaire;

import java.time.LocalDateTime;

public interface Questionnaire {

    public int getSerial();

    public String getId();

    public String getTitle();

    public Question[] getQuestions();

    public double[] getQuestionScores();

    public boolean isRandomOrder();

    public int getDurationInSecs();

    public double getPassScore();

    public LocalDateTime getCreateTime();

    public LocalDateTime getScheduleTime();

}
