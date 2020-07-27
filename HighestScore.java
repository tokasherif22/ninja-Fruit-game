package view;

import javafx.animation.Timeline;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import javafx.scene.text.Font;
import javafx.stage.Stage;
import Controller.Player;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.image.Image;
import javafx.scene.paint.Color;

public class HighestScore {

    Scene scene;
    Player player;
    Stage stage;
    Label cong;
    Label cong2;
    Label menu = new Label("Back to Menu");
    Menu menu1;

    public void setStage(Stage stage) {
        this.stage = stage;
    }

    public Scene getScene() {
        return scene;
    }

    public void setPlayer(Player player) {
        this.player = player;
    }

    public void setMenu1(Menu menu1) {
        this.menu1 = menu1;
    }

    public void prepareScene() {

        Canvas canvas = new Canvas(1200, 600);
        GraphicsContext context = canvas.getGraphicsContext2D();
        Image image = new Image(getClass().getResource("back.png").toExternalForm());
        context.drawImage(image, 0, 0);

        String x = String.valueOf(player.getBestScore());
        cong = new Label(x);
        cong.setTextFill(Color.TOMATO);
        cong2 = new Label("Your Highest Score");
        cong2.setTextFill(Color.TOMATO);
        VBox vb = new VBox(25);
        cong.setFont(Font.font("Chiller", 150));
        cong2.setFont(Font.font("Chiller", 150));
        vb.setPadding(new Insets(30, 30, 30, 30));
        StackPane stack = new StackPane();
        stack.getChildren().addAll(canvas, vb);
        vb.setAlignment(Pos.CENTER);
        vb.getChildren().addAll(cong2, cong, menu);
        scene = new Scene(stack, 1200, 600);
        menu.setFont(Font.font("Chiller", 50));
        menu.setTextFill(Color.TOMATO);
        menu.setOnMouseClicked((event) -> {
            menu1.prepareScene();
            stage.setScene(menu1.getScene());

        });

    }

}
