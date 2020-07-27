package Model;

import javafx.animation.TranslateTransition;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.util.Duration;

public class Fruits implements Objects {

    ImageView fruitImage;
    TranslateTransition transition;
    Fruits fruit;

    public Fruits(String image) {
        fruitImage = new ImageView(image);
    }

    public Fruits reference() {
        return fruit;
    }

    @Override
    public ImageView image() {
        return fruitImage;
    }

    public int SpecialFruitScore() {
        return 5;
    }

    public int NormalFruitScore() {
        return 1;
    }

    @Override
    public void isSliced() {
        fruitImage.setVisible(false);
    }

    public boolean isVisible() {
        return fruitImage.isVisible();
    }

    @Override
    public void setXY(int x, int y) {
        fruitImage.setX(x);
        fruitImage.setY(y);
     

    }

    @Override
    public TranslateTransition tran() {
        transition = new TranslateTransition();
        transition.setNode(fruitImage);
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
        fruitImage.setVisible(false);
    }

    @Override
    public void setVisibleTrue() {
        fruitImage.setVisible(true);
    }

    @Override
    public void createObject() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

}
