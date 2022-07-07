/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package question;

/**
 *
 * @author javat
 */
public class TextChoice extends Choice {

    private TextChoice(Builder b) {
        super(b);
    }

    @Override
    public boolean isImageContent() {
        return false;
    }

    public static class Builder extends Choice.Builder {

        public TextChoice build() {
            return new TextChoice(this);
        }

    }
}
