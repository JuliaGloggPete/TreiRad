import java.util.Random;

public class AI extends Player{

String type = "a1";
    public AI(String name, String symbol,String type) {
        super(name, symbol,type);
    }
    public AI(){
        name= "Megatron";
        symbol="O";
        type = "a1";
    }

    //create a method in order to enable the AI to choose a position
    public static int ArtificialChoice() {

        Random random = new Random();

        int robotPos = random.nextInt(9)+1;

        return robotPos;
    }

    @Override
    public String getType() {
        return type;
    }
}
