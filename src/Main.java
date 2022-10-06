import java.util.Random;
import java.util.Scanner;

public class Main {



    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        Board b = new Board();

        int won=0;

        System.out.println("Hello - how about som Tic Tac Toe - Wanna play? press anything and enter to continue");
        sc.nextLine();

        boolean play = true;

        while (play) {
            b.printBoard();
            System.out.println("do you want to play against another player press 1 \n" +
                    "do your want to play against the computer press 2");
            String manOrMachine = sc.nextLine();


            if (manOrMachine.equals("1")) {

                System.out.println("Player 1 please insert your name");
                Player p1 = new Player(sc.nextLine(), "X");
                System.out.println("Player 2 please insert your name");
                Player p2 = new Player(sc.nextLine(), "O");

                do {
                    playerTurn(p1, p2);

                    System.out.println("do you want to quit? Press q, wanna continue press anything else");
                    String wantToQuit = sc.nextLine();
                    if (wantToQuit.equals("q")) {
                        System.out.println("ok, bye!");
                        play = false;
                        break;
                    }
                }
                while (play = true);


            } else if (manOrMachine.equals("2")) {
                System.out.println("Please insert your name");
                Player p1 = new Player(sc.nextLine(), "X");
                Player p2 = new Player("Megatron", "O");
                do {

                    machineAndManPlayerTurn(p1, p2);

                    System.out.println("do you want to quit? Press q, wanna continue press anything else");
                    String wantToQuit = sc.nextLine();
                    if (wantToQuit.equals("q")) {
                        System.out.println("ok, bye!");
                        play = false;
                        break;
                    }
                }
                while (play = true);
            }
        }
    }

    // should probably not have packed everything in player move at once - as I now have problems with the AI
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

    public static void machineMove(String choice, String symbol, Board b) {

        //if (validMove(choice,b))

        if (b.validMove(choice, b)) {
            b.board[b.setPos(choice)] = b.board[b.setPos(choice)].replace(".", symbol);
            b.printBoard();
        } else {

            machineMove(artificialPlayer(b),
                    symbol, b);
        }
    }


    public static String artificialPlayer(Board b) {
        String symbol = "O";
        Random random = new Random();

        int robotPos = random.nextInt(9);
        switch (robotPos) {
            case 0:
                return "a1";
            case 1:
                return "a2";
            case 2:
                return "a3";
            case 3:
                return "b1";
            case 4:
                return "b2";
            case 5:
                return "b3";
            case 6:
                return "c1";
            case 7:
                return "c2";
            case 8:
                return "c3";
        }

        return symbol;

    }

    public static void machineAndManPlayerTurn(Player p1, Player p2) {
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
                    System.out.println(name + " you won!\nGet ready for a new round");
                    break;
                } else {

                    if (b.checkDraw(b.board)) {
                        break;
                    }
                }
            } else {
                System.out.println(p2.getName() + " it's your turn, where do you want to set your " + p2.getSymbol() + "!");
                artificialPlayer(b);

                String symbol = "O";
                machineMove(artificialPlayer(b), symbol, b);

                if (b.checkWin(p2.getSymbol())) {
                    System.out.println(p2.getName() + " you won!\n get ready for a new round");
                    break;
                } else {

                    if (b.checkDraw(b.board)) {
                        break;
                    }
                }
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



                    Xwon();
                    //System.out.println(p1.getName()+"won"+ xWins);
                    System.out.println(name + " you won!\nGet ready for a new round");
                    // System.out.println("total wins for "+p1.getName()+": "+ Xwin);
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
                    Owon();

                    System.out.println(p2.getName() + " you won!\n get ready for a new round");
                    break;
                } else {

                    if (b.checkDraw(b.board)) {
                        break;
                    }
                }
            }
        }


    }
  static int Xwon= 0;
    static int Owon= 0;
    public static void Xwon(){

        Xwon++;
             System.out.println(Xwon);
    }

    public static void Owon(){
        Owon++;
        System.out.println(Owon);

    }
}