package Model;

import javafx.animation.TranslateTransition;
import javafx.scene.image.ImageView;
import javafx.util.Duration;
import view.Game;

public class BananaClass implements Create {

    ImageView fruitImage;
    TranslateTransition transition;
    BananaClass bananaClass;
    

    @Override
    public void createImage() {
      fruitImage = new ImageView("banana.png");

    }

    public BananaClass reference() {
        return bananaClass;
    }

    @Override
    public ImageView image() {
        return fruitImage;
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

}
