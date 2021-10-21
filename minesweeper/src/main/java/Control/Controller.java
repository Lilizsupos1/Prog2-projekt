package Control;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

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

    public void start(Stage stage)
    {
        this.stage = stage;
        config();
        nickName.setText("Lilla");
        bombNumber.setText("10");
        this.stage.show();
    }

    private void config()
    {
        changeNickname.setOnMouseClicked((action) ->
        {
            if(nickInput.getText().equals("")){
                console.setText("Irj be valamit!");
            }else {
                nickName.setText(nickInput.getText());
            }
        });
        exit.setOnMouseClicked((action) -> stage.close());

        changeDifficulty.setOnMouseClicked((action) -> bombNumber.setText(numberInput.getText()));


    }

}
