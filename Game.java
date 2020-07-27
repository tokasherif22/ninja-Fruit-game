package view;

import javafx.animation.Animation;
import javafx.animation.KeyFrame;
import javafx.animation.ParallelTransition;
import javafx.animation.Timeline;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.canvas.Canvas;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.image.ImageView;
import javafx.stage.Stage;
import javafx.util.Duration;
import Controller.Player;
import Model.Bombs;
import Model.Command;
import Model.Create;
import Model.Fruits;
import Model.FruitsFactory;
import Model.Load;
import Model.Save;
import Model.SaveOnCommand;
import Model.SaverLoader;
import Model.SaverLoaderController;
import Model.Strategy;
import java.util.Random;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.image.Image;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javax.xml.parsers.ParserConfigurationException;

public class Game {

    Scene scene;
    Stage stage;
    ImageView imageView;
    DeadScene deadScene;
    Player player;
    Strategy strategy;
    int livesLeft;
    int score;
    Label getLivesLeft = new Label();
    Label getScore = new Label();
    Label timer = new Label();
    Label lives = new Label("Lives");
    Label Score = new Label("Score");
    Label timerr = new Label("Time");
    Label reset = new Label("Reset");
    Label exit = new Label("Exit Game");
    SaverLoader saverLoader;
    Fruits fruits;
    Bombs bombs;
    Menu menu;
    FruitsFactory factory;

    SaverLoaderController controller;

    public void setController(SaverLoaderController controller) {
        this.controller = controller;
    }

    public void setStage(Stage stage) {
        this.stage = stage;
    }

    public Scene getScene() {
        return scene;
    }

    public void setPlayer(Player player) {
        this.player = player;
    }

    public void setDeadScene(DeadScene deadScene) {
        this.deadScene = deadScene;
    }

    public void setStrategy(Strategy strategy) {
        this.strategy = strategy;
    }

    public void setFruits(Fruits fruits) {
        this.fruits = fruits;
    }

    public void setBombs(Bombs bombs) {
        this.bombs = bombs;
    }

    public void setMenu(Menu menu) {
        this.menu = menu;
    }

    public void setFactory(FruitsFactory factory) {
        this.factory = factory;
    }

    public void setSaverLoader(SaverLoader saverLoader) {
        this.saverLoader = saverLoader;
    }

