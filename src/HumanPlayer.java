public class HumanPlayer extends Player {
    String type = "h";
    //h for human

    public HumanPlayer(String name, String symbol,String type) {
        super(name, symbol,type);

    }

    public String getType() {
        return type;
    }
}
