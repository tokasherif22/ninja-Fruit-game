package Model;

import Model.Strategy;

public class StrategyTwo implements Strategy {

    @Override
    public int speed() {
        return 4;
    }

    @Override
    public int visiblity() {
        return 4;
    }

}
