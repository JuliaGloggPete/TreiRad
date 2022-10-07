import java.util.Random;

public class AI extends Player{


    public AI(String name, String symbol) {
        super(name, symbol);

    }
    public AI(){
        name= "Megatron";
        symbol="O";
    }

    //create a method in order to enable the AI to choos a position
    public static int ArtificialChoice() {

        Random random = new Random();

        int robotPos = random.nextInt(9)+1;

        return robotPos;
    }

}
