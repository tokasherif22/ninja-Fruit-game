/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Model;

import javafx.animation.TranslateTransition;
import javafx.scene.image.ImageView;
import javafx.util.Duration;

/**
 *
 * @author user
 */
public class StrawberreyFruit implements Create {

    ImageView fruitImage;
    TranslateTransition transition;
    StrawberreyFruit strawberryFruit;

    @Override
    public void createImage() {
        fruitImage = new ImageView("strawberry.png");

    }

    public StrawberreyFruit reference() {
        return strawberryFruit;
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
