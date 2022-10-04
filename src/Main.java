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
        if (b.validMove(choice)) {
            b.board[b.setPos(choice)] = b.board[b.setPos(choice)].replace(".", symbol);
            b.printBoard();

        } else {
            String newChoice;

            do {

                System.out.println("That was not a valid choice, " +
                        name + " it's your turn, where do you want to set your " + symbol + "!");
                newChoice = sc.nextLine();

            } while (!b.validMove(newChoice));
            if (b.validMove(newChoice) == true) {
                b.board[b.setPos(newChoice)] = b.board[b.setPos(newChoice)].replace(".", symbol);
                b.printBoard();
            }
        }
    }

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
}
