package Button;

import Control.GameGridConfig;
import Control.RevealButton;

import java.util.ArrayList;

public class EmptyClass extends InGameButton{
    @Override
    public void execute() {
        if (!button.isDisable())
        {
            RevealButton.incrementRevealedNumber();
            button.setGraphic(null);
            InGameButton[][] buttonMatrix =  GameGridConfig.getButtonMatrix();
            button.setDisable(true);
            Integer[] objIndex = new Integer[]{0,0};

            for(int i = 0; i < buttonMatrix.length -1;i++)
            {
                for(int j = 0; j < buttonMatrix[i].length-1; j++)
                {
                    if(buttonMatrix[i][j].equals(this))
                    {
                        objIndex[0] = i;
                        objIndex[1] = j;
                        break;
                    }
                }
            }

            ArrayList<InGameButton> unlockList = new ArrayList<>();

            for (int i = -1; i < 2; i++) {
                for (int j = -1; j < 2; j++) {
                    try {
                        if(buttonMatrix[i + objIndex[0]][j + objIndex[1]].getClass().equals(this.getClass())
                                || buttonMatrix[i + objIndex[0]][j + objIndex[1]].getClass().equals(NumberClass.class))
                        {
                            unlockList.add(buttonMatrix[i + objIndex[0]][j + objIndex[1]]);
                        }
                    } catch (Exception ignored) {
                        //Ignored exception because at the side buttons ArrayIndexOutOfBoundsException will be thrown
                        //every time because of the check of the surrounding buttons
                    }
                }
            }
            unlockList.forEach(InGameButton::execute);
        }
        }


}
