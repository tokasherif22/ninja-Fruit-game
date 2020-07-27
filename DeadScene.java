package view;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.stage.Stage;

public class DeadScene {

    Scene scene;
    Stage stage;
    Label toMenu = new Label("Back to Menu");
    Label cong = new Label("You Lost");
    LevelsChoice choice;
    Menu menu;

    public void prepareScene() {
        toMenu.setFont(Font.font("Chiller", 50));
        toMenu.setTextFill(Color.TOMATO);

        Canvas canvas = new Canvas(1200, 600);
        GraphicsContext context = canvas.getGraphicsContext2D();
        Image image = new Image(getClass().getResource("back.png").toExternalForm());
        context.drawImage(image, 0, 0);

        VBox vb = new VBox(25);
        cong.setFont(Font.font("Chiller", 200));
        cong.setTextFill(Color.TOMATO);
        vb.setPadding(new Insets(30, 30, 30, 30));
        StackPane stack = new StackPane();
        stack.getChildren().addAll(canvas, vb);
        vb.setAlignment(Pos.CENTER);
        vb.getChildren().addAll(cong, toMenu);
        scene = new Scene(stack, 1200, 600);

        toMenu.setOnMouseClicked((event) -> {

            menu.prepareScene();
            stage.setScene(menu.getScene());
        });

    }

    public void setStage(Stage stage) {
        this.stage = stage;
    }

    public Scene getScene() {
        return scene;
    }

    public void setMenu(Menu menu) {
        this.menu = menu;
    }

}
