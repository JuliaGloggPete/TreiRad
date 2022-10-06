import java.util.Random;

public class AI extends Player{


    public AI(String name, String symbol) {
        super(name, symbol);

    }
    public AI(){
        name= "Megatron";
        symbol="O";
    }
    public static int ArtificialPos() {

        Random random = new Random();

        int robotPos = random.nextInt(9)+1;

        return robotPos;
    }

}
