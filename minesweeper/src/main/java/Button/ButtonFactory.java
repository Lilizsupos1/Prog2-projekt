package Button;

import javafx.scene.control.Button;

public class ButtonFactory {
    private static final ButtonFactory instance = new ButtonFactory();
    public InGameButton getButton(BombType type){
        InGameButton temp = null;
        switch (type) {
            case BOMB -> {temp = new BombClass(); break;}
            case EMPTY -> {temp = new EmptyClass(); break;}
            case NUMBER -> {temp = new NumberClass(); break;}
        }
        return temp;
    }
    public static ButtonFactory getInstance(){
        return instance;
    }
}
