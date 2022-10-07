
import java.util.Arrays;
import java.util.Scanner;

public class Board {
    String[] board = {".", ".", ".", ".", ".", ".", ".", ".", "."};


    public Board() {
//       String [] board= this.board;
    }
    public void printBoard() {
//        String [] board= this.board;

        System.out.println("   1   2   3\n" + "a  " + board[0] + " | " + board[1] + " | " + board[2] + "\n" +
                "  ---+---+---\n" + "b  " + board[3] + " | " + board[4] + " | " + board[5] + "\n" +
                "  ---+---+---\n" + "c  " + board[6] + " | " + board[7] + " | " + board[8] + "\n");
    }
    public boolean checkWin(String symbol) {


        if (board[0].equals(symbol) && board[1].equals(symbol) && board[2].equals(symbol) ||
                board[3].equals(symbol) && board[4].equals(symbol) && board[5].equals(symbol) ||
                board[6].equals(symbol) && board[7].equals(symbol) && board[8].equals(symbol) ||
                board[0].equals(symbol) && board[3].equals(symbol) && board[6].equals(symbol) ||
                board[1].equals(symbol) && board[4].equals(symbol) && board[7].equals(symbol) ||
                board[2].equals(symbol) && board[5].equals(symbol) && board[8].equals(symbol) ||
                board[0].equals(symbol) && board[4].equals(symbol) && board[8].equals(symbol) ||
                board[6].equals(symbol) && board[4].equals(symbol) && board[2].equals(symbol)) {
            return true;
        }

        return false;
    }

    public static int setPosAi(int Aipos){
        return Aipos;
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

        return 9;
    }

    public boolean checkDraw(String[] board) {

        //this only runs if win== false

        if (Arrays.asList((board)).contains(".")) {

            return false;
        } else {
            System.out.println("Its a tie!! No one won!");
            return true;
        }

    }
    public  boolean validMove(String pos) {

        try {
            if (pos.equals("a1") || pos.equals("a2") || pos.equals("a3") ||
                    pos.equals("b1") || pos.equals("b2") || pos.equals("b3") ||
                    pos.equals("c1") || pos.equals("c2") || pos.equals("c3")) {

                setPos(pos);

                return board[setPos(pos)].equals(".");
            }
        } catch (Exception e) {
            System.out.println("That's not a valid position");

        }

        return false;
    }
    public void AIMove(int choice, String symbol) {

        if (validMoveAI(choice)) {
            board[setPosAi(choice)] = board[setPosAi(choice)].replace(".", symbol);
            printBoard();
        } else {

            AIMove(AI.ArtificialChoice(), symbol);
        }
    }
    //a method that enables the Ai to move but also restrains it from making an invalid move(below)
    public  boolean validMoveAI(int pos) {

        try {

                setPosAi(pos);

                return board[setPosAi(pos)].equals(".");

        } catch (Exception e) {

        }

        return false;
    }


    // a method that allows the player(s) to choose where they want to put their
    // individual symbol but also restrains them from making an invalid choice
    public void playerMove(String choice, String symbol, String name) {

        Scanner sc = new Scanner(System.in);

        if (validMove(choice)) {
            board[setPos(choice)] = board[setPos(choice)].replace(".", symbol);
            printBoard();

        } else {
            String newChoice;

            do {
                System.out.println("That was not a valid choice, " +
                        name + " it's your turn, where do you want to set your " + symbol + "!");
                newChoice = sc.nextLine();

            } while (!validMove(newChoice));
            if (validMove(newChoice)) {
                board[setPos(newChoice)] = board[setPos(newChoice)].replace(".", symbol);
                printBoard();

            }
        }
    }


}



