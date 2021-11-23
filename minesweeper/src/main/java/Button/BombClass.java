package Button;

import Control.RevealButton;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import java.nio.charset.StandardCharsets;
import java.net.URLDecoder;

public class BombClass extends InGameButton{

    private final String path = "Images/bomb.png";

    @Override
    public void execute() {
        System.out.println("Bomba vagyok!");

        Image image;
        if (!button.isDisable()){
            String imagePath;
            imagePath = URLDecoder.decode(String.valueOf(getClass().getClassLoader().getResource(path)), StandardCharsets.UTF_8);
            image =  new Image(imagePath);
            ImageView imageView = new ImageView(image);
            button.setGraphic(imageView);
            button.setDisable(true);
            button.setOpacity(1);
            RevealButton.lose();


            //TODO: Game over

        }
    }



}
