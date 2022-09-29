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
        this.symbol= symbol;


        if (board[0].equals(symbol) && board[1].equals(symbol) && board[2].equals(symbol)) {
            return true;
        }
        if (board[3].equals(symbol) && board[4].equals(symbol) && board[5].equals(symbol)){
            return true;
        }
        if (board[6].equals(symbol) && board[7].equals(symbol) && board[8].equals(symbol)){
            return true;
        }
        if (board[0].equals(symbol) && board[3].equals(symbol) && board[6].equals(symbol)){
            return true;
        }
        if (board[1].equals(symbol) && board[4].equals(symbol) && board[7].equals(symbol)){
            return true;
        }
        if (board[2].equals(symbol) && board[5].equals(symbol) && board[8].equals(symbol))
        {
            return true;
        }
        if (board[0].equals(symbol) && board[4].equals(symbol) && board[8].equals(symbol)) {
            return true;
        }
        if (board[2].equals("X") && board[4].equals("X") && board[6].equals("X")) {
            return true;
        }

        return false;
    }
    public boolean validMove(String pos){

        this.pos= pos;

        switch (pos) {
            case "a1":
                if (board[0] == ".") {return true;
                }else {return false;}

            case "a2":

                if (board[1] == "."){return true;
                }else {return false;}
            case "a3":

                if (board[2] == "."){return true;
                } else {return false;}
            case "b1":
                if (board[3] == "."){return true;
                }else {return false;}
            case "b2":

                if (board[4] == "."){return true;
                } else {return false;}
            case "b3":

                if (board[5] == "."){return true;
                } else {return false;}

            case "c1":

                if (board[6] == "."){return true;
                } else {return false;}
            case "c2":

                if (board[7] == "."){return true;
                } else {return false;}
            case "c3":
                if (board[8] == "."){return true;
                } else {return false;}
            default:
                System.out.println("not a valid choice");
        }return true;
    }
}