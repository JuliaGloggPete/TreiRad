import java.util.Random;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        Board b = new Board();

do {
    System.out.println("Hello - how about som Tic Tac Toe - Wanna play y/n?");

    String wantToPlay = sc.nextLine();

    // kortar ner här genom if y if n och else not a valid answer och sen loopar om - då behöver jag inte tv

    //validMenuChoice(wantToPlay);
    switch (wantToPlay) {
        case "n":
            System.out.println("ok, bye!");

            break;
        case "y":

            // 1 or two players
            boolean play = true;

            while (play) {
                b.printBoard();
                System.out.println("do you want to play against another player press 1 \n" +
                        "do your want to play against the computer press 2");
                String manOrMachine = sc.nextLine();
                // ska starta om utan att fråga igen...

                if (manOrMachine.equals("1")) {
                    System.out.println("Player 1 please insert your name");
                    Player p1 = new Player(sc.nextLine(), "X");
                    System.out.println("Player 2 please insert your name");
                    Player p2 = new Player(sc.nextLine(), "O");
                    playerTurn( p1, p2);
                } else if (manOrMachine.equals("2")){
                    System.out.println("Please insert your name");
                    Player p1 = new Player(sc.nextLine(), "X");
                    Player p2 = new Player("Megatron","Y");
                    andrplayerTurn(p1, p2);
                }
            }
        default:
            System.out.println("not a valid answer");
            break;

    }}
    while (true) ;
        /*} else {

            String newWantToPlay;
            do {
                System.out.println("Not a vaild answer, do you want to play y/n");
                newWantToPlay = sc.nextLine();

            } while (!validMenuChoice(newWantToPlay));
            if (validMenuChoice(newWantToPlay)) {

                switch (newWantToPlay) {
                    case "n":
                        System.out.println("ok, bye!");

                        break;
                    case "y":
                        boolean play = true;

                        while (play) {
                            b.printBoard();
                            System.out.println("do you want to play against another player press 1 \n" +
                                    "do your want to play against the computer press 2");
                            String manOrMachine= sc.nextLine();

                            if (manOrMachine.equals("1")){

                            playerTurn();}

                        }
                }*/

        }


    /*public static boolean validMenuChoice(String wantToPlay) {

        while (true) {
            if (wantToPlay.equals("y")) {
                return true;
            } else if (wantToPlay.equals("n")) {
                return false;
            }
            return false;
        }
    }*/

    public static void playerMove(String choice, String symbol, String name, Board b) {

        Scanner sc = new Scanner(System.in);

        if (validMove(choice, b)) {
            b.board[setPos(choice)] = b.board[setPos(choice)].replace(".", symbol);
            b.printBoard();


        } else {
            String newChoice;

            do {

                System.out.println("That was not a valid choice, " +
                        name + " it's your turn, where do you want to set your " + symbol + "!");
                newChoice = sc.nextLine();

            } while (!validMove(newChoice, b));
            if (validMove(newChoice, b)) {
                b.board[setPos(newChoice)] = b.board[setPos(newChoice)].replace(".", symbol);
                b.printBoard();

            }
        }
    }




public static String artificialPlayer(Board b) {
        String symbol = "Y";
        Random random = new Random();

        int robotPos = random.nextInt(8);
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

    public static void andrplayerTurn(Player p1, Player p2) {
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
                // artificialPlayer(b);

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
                String name = p2.getName();
                playerMove(artificialPlayer(b), symbol, name, b);

                if (b.checkWin(p2.getSymbol()) == true) {
                    System.out.println(p2.getName() + " you won!\n get ready for a new round");
                    break;
                } else {

                    if (b.checkDraw(b.board)) {
                        break;
                    }
                }
            }
        }}
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
                // artificialPlayer(b);

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
                String choice = sc.nextLine();

                String symbol = "O";
                String name = p2.getName();
                playerMove(choice, symbol, name, b);

                if (b.checkWin(p2.getSymbol()) == true) {
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

    public static int setPos(String pos) {


        try {
            switch (pos) {
                case "a1":
                    return 0;
                case "a2":
                    return 1;
                case "a3":
                    return 2;
                case "b1":
                    return 3;
                case "b2":
                    return 4;
                case "b3":
                    return 5;
                case "c1":
                    return 6;
                case "c2":
                    return 7;
                case "c3":
                    return 8;
            }
        } catch (Exception e) {
            System.out.println("not a valid move");
        }

// här behöver jag felhanteringen

        return 9;
    }

    public static boolean validMove(String pos, Board b) {


        try {
            if (pos.equals("a1") || pos.equals("a2") || pos.equals("a3") ||
                    pos.equals("b1") || pos.equals("b2") || pos.equals("b3") ||
                    pos.equals("c1") || pos.equals("c2") || pos.equals("c3")) {

                setPos(pos);

                return b.board[setPos(pos)].equals(".");
            }} catch (Exception e) { System.out.println("Thats not a valid position");

        }


        return false;
    }}