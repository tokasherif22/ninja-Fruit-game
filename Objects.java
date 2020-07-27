package Model;

import javafx.animation.TranslateTransition;
import javafx.scene.image.ImageView;

public interface Objects {

    public ImageView image();

    public void isSliced();

    public void setXY(int x, int y);

    public TranslateTransition tran();

    public void setXYT(int x, int y, int duration);

    public void setVisibleFalse();

    public void setVisibleTrue();

    public void createObject();

}
