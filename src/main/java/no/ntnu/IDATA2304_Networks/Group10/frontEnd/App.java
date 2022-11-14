package no.ntnu.IDATA2304_Networks.Group10.frontEnd;

import javafx.application.Application;
import javafx.stage.Stage;
import no.ntnu.IDATA2304_Networks.Group10.frontEnd.MainWindow;

import static javafx.application.Application.launch;

public class App extends Application {
    public static void main(String[] args) {
        System.out.println("Hello world!");
        launch(args);
    }

    @Override
    public void start(Stage stage) throws Exception {
        MainWindow mainWindow = new MainWindow();
    }

}