    public void prepareScene(Strategy strategy) {

        getLivesLeft.setTextFill(Color.TOMATO);
        getScore.setTextFill(Color.TOMATO);
        timer.setTextFill(Color.TOMATO);
        lives.setTextFill(Color.TOMATO);
        Score.setTextFill(Color.TOMATO);
        timerr.setTextFill(Color.TOMATO);
        getLivesLeft.setFont(Font.font("Chiller", 30));
        getScore.setFont(Font.font("Chiller", 30));
        timer.setFont(Font.font("Chiller", 30));
        lives.setFont(Font.font("Chiller", 30));
        Score.setFont(Font.font("Chiller", 30));
        timerr.setFont(Font.font("Chiller", 30));

        getLivesLeft.setText(String.valueOf(player.getLivesLeft()));
        getScore.setText(String.valueOf(player.getScore()));
        livesLeft = player.getLivesLeft();
        score = player.getScore();

        Canvas canvas = new Canvas(1200, 600);
        GraphicsContext context = canvas.getGraphicsContext2D();
        Image image = new Image(getClass().getResource("back.png").toExternalForm());
        context.drawImage(image, 0, 0);
        Random random = new Random();

        Create fruit1 = factory.getFruit("Orange");
        fruit1.createImage();
        Create fruit2 = factory.getFruit("mango");
        fruit2.createImage();
        Create fruit3 = factory.getFruit("Berry");
        fruit3.createImage();
        Create fruit4 = factory.getFruit("Strawberry");
        fruit4.createImage();
        Create fruit5 = factory.getFruit("BANANA");
        fruit5.createImage();

        Bombs bomb1 = new Bombs("Fbomb1.png");
        Bombs bomb2 = new Bombs("bomb1.png");

        fruit1.setXY(random.nextInt(800), random.nextInt(100));
        fruit3.setXY(random.nextInt(800), random.nextInt(100));
        fruit5.setXY(random.nextInt(800), random.nextInt(100));
        bomb2.setXY(random.nextInt(800), random.nextInt(100));
        fruit2.setXY(random.nextInt(800), random.nextInt(100));
        bomb1.setXY(random.nextInt(800), random.nextInt(100));
        fruit4.setXY(random.nextInt(800), random.nextInt(100));

        player.setStrategyValue(strategy.speed());

        ParallelTransition parallelTransition = new ParallelTransition(fruit3.tran(), fruit2.tran(), fruit1.tran(), fruit4.tran(), bomb1.tran(), bomb2.tran(), fruit5.tran());
        bomb1.setXYT(0, 601, strategy.speed());
        fruit2.setXYT(0, 601, strategy.speed());
        fruit3.setXYT(0, 601, strategy.speed());
        fruit5.setXYT(0, 601, strategy.speed());
        fruit4.setXYT(0, 601, strategy.speed());
        bomb2.setXYT(0, 601, strategy.speed());
        fruit1.setXYT(0, 601, strategy.speed());
        parallelTransition.setCycleCount(50);
        parallelTransition.play();
        timer.setText(String.valueOf(player.getTime()));
        Timeline timeline2 = new Timeline(new KeyFrame(Duration.seconds(1), ev -> {
            if (player.isDead() == true) {
                stage.setScene(deadScene.getScene());
            }
            player.setTime();
            timer.setText(String.valueOf(player.getTime()));

        }));
        timeline2.setCycleCount(Animation.INDEFINITE);
        timeline2.play();
        Timeline timeline = new Timeline(new KeyFrame(Duration.seconds(strategy.visiblity()), ev -> {
            fruit1.setXY(random.nextInt(800), random.nextInt(100));
            fruit3.setXY(random.nextInt(800), random.nextInt(100));
            fruit5.setXY(random.nextInt(800), random.nextInt(100));
            bomb2.setXY(random.nextInt(800), random.nextInt(100));
            fruit2.setXY(random.nextInt(800), random.nextInt(100));
            bomb1.setXY(random.nextInt(800), random.nextInt(100));
            fruit4.setXY(random.nextInt(800), random.nextInt(100));

            if (fruit1.image().isVisible() == true) {
                player.setLivesLeft(--livesLeft);
                getLivesLeft.setText(String.valueOf(player.getLivesLeft()));
                if (player.isDead() == true) {
                    Command on = new SaveOnCommand(saverLoader);
                    controller.setCommand(on);
                    controller.pressButton();
                    stage.setScene(deadScene.getScene());
                }
            }
            if (fruit2.image().isVisible() == true) {
                player.setLivesLeft(--livesLeft);
                getLivesLeft.setText(String.valueOf(player.getLivesLeft()));
                if (player.isDead() == true) {
                    Command on = new SaveOnCommand(saverLoader);
                    controller.setCommand(on);
                    controller.pressButton();
                    stage.setScene(deadScene.getScene());
                }
            }
            if (fruit3.image().isVisible() == true) {
                player.setLivesLeft(--livesLeft);
                getLivesLeft.setText(String.valueOf(player.getLivesLeft()));
                if (player.isDead() == true) {
                    Command on = new SaveOnCommand(saverLoader);
                    controller.setCommand(on);
                    controller.pressButton();
                    stage.setScene(deadScene.getScene());
                }
            }
            if (fruit4.image().isVisible() == true) {
                player.setLivesLeft(--livesLeft);
                getLivesLeft.setText(String.valueOf(player.getLivesLeft()));
                if (player.isDead() == true) {
                    Command on = new SaveOnCommand(saverLoader);
                    controller.setCommand(on);
                    controller.pressButton();
                    stage.setScene(deadScene.getScene());
                }
            }
            if (fruit5.image().isVisible() == true) {
                player.setLivesLeft(--livesLeft);
                getLivesLeft.setText(String.valueOf(player.getLivesLeft()));
                if (player.isDead() == true) {
                    Command on = new SaveOnCommand(saverLoader);
                    controller.setCommand(on);
                    controller.pressButton();
                    stage.setScene(deadScene.getScene());
                }
            }
            fruit1.setVisibleTrue();
            fruit2.setVisibleTrue();
            fruit3.setVisibleTrue();
            fruit4.setVisibleTrue();
            fruit5.setVisibleTrue();
            bomb1.setVisibleTrue();
            bomb2.setVisibleTrue();

        }));

        timeline.setCycleCount(Animation.INDEFINITE);
        timeline.play();

        player.setTimeline(timeline);
        player.setTimeline1(timeline2);
        player.setParallelTransition(parallelTransition);

        getLivesLeft.setText(String.valueOf(player.getLivesLeft()));

        bomb2.image().setOnMouseMoved((event) -> {
            player.setLivesLeft(--livesLeft);
            if (player.isDead() == true) {
                Command on = new SaveOnCommand(saverLoader);
                controller.setCommand(on);
                controller.pressButton();
                stage.setScene(deadScene.getScene());
            }
            getLivesLeft.setText(String.valueOf(player.getLivesLeft()));
            player.isBestScore();
            bomb2.isSliced();

        });

        bomb1.image().setOnMouseMoved((event) -> {
            player.Dead();
            Command on = new SaveOnCommand(saverLoader);
            controller.setCommand(on);
            controller.pressButton();
            stage.setScene(deadScene.getScene());
            player.isBestScore();
        });
        fruit1.image().setOnMouseMoved((event) -> {

            player.setScore(++score);
            getScore.setText(String.valueOf(player.getScore()));
            player.isBestScore();
            fruit1.isSliced();

        });

        fruit2.image().setOnMouseMoved((event) -> {
            player.setScore(++score);
            player.setScore(++score);
            player.setScore(++score);
            player.setScore(++score);
            player.setScore(++score);
            getScore.setText(String.valueOf(player.getScore()));
            player.isBestScore();
            fruit2.isSliced();

        });
        fruit4.image().setOnMouseMoved((event) -> {

            player.setScore(++score);
            player.setScore(++score);
            player.setScore(++score);
            player.setScore(++score);
            player.setScore(++score);
            getScore.setText(String.valueOf(player.getScore()));
            player.isBestScore();
            fruit4.isSliced();

        });
        fruit3.image().setOnMouseMoved((event) -> {
            player.setScore(++score);
            getScore.setText(String.valueOf(player.getScore()));
            player.isBestScore();
            fruit3.isSliced();

        });
        fruit5.image().setOnMouseMoved((event) -> {
            player.setScore(++score);
            getScore.setText(String.valueOf(player.getScore()));
            player.isBestScore();
            fruit5.isSliced();

        });

        reset.setLayoutX(1020);
        reset.setLayoutY(110);
        exit.setLayoutX(1020);
        exit.setLayoutY(160);
        lives.setLayoutX(1000);
        lives.setLayoutY(10);
        getLivesLeft.setLayoutX(1100);
        getLivesLeft.setLayoutY(10);
        Score.setLayoutX(1000);
        Score.setLayoutY(40);
        getScore.setLayoutX(1100);
        getScore.setLayoutY(40);
        timerr.setLayoutX(1000);
        timerr.setLayoutY(70);
        timer.setLayoutX(1100);
        timer.setLayoutY(70);
        exit.setFont(Font.font("Chiller", 35));
        exit.setTextFill(Color.TOMATO);
        reset.setFont(Font.font("Chiller", 35));
        reset.setTextFill(Color.TOMATO);

        reset.setOnMouseClicked((event) -> {

            player.setLivesLeft(3);
            player.setScore(0);
            player.setTime(60);
            score = player.getScore();
            timer.setText(String.valueOf(player.getTime()));
            getLivesLeft.setText(String.valueOf(player.getLivesLeft()));
            getScore.setText(String.valueOf(player.getScore()));
            fruit1.setVisibleFalse();
            fruit2.setVisibleFalse();
            fruit3.setVisibleFalse();
            fruit4.setVisibleFalse();
            fruit5.setVisibleFalse();
            bomb1.setVisibleFalse();
            bomb2.setVisibleFalse();

        }
        );
        exit.setOnMouseClicked((event) -> {
            Command on = new SaveOnCommand(saverLoader);
            controller.setCommand(on);
            controller.pressButton();
            menu.prepareScene();
            stage.setScene(menu.getScene());
            player.setLivesLeft(3);
            player.setScore(0);
            player.setTime(60);
            timeline.stop();
            timeline2.stop();
            parallelTransition.stop();

        }
        );

        Group root = new Group();
        scene = new Scene(root, 1200, 600);

        root.getChildren().addAll(canvas, bomb1.image(), bomb2.image(), getLivesLeft, fruit1.image(), fruit2.image(), getScore, reset, fruit3.image(), fruit4.image(), fruit5.image(), timer, Score, lives, timerr, exit);

    }

}
