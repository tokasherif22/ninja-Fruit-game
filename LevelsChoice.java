package view;

import Model.Save;
import Model.StrategyOne;
import Model.StrategyThree;
import Model.StrategyTwo;
import javafx.animation.Timeline;
import javafx.geometry.Pos;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.stage.Stage;

public class LevelsChoice {

    Scene scene;
    Stage stage;
    Button levelOne = new Button("Level One");
    Button levelTwo = new Button("Level Two");
    Button levelThree = new Button("Level Three");
    Timeline timeline = new Timeline();

    Label level1 = new Label("Level One");
    Label level2 = new Label("Level Two");
    Label level3 = new Label("Level Three");

    StrategyOne strategyOne;
    StrategyTwo strategyTwo;
    StrategyThree strategyThree;

    Game game;
    Save save;

    public void setStage(Stage stage) {
        this.stage = stage;
    }

    public Scene getScene() {
        return scene;
    }

    public void setStrategyOne(StrategyOne strategyOne) {
        this.strategyOne = strategyOne;
    }

    public void setStrategyTwo(StrategyTwo strategyTwo) {
        this.strategyTwo = strategyTwo;
    }

    public void setStrategyThree(StrategyThree strategyThree) {
        this.strategyThree = strategyThree;
    }

    public void setLevelOne1(Game levelOne1) {
        this.game = levelOne1;
    }

    public void setSave(Save save) {
        this.save = save;
    }

    public void prepareScene() {

        level2.setOnMouseClicked((event) -> {

            game.prepareScene(strategyTwo);
            save.setStrategy(strategyTwo);
            stage.setScene(game.getScene());
        });

        level1.setOnMouseClicked((event) -> {
            game.prepareScene(strategyOne);
            save.setStrategy(strategyOne);
            stage.setScene(game.getScene());
        });
        level3.setOnMouseClicked((event) -> {
            game.prepareScene(strategyThree);
            save.setStrategy(strategyThree);
            stage.setScene(game.getScene());
        });
        level1.setFont(Font.font("Chiller", 60));
        level1.setTextFill(Color.TOMATO);
        level2.setFont(Font.font("Chiller", 60));
        level2.setTextFill(Color.TOMATO);
        level3.setFont(Font.font("Chiller", 60));
        level3.setTextFill(Color.TOMATO);

        Group root = new Group();
        Canvas canvas = new Canvas(1200, 600);
        GraphicsContext context = canvas.getGraphicsContext2D();
        Image image = new Image(getClass().getResource("back.png").toExternalForm());
        context.drawImage(image, 0, 0);

        StackPane stack = new StackPane();
        VBox vb = new VBox();
        vb.setAlignment(Pos.CENTER);
        vb.getChildren().addAll(level1, level2, level3);
        stack.getChildren().addAll(canvas, vb);
        scene = new Scene(stack, 1200, 600);

    }

}
