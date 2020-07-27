package view;

import Controller.Player;
import Model.Command;
import Model.Load;
import Model.LoadOnCommand;
import Model.SaveOnCommand;
import Model.SaverLoader;
import Model.SaverLoaderController;
import Model.StrategyOne;
import Model.StrategyThree;
import Model.StrategyTwo;
import java.io.File;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.stage.Stage;

public class Menu {

    Scene scene;

    Stage stage;

    LevelsChoice levelsChoice;

    Game game;

    Load load;

    Player player;

    StrategyOne strategy1;
    StrategyTwo strategy2;
    StrategyThree strategy3;

    HighestScore highestScore;

    SaverLoaderController controller;
    SaverLoader saverLoader;

    int loadLives;
    int loadTime;
    int loadScore;
    int startegy;

    public void setStage(Stage stage) {
        this.stage = stage;
    }

    public Scene getScene() {
        return scene;
    }

    public void setLevelsChoice(LevelsChoice levelsChoice) {
        this.levelsChoice = levelsChoice;
    }

    public void setGame(Game game) {
        this.game = game;
    }

    public void setLoad(Load load) {
        this.load = load;
    }

    public void setPlayer(Player player) {
        this.player = player;
    }

    public void setStrategy1(StrategyOne strategy1) {
        this.strategy1 = strategy1;
    }

    public void setStrategy2(StrategyTwo strategy2) {
        this.strategy2 = strategy2;
    }

    public void setStrategy3(StrategyThree strategy3) {
        this.strategy3 = strategy3;
    }

    public void setHighestScore(HighestScore highestScore) {
        this.highestScore = highestScore;
    }

    public void setController(SaverLoaderController controller) {
        this.controller = controller;
    }

    public void setLoadLives(int loadLives) {
        this.loadLives = loadLives;
    }

    public void setStartegy(int startegy) {
        this.startegy = startegy;
    }

    public void setLoadTime(int loadTime) {
        this.loadTime = loadTime;
    }

    public void setLoadScore(int loadScore) {
        this.loadScore = loadScore;
    }

    public void setSaverLoader(SaverLoader saverLoader) {
        this.saverLoader = saverLoader;
    }

    Label neww = new Label("New Game");
    Label cont = new Label("Continue Game");
    Label score = new Label("Highest Score");

    Label label = new Label("Ninja Fruits");

    public void prepareScene() {
        /*String musicFile = "Fruit-Ninja-Theme-Song.mp3";
        Media musicfile = new Media(new File(musicFile).toURI().toString());
        MediaPlayer mediaPlayer = new MediaPlayer(musicfile);
        mediaPlayer.setAutoPlay(true);
*/
        label.setTextFill(Color.TOMATO);
        label.setFont(Font.font("Californian FB", 100));

        VBox vb = new VBox(25);
        Canvas canvas = new Canvas(1200, 600);
        GraphicsContext context = canvas.getGraphicsContext2D();
        Image image = new Image(getClass().getResource("back.png").toExternalForm());
        context.drawImage(image, 0, 0);

        neww.setFont(Font.font("Chiller", 60));
        neww.setTextFill(Color.TOMATO);
        cont.setFont(Font.font("Chiller", 60));
        cont.setTextFill(Color.TOMATO);
        score.setFont(Font.font("Chiller", 60));
        score.setTextFill(Color.TOMATO);
        neww.setOnMouseClicked((event) -> {
            //mediaPlayer.setAutoPlay(true);
            levelsChoice.prepareScene();
            stage.setScene(levelsChoice.getScene());
        });
        cont.setOnMouseClicked((event) -> {
            //mediaPlayer.setAutoPlay(true);
            Command on = new LoadOnCommand(saverLoader);
            controller.setCommand(on);
            controller.pressButton();

            player.setLivesLeft(loadLives);
            player.setScore(loadScore);
            player.setTimeXML(loadTime);

            if (startegy == 6) {
                game.prepareScene(strategy1);
            } else if (startegy == 3) {
                game.prepareScene(strategy2);
            } else {
                game.prepareScene(strategy3);
            }
            player.setLivesLeft(loadLives);
            stage.setScene(game.getScene());

        });

        score.setOnMouseClicked((event) -> {
            //mediaPlayer.setAutoPlay(true);
            highestScore.prepareScene();
            stage.setScene(highestScore.getScene());
        });
        vb.setPadding(new Insets(30, 30, 30, 30));
        StackPane stack = new StackPane();
        stack.getChildren().addAll(canvas, vb);
        vb.setAlignment(Pos.CENTER);
        vb.getChildren().addAll(label, score, neww, cont);
        scene = new Scene(stack, 1200, 600);
    }

}
