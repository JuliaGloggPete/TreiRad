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

                HumanPlayer p1 = new HumanPlayer(sc.nextLine(), "X");
                System.out.println("Player 2 please insert your name");
                HumanPlayer p2 = new HumanPlayer(sc.nextLine(), "O");

                do {
                    b.printBoard();
                    playerTurn(p1, p2);

                    round++;
                    if (Quit()){
                        play = false;
                        break;}
                    System.out.println("Get ready for round " + round + "!");

                }
                while (play);
            } else if (manOrMachine.equals("2")) {
                System.out.println("Player 1 please insert your name");
                HumanPlayer p1 = new HumanPlayer(sc.nextLine(), "X");

                AI a1 = new AI();
                do {
                    b.printBoard();

                    machineAndManPlayerTurn(p1, a1);
                    round++;

                    if (Quit()){
                        play = false;
                        break;
                    }

                    System.out.println("Get ready for round " + round + "!");
                }
                while (play);
            }

        }
    }

    public static boolean Quit(){
        Scanner sc = new Scanner(System.in);
        System.out.println("Do you want to quit? Press \"q\"(and Enter), wanna continue press anything else(and Enter)!");
        String wantToQuit = sc.nextLine();
        if (wantToQuit.equals("q")) {
            System.out.println("Ok, thank you for playing, hope to see you soon again! Bye, bye!");
            return true;
        }
        return false;
    }

    //method for two different human players to play
    // if i check if its a human or a Ai pleyer I may be able to have just one method with an if els for plaqyer2/a1 turn

    public static void playerTurn(HumanPlayer p1, HumanPlayer p2) {
        Scanner sc = new Scanner(System.in);
        Board b = new Board();

        for (int i = 0; i < 9; i++) {

            if (i % 2 == 0) {

                System.out.println(p1.getName() +
                        " it's your turn, where do you want to set your " + p1.getSymbol() + "!");
                String choice = sc.nextLine();
                playerMove(choice, p1.getSymbol(), p1.getName(), b);

                if (b.checkWin(p1.getSymbol())) {

                    XWon(p1.getName());
                    System.out.println(p2.getName()+" your wins are:"+oWon);
                    break;

                } else {

                    if (b.checkDraw(b.board)) {
                        break;
                    }
                }
            } else {
                System.out.println(p2.getName() + " it's your turn, where do you want to set your " + p2.getSymbol() + "!");
                String choice = sc.nextLine();

                playerMove(choice, p2.getSymbol(), p2.getName(), b);

                if (b.checkWin(p2.getSymbol())) {
                    OWon(p2.getName());

                    System.out.println(p1.getName()+" your wins are:"+xWon);
                    break;
                } else {

                    if (b.checkDraw(b.board)) {
                        break;
                    }
                }
            }
        }
    }


    // a kind of duplication from the PlayerTurn method -
    // as I dit not manage to slim it down and combine
    public static void machineAndManPlayerTurn(HumanPlayer p1, AI a1) {
        Scanner sc = new Scanner(System.in);
        Board b = new Board();

        for (int i = 0; i < 9; i++) {

            if (i % 2 == 0) {

                System.out.println(p1.getName() +
                        " it's your turn, where do you want to set your " + p1.getSymbol() + "!");
                String choice = sc.nextLine();

                playerMove(choice, p1.getSymbol(), p1.getName(), b);

                if (b.checkWin(p1.getSymbol())) {
                    XWon(p1.getName());
                    System.out.println(a1.getName()+" your wins are:"+oWon);
                    break;
                } else {

                    if (b.checkDraw(b.board)) {
                        break;
                    }
                }
            } else {
                System.out.println(a1.getName() + " it's your turn, where do you want to set your " + a1.getSymbol() + "!");
                AI.ArtificialChoice();
                AIMove(AI.ArtificialChoice(), a1.getSymbol(), b);

                if (b.checkWin(a1.getSymbol())) {
                    OWon(a1.getName());
                    System.out.println(a1.getName() + " you won!");
                    break;
                } else {

                    if (b.checkDraw(b.board)) {
                        break;
                    }
                }
            }
        }
    }

    // a method that allows the player(s) to choose where they want to put their
    // individual symbol but also restrains them from making an invalid choice
    public static void playerMove(String choice, String symbol, String name, Board b) {

        Scanner sc = new Scanner(System.in);

        if (b.validMove(choice, b)) {
            b.board[b.setPos(choice)] = b.board[b.setPos(choice)].replace(".", symbol);
            b.printBoard();

        } else {
            String newChoice;

            do {
                System.out.println("That was not a valid choice, " +
                        name + " it's your turn, where do you want to set your " + symbol + "!");
                newChoice = sc.nextLine();

            } while (!b.validMove(newChoice, b));
            if (b.validMove(newChoice, b)) {
                b.board[b.setPos(newChoice)] = b.board[b.setPos(newChoice)].replace(".", symbol);
                b.printBoard();

            }
        }
    }

    //a method that enables the Ai to move but also restrains it from making an invalid move(below)
    public static void AIMove(int choice, String symbol, Board b) {

        if (b.validMoveAI(choice, b)) {
            b.board[b.setPosAi(choice)] = b.board[b.setPosAi(choice)].replace(".", symbol);
            b.printBoard();
        } else {

            AIMove(AI.ArtificialChoice(), symbol, b);
        }
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