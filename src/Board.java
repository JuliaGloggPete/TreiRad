import java.util.Arrays;

public class Board {

    String[] board = {".", ".", ".", ".", ".", ".", ".", ".", "."};

    Player player;
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

    public String[] getBoard() {
        return board;
    }

    public void setBoard() {
        this.board = board;

    }

    public boolean checkWin(String symbol) {
        this.player = player;
        this.symbol = symbol;


        if (board[0].equals(symbol) && board[1].equals(symbol) && board[2].equals(symbol)) {
            return true;
        }
        if (board[3].equals(symbol) && board[4].equals(symbol) && board[5].equals(symbol)) {
            return true;
        }
        if (board[6].equals(symbol) && board[7].equals(symbol) && board[8].equals(symbol)) {
            return true;
        }
        if (board[0].equals(symbol) && board[3].equals(symbol) && board[6].equals(symbol)) {
            return true;
        }
        if (board[1].equals(symbol) && board[4].equals(symbol) && board[7].equals(symbol)) {
            return true;
        }
        if (board[2].equals(symbol) && board[5].equals(symbol) && board[8].equals(symbol)) {
            return true;
        }
        if (board[0].equals(symbol) && board[4].equals(symbol) && board[8].equals(symbol)) {
            return true;
        }
        if (board[6].equals(symbol) && board[4].equals(symbol) && board[2].equals(symbol)) {
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

    public String setBoard(String pos) {


        this.pos = pos;

        switch (pos) {
            case "a1":
                return board[0];


            case "a2":
                return board[1];
            case "a3":

                return board[2];
            case "b1":
                return board[3];

            case "b2":
                return board[4];
            case "b3":
                return board[5];

            case "c1":
                return board[6];
            case "c2":
                return board[7];
            case "c3":
                return board[8];

            default:
                System.out.println("not a valid choice");
        }
        return board[8];
    }

    public boolean validMove(String pos) {

        this.pos = pos;

        switch (pos) {
            case "a1":
                if (board[0] == ".") {
                    return true;
                } else {
                    return false;
                }

            case "a2":

                if (board[1] == ".") {
                    return true;
                } else {
                    return false;
                }
            case "a3":

                if (board[2] == ".") {
                    return true;
                } else {
                    return false;
                }
            case "b1":
                if (board[3] == ".") {
                    return true;
                } else {
                    return false;
                }
            case "b2":

                if (board[4] == ".") {
                    return true;
                } else {
                    return false;
                }
            case "b3":

                if (board[5] == ".") {
                    return true;
                } else {
                    return false;
                }

            case "c1":

                if (board[6] == ".") {
                    return true;
                } else {
                    return false;
                }
            case "c2":

                if (board[7] == ".") {
                    return true;
                } else {
                    return false;
                }
            case "c3":
                if (board[8] == ".") {
                    return true;
                } else {
                    return false;
                }
            default:
                System.out.println("not a valid choice");
        }
        return true;
    }


    public boolean checkDraw(String[] board) {

        //this only runs if win== false
        this.board = board;

        //horizontellt
        //rad1 = [1, 2, 3]
        //rad2 = [4, 5, 6]
        //rad3 = [0, 0, 0]

        //vertikalt
        //column1 = [0, 0, 0]
        //column1 = [0, 0, 0]
        //column1 = [0, 0, 0]

        //diagonala
        //diagonal1 = [0, 0, 0]
        //digaonal2 = [0, 0, 0]

//      String[] draw1 = {"O", "X", "O", "X", "O", "O", "X", "O", "X"};
//      String[] draw2 = {"X", "O", "X", "O", "X", "X", "O", "X", "O"};
        if (Arrays.asList((board)).contains(".")) {

            return false;
        } else {
            System.out.println("DRWAAAAAWWWW no one won!");
            return true;
        }


        //for (int i = 0; i < board.length-1; i++) {
        //  String checkBoard = board[i+1];

        //maybe check hur många ggr "." förekommer och är det 0 så byebye
        //annars kolla av om varje position && && && ".".... but that seems kind of a lot code for a litle funktion
        //if (!checkBoard.equals(".")) {


    }

}



