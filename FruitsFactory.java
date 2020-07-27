package Model;

public class FruitsFactory {

    public Create getFruit(String fruit) {
        if (fruit == null) {
            return null;
        }
        if (fruit.equalsIgnoreCase("MANGO")) {
            return new MangoFruit();
        } else if (fruit.equalsIgnoreCase("BANANA")) {
            return new BananaClass();
        } else if (fruit.equalsIgnoreCase("Orange")) {
            return new OrangeFruit();
        } else if (fruit.equalsIgnoreCase("Strawberry")) {
            return new StrawberreyFruit();
        } else if (fruit.equalsIgnoreCase("Berry")) {
            return new BerryFruit();
        }
        return null;
    }
}
