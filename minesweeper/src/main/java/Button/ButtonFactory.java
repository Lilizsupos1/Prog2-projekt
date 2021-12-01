package Button;



public class ButtonFactory {
    private static final ButtonFactory instance = new ButtonFactory();
    public InGameButton getButton(BombType type){
        InGameButton temp ;
        switch (type) {
            case BOMB -> temp = new BombClass();
            case EMPTY -> temp = new EmptyClass();
            case NUMBER -> temp = new NumberClass();
            default -> throw new IllegalStateException("Unexpected value: " + type);
        }
        return temp;
    }
    public static ButtonFactory getInstance(){
        return instance;
    }
}
