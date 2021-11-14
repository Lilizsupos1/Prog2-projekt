package Button;

import javafx.scene.control.Button;

public abstract class InGameButton {
    private Double [] buttonSize = {41.5,41.5};
    protected Button button;
    public abstract void execute();
    public InGameButton (){
        button =new Button();
        button.setPrefSize(buttonSize[0],buttonSize[1]);
    }
    public Button getButton() {
        return button;
    }
}
