/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package question;

/**
 *
 * @author javat
 */
public class ImageChoice extends Choice {

    private ImageChoice(Builder b) {
        super(b);
    }

    @Override
    public boolean isImageContent() {
        return true;
    }

    public static class Builder extends Choice.Builder {

        public ImageChoice build() {
            return new ImageChoice(this);
        }

    }
}
