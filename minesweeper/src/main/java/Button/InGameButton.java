package Button;

import Control.RevealButton;
import javafx.scene.Node;
import javafx.scene.control.Button;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;


import java.net.URLDecoder;
import java.nio.charset.StandardCharsets;

public abstract class InGameButton extends Node {
    protected Button button;
    private boolean hasFlag = false;
    public abstract void execute();
    public InGameButton (){
        button =new Button();
        Double[] buttonSize = {41.5, 41.5};
        button.setPrefSize(buttonSize[0], buttonSize[1]);
    }
    public Button getButton() {
        return button;
    }





    public void onLeftClickEvent()
    {
        final String pathToFlag = "Images/flag.png";
        if(!hasFlag)
        {
            String filePath;
            filePath = URLDecoder.decode(String.valueOf(getClass().getClassLoader().getResource(pathToFlag)), StandardCharsets.UTF_8);
            Image image = new Image(filePath);
            ImageView imageView = new ImageView(image);
            button.setGraphic(imageView);
            hasFlag = true;
            RevealButton.incrementFlagNumber();
        }else
        {
            this.button.setGraphic(null);
            hasFlag = false;
            RevealButton.decrementFlagNumber();
        }
    }


}
