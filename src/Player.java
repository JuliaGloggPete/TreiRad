public class Player {

    String name;
    String symbol;
    String type = " ";

    public Player(String name,String symbol,String type) {
        this.name = name;
        this.symbol = symbol;
        this.type= type;
    }
public Player(){

}
    public String getName() {
        return name;
    }

    public String getSymbol() {
        return symbol;
    }

    public String getType() {
        return type;
    }
}

