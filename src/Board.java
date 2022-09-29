public class Board  {

    String[] board= {".",".",".",".",".",".",".",".","."};

    Player player;
    public Board() {
        this.board =board;



    }

    public void printBoard(){
        this.board =board;

        System.out.println("   1   2   3\n"+"a  "+board[0]+" | "+board[1]+" | "+board[2]+"\n"+
                "  ---+---+---\n"+"b  "+board[3]+" | "+board[4]+" | "+board[5]+"\n"+
                "  ---+---+---\n"+"c  "+board[6]+" | "+board[7]+" | "+board[8]+"\n");

    }

    public String []getBoard() {
        return board;
    }

    public void setBoard() {
        this.board = board;

    }

    public boolean checkWin(){
        this.player=player;
        String h;

        if (board[0].equals("X")&&board[1].equals("X")&&board[2].equals("X")) {
            System.out.println("Player1 you won");
        }
        if (board[3].equals("X")&&board[4].equals("X")&&board[5].equals("X")) {
            System.out.println("Player1 you won");
        }
        if (board[6].equals("X")&&board[7].equals("X")&&board[8].equals("X")) {
            System.out.println("Player1 you won");
        }
        if (board[0].equals("X")&&board[3].equals("X")&&board[6].equals("X")) {
            System.out.println("Player1 you won");
        }
        if (board[1].equals("X")&&board[4].equals("X")&&board[7].equals("X")) {
            System.out.println("Player1 you won");
        }
        if (board[2].equals("X")&&board[5].equals("X")&&board[8].equals("X")) {
            System.out.println("Player1 you won");
        }
        if (board[0].equals("X")&&board[4].equals("X")&&board[8].equals("X")) {
            System.out.println("Player1 you won");
        }
        if (board[2].equals("X")&&board[4].equals("X")&&board[6].equals("X")) {
            System.out.println("Player1 you won");
        }

return true;
    }

}
