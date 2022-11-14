package no.ntnu.IDATA2304_Networks.Group10.frontEnd;

import javafx.scene.Scene;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

import java.awt.*;

public class MainWindow {
    private Scene scene;
    private Stage stage;

    public MainWindow(){
        BorderPane rootNode = new BorderPane();

        VBox content = new VBox();
        HBox middleBox = new HBox();

        Label graph = new Label("Placeholder for graph");
        Label information = new Label("Information about the graph");

        Button button = new Button("Some button");

        rootNode.setCenter(content);

        //content.getChildren().add(graph);
        content.getChildren().add(middleBox);

        //middleBox.getChildren().add(information);
        //middleBox.getChildren().add(button);

        this.scene = new Scene(rootNode,300,300);
        stage.setScene(scene);
        stage.show();

    }
}
