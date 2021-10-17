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

    public void start(Stage stage)
    {
        this.stage = stage;
        config();
        nickName.setText("Lilla");
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
                console.setText("A neved: " + nickInput.getText());
            }
        });
        exit.setOnMouseClicked((action) -> stage.close());
    }

}
