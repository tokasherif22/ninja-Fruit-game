package Model;

import javafx.animation.TranslateTransition;
import javafx.scene.image.ImageView;
import javafx.util.Duration;

public class Bombs implements Objects {

    ImageView bombImage;
    TranslateTransition transition;

    public Bombs(String image) {
        bombImage = new ImageView(image);
    }

    @Override
    public ImageView image() {
        return bombImage;
    }

    @Override
    public void isSliced() {
        bombImage.setVisible(false);
    }

    @Override
    public void setXY(int x, int y) {
        bombImage.setX(x);
        bombImage.setY(y);

    }

    @Override
    public TranslateTransition tran() {
        transition = new TranslateTransition();
        transition.setNode(bombImage);
        return transition;
    }

    @Override
    public void setXYT(int x, int y, int duration) {
        transition.setByX(x);
        transition.setByY(y);
        transition.setDuration(Duration.seconds(duration));

    }

    @Override
    public void setVisibleFalse() {
        bombImage.setVisible(false);
    }

    @Override
    public void setVisibleTrue() {
        bombImage.setVisible(true);
    }

    @Override
    public void createObject() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

}
