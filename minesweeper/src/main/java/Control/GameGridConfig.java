package Control;

import Button.*;
import Exeption.ExceptionClass;
import javafx.scene.layout.GridPane;


import javafx.scene.input.MouseButton;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;



import java.awt.Point;
import java.awt.Dimension;

import Button.BombClass;

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
        grid.getChildren().clear();

        int row = grid.getRowCount();
        int column = grid.getColumnCount();
        buttonMatrix = new InGameButton[row][column];
        grid.setBorder(null);
        bombs = getBombs();
        bombs.forEach(p -> {
            InGameButton button = ButtonFactory.getInstance().getButton(BombType.BOMB);
            InGameButton finalButton = button;

            button.getButton().setOnMouseClicked(event ->
            {
                if(event.getButton().equals(MouseButton.PRIMARY)){

                    finalButton.execute();

                }else{
                    finalButton.onLeftClickEvent();
                }
            });
            getButtonMatrix()[p.x][p.y] = button;

            grid.add(button.getButton(),p.x,p.y);
        });

        Integer buttonNumber = 0;
        for (int  i=0; i< buttonMatrix.length ; i++){
            for (int j =0; j< buttonMatrix[i].length; j++){
                Point temp = new Point(i,j);
                InGameButton button = new EmptyClass();
                if(buttonMatrix[i][j] == null)
                {
                    try {
                        button = getButton(new Point(i,j),bombs);
                    } catch (ExceptionClass e) {
                        //Sad
                        e.printStackTrace();
                    }
                }
                InGameButton finalButton = button;
                button.getButton().setOnMouseClicked(event ->
                {
                if(event.getButton().equals(MouseButton.PRIMARY)){
                        finalButton.execute();
                    }else{
                    finalButton.onLeftClickEvent();
                }

                });
                button.setFocusTraversable(false);
                buttonNumber++;
                GameGridConfig.getButtonMatrix()[i][j] = button;
                grid.add(button.getButton(),i,j);
                RevealButton.setBombNumber(bombCount);
                RevealButton.setButtonNumber(buttonNumber);

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
            tempi = random.nextInt(12);
            tempj = random.nextInt(12);
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
    private InGameButton getButton(Point point, List<Point> bombList) throws ExceptionClass {
        int counter = 0;
        Point temp;
        for(int i=-1;i<2;i++)
        {
            for(int j = -1; j<2;j++)
            {
                temp = new Point(point.x+i, point.y+j);
                Point finalTemp = temp;

                if(bombList.stream().anyMatch(p -> p.equals(finalTemp)))
                {
                    counter++;
                }
            }
        }
        if(counter == 0)
        {
            return ButtonFactory.getInstance().getButton(BombType.EMPTY);
        }else
        {
            NumberClass button = (NumberClass) ButtonFactory.getInstance().getButton(BombType.NUMBER);
            button.changeScore(counter);
            return button;
        }
    }

}
