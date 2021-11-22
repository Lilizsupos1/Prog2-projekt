package Control;

import Exeption.ExceptionClass;
import javafx.scene.layout.GridPane;


import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import javafx.scene.input.MouseButton;
import javafx.scene.layout.GridPane;
import javafx.scene.input.MouseButton;
import javafx.scene.layout.GridPane;

import java.awt.Point;
import java.util.ArrayList;
import java.util.List;
import java.awt.Dimension;
import java.util.Random;

import Button.ButtonFactory;
import Button.BombType;
import Button.InGameButton;
import Button.NumberClass;

public class GameGridConfig {

    private  Dimension size;
    private  ButtonFactory buttonFactory;
    private  Integer numberOfBombs;

    private static InGameButton[][] buttonMatrix;

    private GridPane grid;
    private Integer bombCount;
    private ArrayList<Point> bombs;
    public GameGridConfig(GridPane pane,Integer num){
        grid = pane;
        bombCount = num;
        config();
    }
    public GridPane getGrid() {
        return grid;
    }
    private void config(){

        int row = grid.getRowCount();
        int column = grid.getColumnCount();
        grid.setBorder(null);
        bombs = getBombs();
        for (int  i=0; i<row ; i++){
            for (int j =0; j<column; j++){
                Point temp = new Point(i,j);
                InGameButton button;
                if(bombs.contains(temp))
                {
                    button = ButtonFactory.getInstance().getButton(BombType.BOMB);
                }else{
                    button = ButtonFactory.getInstance().getButton(BombType.NUMBER);

                }
                button.getButton().setOnMouseClicked((action) -> {
                    button.execute();
                });
                grid.add(button.getButton(),i,j);

            }
        }
    }
    private ArrayList<Point> getBombs()
    {
        ArrayList<Point> tempBombs = new ArrayList<>();
        Random random = new Random();
        int tempi,tempj;
        Point temp;
        for(int i = 0;i<bombCount;i++)
        {
            tempi = random.nextInt(12) - 1;
            tempj = random.nextInt(12) - 1;
            temp = new Point(tempi,tempj);
            if(tempBombs.contains(temp)){
                i--;
            }else{
                tempBombs.add(temp);
            }

        }
        return tempBombs;
    }
    public static InGameButton[][] getButtonMatrix() {
        return buttonMatrix;
    }



    private Integer getRandomNumberInRange(Integer range)
    {
        int number;
        Random rand = new Random();
        do {
            number = rand.nextInt(range);
        }while(number % size.height != 0);

        return number;
    }

}
