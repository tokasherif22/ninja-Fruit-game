package Model;

import Model.Strategy;

public class StrategyOne implements Strategy {


    @Override
    public int speed() {
     return 6;
    }

    @Override
    public int visiblity() {
        return 6;
    }

}
