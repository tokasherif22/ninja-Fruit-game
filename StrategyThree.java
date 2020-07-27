package Model;

import Model.Strategy;

public class StrategyThree implements Strategy {

    @Override
    public int speed() {
        return 3;
    }

    @Override
    public int visiblity() {
        return 3;
    }

}
