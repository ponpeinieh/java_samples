/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package question;

import java.time.LocalDateTime;

public interface Question {

    public int getSerial();

    public String getId();

    public String getContent();

    public QuestionType getType();

    public String[] getTags();

    public LocalDateTime getCreate_time();

    public Choice[] getChoices();

    public RatingType getRatingType();

    public void setChoices(Choice[] choices);

    public Answer getCorrectAnswer();

    public boolean hasCorrectAnswer();

}
