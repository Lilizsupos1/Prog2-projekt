package Window;

import Control.Controller;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.geometry.Insets;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;

public class GameWindow extends Application {

    private Stage stage;
    private Parent root;
    private Controller controller;

    @Override
    public void start(Stage stage) throws Exception {
        String path = "MainStage.fxml";
        FXMLLoader loader = new FXMLLoader();
        loader.setLocation(getClass().getClassLoader().getResource(path));
        root = loader.load();
        controller = loader.getController();

        stage.setScene(new Scene(root));
        stage.setTitle("Lilla aknakereső játéka");
        stage.setResizable(false);

        controller.start(stage);
        controller.setStage(stage);



        }
    }
