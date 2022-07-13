/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package questionnaire;

/**
 *
 * @author javat
 */
public interface Choice {

    public int getSerial();

    public String getId();

    public String getContent();

    public int getDefaultOrder();

    public Question getQuestion();

    public abstract boolean isImageContent();

}
