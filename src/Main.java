import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        Board b = new Board();
        int round =1;

        System.out.println("Hello - how about som Tic Tac Toe - Wanna play? press anything and enter to continue");
        sc.nextLine();

        boolean play = true;

        while (play) {
            b.printBoard();
            System.out.println("do you want to play against another player press 1 \n" +
                    "do your want to play against the computer press 2");
            String manOrMachine = sc.nextLine();




                if (manOrMachine.equals("1"))
                {    System.out.println("Player 1 please insert your name");

                    HumanPlayer p1 = new HumanPlayer(sc.nextLine(), "X");
                    System.out.println("Player 2 please insert your name");
                HumanPlayer p2 = new HumanPlayer(sc.nextLine(), "O");

                    do {
                        playerTurn(p1, p2);

                        round++;
                        System.out.println("do you want to quit? Press q, wanna continue press anything else");
                        String wantToQuit = sc.nextLine();
                        if (wantToQuit.equals("q")) {
                            System.out.println("ok, bye!");
                            play = false;
                            break;
                        }
                        System.out.println("Get ready for round "+round+"!");

                    }
                    while (play);
                }
                else if (manOrMachine.equals("2")) {
                    System.out.println("Player 1 please insert your name");
                    HumanPlayer p1 = new HumanPlayer(sc.nextLine(), "X");

                AI a1 = new AI();
                do {

                    machineAndManPlayerTurn(p1, a1);
                    round++;

                    System.out.println("do you want to quit? Press q, wanna continue press anything else");
                    String wantToQuit = sc.nextLine();
                    if (wantToQuit.equals("q")) {
                        System.out.println("ok, bye!");
                        play = false;
                        break;
                    }

                    System.out.println("Get ready for round "+round+"!");
                }
                while (play);
            }

        }
    }

    public static void playerTurn(Player p1, Player p2) {
        Scanner sc = new Scanner(System.in);
        Board b = new Board();

        for (int i = 0; i < 9; i++) {

            if (i % 2 == 0) {

                System.out.println(p1.getName() +
                        " it's your turn, where do you want to set your " + p1.getSymbol() + "!");
                String choice = sc.nextLine();
                String symbol = p1.getSymbol();
                String name = p1.getName();
                playerMove(choice, symbol, name, b);

                if (b.checkWin(symbol)) {

                    XWon(p1.getName());
                    System.out.println(name + " you won!");
                    break;

                } else {

                    if (b.checkDraw(b.board)) {
                        break;
                    }
                }
            } else {
                System.out.println(p2.getName() + " it's your turn, where do you want to set your " + p2.getSymbol() + "!");
                String choice = sc.nextLine();

                String symbol = "O";
                String name = p2.getName();
                playerMove(choice, symbol, name, b);

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
        }
    }

    public static void machineAndManPlayerTurn(HumanPlayer p1, AI a1) {
        Scanner sc = new Scanner(System.in);
        Board b = new Board();

        for (int i = 0; i < 9; i++) {

            if (i % 2 == 0) {

                System.out.println(p1.getName() +
                        " it's your turn, where do you want to set your " + p1.getSymbol() + "!");
                String choice = sc.nextLine();
                String symbol = p1.getSymbol();
                String name = p1.getName();
                playerMove(choice, symbol, name, b);

                if (b.checkWin(symbol)) {
                    XWon(p1.getName());
                    System.out.println(name + " you won!");
                    break;
                } else {

                    if (b.checkDraw(b.board)) {
                        break;
                    }
                }
            } else {
                System.out.println(a1.getName() + " it's your turn, where do you want to set your " + a1.getSymbol() + "!");
                AI.ArtificialPos();

                String symbol = "O";
                machineMove(AI.ArtificialPos(), symbol, b);

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

    public static void machineMove(int choice, String symbol, Board b) {

        if (b.validMoveAI(choice, b)) {
            b.board[b.setPosAi(choice)] = b.board[b.setPosAi(choice)].replace(".", symbol);
            b.printBoard();
        } else {

            machineMove(AI.ArtificialPos(), symbol, b);
        }
    }

    static int xWon = 0;
    static int oWon = 0;
    public static void XWon(String name){

        xWon++;
             System.out.println("Times "+name+" won:"+ xWon);
    }

    public static void OWon(String name){
        oWon++;
        System.out.println("Times "+name+" won:"+ oWon);

    }
}