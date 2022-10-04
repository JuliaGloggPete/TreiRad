import java.util.Random;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        Board b = new Board();
        System.out.println("Hello - how about som Tic Tac Toe - Wanna play y/n?");

        String wantToPlay = sc.nextLine();


        if (validMenuChoice(wantToPlay) == true) {

            switch (wantToPlay) {
                case "n":
                    System.out.println("ok, bye!");

                    break;
                case "y":

                    // 1 or two players
                    boolean play = true;

                    while (play) {
                        b.printBoard();
                        playerTurn();
                    }
            }
        } else {

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

                            playerTurn();
                        }
                }
            }
        }
    }

    public static boolean validMenuChoice(String wantToPlay) {

        while (true) {
            if (wantToPlay.equals("y")) {
                return true;
            } else if (wantToPlay.equals("n")) {
                return true;
            }
            return false;
        }
    }

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




    /*public static void artificialPlayer(Board b) {
        String symbol = "Y";
        Random random = new Random();
        int robotPos = random.nextInt(9);



            if (b.board[robotPos].equals(".")) {
                b.board[robotPos].replace(".", symbol);
            } else {artificialPlayer(b);}
        }
*/

    public static void playerTurn() {
        Scanner sc = new Scanner(System.in);
        Board b = new Board();
        System.out.println("Player 1 please insert your name");
        Player p1 = new Player(sc.nextLine(), "X");
        System.out.println("Player 2 please insert your name");
        Player p2 = new Player(sc.nextLine(), "O");


        //här ska den gå sålänge inta alla är infylld

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
            System.out.println("not a vlid move");
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