package Button;

import Control.GameGridConfig;
import Control.RevealButton;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

import java.net.URLDecoder;
import java.nio.charset.StandardCharsets;

public class NumberClass extends InGameButton{

    private Integer score = 0;
    private String pathToNumbers = "Images/";

    @Override
    public void execute() {

        System.out.println("Szám vagyok!");


        if(!button.isDisable()){
            Image image;

            pathToNumbers = pathToNumbers + score.toString() + ".png";
            String imagePath ;
            imagePath = URLDecoder.decode(String.valueOf(getClass().getClassLoader().getResource(pathToNumbers)), StandardCharsets.UTF_8);
            image = new Image(imagePath);
            ImageView imageView = new ImageView(image);
            button.setGraphic(imageView);
            button.setDisable(true);
            button.setOpacity(1);
            RevealButton.incrementRevealedNumber();


        }
    }

    public void changeScore(Integer number)
    {
        score = number;
    }
}
