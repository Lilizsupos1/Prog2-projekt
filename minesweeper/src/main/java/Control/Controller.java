package Control;

import javafx.fxml.FXML;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;

import java.awt.*;

public class Controller {

    private Stage stage;

    @FXML
    private Label nickName;
    @FXML
    private Button changeNickname;
    @FXML
    private TextField nickInput;
    @FXML
    private Label console;
    @FXML
    private Button exit;
    @FXML
    private Label bombNumber;
    @FXML
    private Button changeDifficulty;
    @FXML
    private TextField numberInput;
    @FXML
    private Button start;
    @FXML
    private Button stop;
    @FXML
    private GridPane GameGridPane;

    public void start(Stage stage) {
        this.stage = stage;
        config();
        nickName.setText("Lilla");
        bombNumber.setText("10");
        this.stage.show();
    }

    private void config() {
        changeNickname.setOnMouseClicked((action) ->
        {
            if (nickInput.getText().equals("")) {
                console.setText("Irj be valamit!");
            } else {
                nickName.setText(nickInput.getText());
            }
        });
        exit.setOnMouseClicked((action) -> stage.close());

        changeDifficulty.setOnMouseClicked((action) -> bombNumber.setText(numberInput.getText()));
        start.setOnMouseClicked((action ) -> startGame());





    }
    private void startGame (){
         GameGridConfig grid = new GameGridConfig(GameGridPane,Integer.valueOf(bombNumber.getText()));
         GameGridPane = grid.getGrid();
    }
}
