/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Model;

import javafx.animation.TranslateTransition;
import javafx.scene.image.ImageView;

/**
 *
 * @author user
 */
public interface Create {

    public void createImage();

    public ImageView image();

    public void isSliced();

    public void setXY(int x, int y);

    public TranslateTransition tran();

    public void setXYT(int x, int y, int duration);

    public void setVisibleFalse();

    public void setVisibleTrue();

}
