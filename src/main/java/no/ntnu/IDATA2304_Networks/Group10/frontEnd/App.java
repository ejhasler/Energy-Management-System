package no.ntnu.IDATA2304_Networks.Group10.frontEnd;

import javafx.application.Application;
import javafx.stage.Stage;

public class App extends Application {
    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage stage) throws Exception {
        MainWindow mainWindow =  new MainWindow();
    }
}
