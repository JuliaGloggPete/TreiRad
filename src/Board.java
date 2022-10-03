import java.util.Arrays;

public class Board {

    String[] board = {".", ".", ".", ".", ".", ".", ".", ".", "."};
    String pos;
    String symbol;
    Player player;

    public Board() {
        this.board = board;
    }

    public void printBoard() {
        this.board = board;

        System.out.println("   1   2   3\n" + "a  " + board[0] + " | " + board[1] + " | " + board[2] + "\n" +
                "  ---+---+---\n" + "b  " + board[3] + " | " + board[4] + " | " + board[5] + "\n" +
                "  ---+---+---\n" + "c  " + board[6] + " | " + board[7] + " | " + board[8] + "\n");

    }


    public boolean checkWin(String symbol) {
        this.symbol = symbol;


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


    public int setPos(String pos) {

        this.pos = pos;

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

            default:
                System.out.println("not a valid choice");

        }


        return Integer.parseInt(null);
    }

    public boolean validMove(String pos) {

        this.pos = pos;
        setPos(pos);

        return board[setPos(pos)].equals(".");
    }


    public boolean checkDraw(String[] board) {

        //this only runs if win== false

        if (Arrays.asList((board)).contains(".")) {

            return false;
        } else {
            System.out.println("DRWAAAAAWWWW no one won!");
            return true;
        }


    }

}



