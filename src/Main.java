import java.util.Scanner;
public class Main {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        Board b = new Board();
        int round = 1;

        System.out.println("Welcome \n\n" +
                " TTTTTTTTTT   II    CCCC       TTTTTTTTTTT    AA        CCCC       TTTTTTTTTTTT  OOOO      EEEEEEEE\n" +
                "     TT       II   CC    C          TT       A  A     CC     C          TT     OO    OO    EE\n" +
                "     TT       II  CC                TT      A    A    CC                TT    OO      OO   EE\n" +
                "     TT       II  CC                TT     AAAAAAAA   CC                TT    OO      OO   EEEEEE\n" +
                "     TT       II  CC      C         TT    A        A  CC      C         TT    OO      OO   EE\n" +
                "     TT       II   CC    C          TT   A          A  CC    C          TT     OO    OO    EE\n" +
                "     TT       II     CCCC           TT  A            A   CCCC           TT       OOOO      EEEEEEEE\n\n");

        boolean play = true;

        while (play) {

            System.out.println("Do you want to play against another player? Press 1 \n" +
                    "Do you want to play against the computer? Press 2");
            String manOrMachine = sc.nextLine();

            if (manOrMachine.equals("1")) {
                System.out.println("Player 1 please insert your name");

                HumanPlayer p1 = new HumanPlayer(sc.nextLine(), "X","h");
                System.out.println("Player 2 please insert your name");
                HumanPlayer p2 = new HumanPlayer(sc.nextLine(), "O","h");
                do {
                    b.printBoard();
                    playerTurn(p1, p2);
                    round++;
                    if (Quit()){
                        play = false;
                        break;}
                    System.out.println("Get ready for round " + round + "!");

                }
                while (play);}


            else if (manOrMachine.equals("2")) {
                System.out.println("Player 1 please insert your name");
                HumanPlayer p1 = new HumanPlayer(sc.nextLine(), "X","h");

                AI p2 = new AI();
                do {
                    b.printBoard();
                    playerTurn(p1, p2);

                    round++;
                    if (Quit()){
                        play = false;
                        break;}
                    System.out.println("Get ready for round " + round + "!");

                }
                while (play);}
        }
    }

    private static boolean Quit(){
        Scanner sc = new Scanner(System.in);
        System.out.println("Do you want to quit? Press \"q\"(and Enter), wanna continue press anything else(and Enter)!");
        String wantToQuit = sc.nextLine();
        if (wantToQuit.equals("q")) {
            System.out.println("Ok, thank you for playing, hope to see you soon again! Bye, bye!");
            return true;
        }
        return false;
    }

    public static void playerTurn(Player p1, Player p2) {
        Scanner sc = new Scanner(System.in);
        Board b = new Board();

        for (int i = 0; i < 9; i++) {

            if (i % 2 == 0) {

                System.out.println(p1.getName() +
                        " it's your turn, where do you want to set your " + p1.getSymbol() + "!");
                String choice = sc.nextLine();
                b.playerMove(choice, p1.getSymbol(), p1.getName());

                if (b.checkWin(p1.getSymbol())==true) {

                    XWon(p1.getName());
                    System.out.println(p2.getName()+" your wins are:"+oWon);
                    break;

                } else {

                    if (b.checkDraw(b.board)) {
                        break;
                    }
                }
            } else {

                if(p2.getType().equals("h")){

                // if type = human
                System.out.println(p2.getName() + " it's your turn, where do you want to set your " + p2.getSymbol() + "!");
                String choice = sc.nextLine();

                b.playerMove(choice, p2.getSymbol(), p2.getName());

                if (b.checkWin(p2.getSymbol())) {
                    OWon(p2.getName());

                    System.out.println(p1.getName()+" your wins are:"+xWon);
                    break;
                } else {

                    if (b.checkDraw(b.board)) {
                        break;
                    }
                }
            } else  {
                    System.out.println(p2.getName() + " it's your turn, where do you want to set your " + p2.getSymbol() + "!");

                    AI.ArtificialChoice();
                    b.AIMove(AI.ArtificialChoice(), p2.getSymbol());

                    if (b.checkWin(p2.getSymbol())) {
                        OWon(p2.getName());
                        System.out.println(p2.getName() + " you won!");
                        break;
                    } else {

                        if (b.checkDraw(b.board)) {
                            break;
                        }
                    }

                }
        }}
    }

    // in order to be able to count individual wins:
    static int xWon = 0;
    static int oWon = 0;
    public static void XWon(String name) {
        xWon++;
        System.out.println(name+ ", you win!!! \nTimes " + name + " won:" + xWon);
    }

    public static void OWon(String name) {
        oWon++;
        System.out.println(name+ ", you win!!! \nTimes " + name + " won:" +  oWon);
    }
}