import java.nio.channels.ScatteringByteChannel;
import java.util.Arrays;

public class Board {

    String[] board = {".", ".", ".", ".", ".", ".", ".", ".", "."};
    String pos;
    String symbol;

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


 /*   public int setPos(String pos) {

        this.pos = pos;
try{
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
        }} catch (Exception e){
    System.out.println("not a vlid move");
}

// här behöver jag felhanteringen

        return 9;
    }
//    public ArrayIndexOutOfBoundsException(int index) {
  //      super("Array index out of range: " + index);
   // }
//} */



    public boolean checkDraw(String[] board) {

        //this only runs if win== false

        if (Arrays.asList((board)).contains(".")) {

            return false;
        } else {
            System.out.println("Its a tie!! No one won!");
            return true;
        }


    }

}



