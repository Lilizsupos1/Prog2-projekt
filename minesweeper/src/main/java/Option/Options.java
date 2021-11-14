package Option;

import javafx.scene.image.Image;
import lombok.Data;

import java.awt.*;

@Data
public class Options {

    private Dimension size;
    private String nickName;
    private Integer difficulty;
    private Dimension gamePanelSize;
    private boolean resizeable;
    private String title;
    private Dimension infoPanelSize;
    private Dimension menuPanelSize;
    private Dimension consolePanelSize;
    private Image image;


}
