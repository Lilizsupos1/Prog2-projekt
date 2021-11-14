package Control;

import javafx.scene.layout.GridPane;

import java.awt.*;
import java.util.ArrayList;
import java.util.Random;

import Button.ButtonFactory;
import Button.BombType;
import Button.InGameButton;

public class GameGridConfig {

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

}
