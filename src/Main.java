
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        Board b = new Board();


        System.out.println("Hello - how about som Tic Tac Toe - Wanna play y/n?");
        String wantToPlay = sc.nextLine();
        boolean play = false;

        if (wantToPlay.equals("y")) {
            play = true;
        } else if (wantToPlay.equals("n")) {
            play = false;
            System.out.println("Ok, bye!  See you around");

        } else {
            System.out.println("Not a valid answer, here is the choices again");

        }





           do {
                b.printBoard();
                playerTurn();


            } while (play);



    }

    public static void playerTurn() {
        Scanner sc = new Scanner(System.in);
        Board b = new Board();
        for (int i = 0; i < 9; i++) {

            if (i % 2 == 0) {
                System.out.println("Player1 it's your turn, where do you want to set your X");
                String choice = sc.nextLine();

                String h= "X";
                switch (choice) {
                    case "a1":

                        b.board[0] = b.board[0].replace(".", h);
                        b.printBoard();
                        break;
                    case "a2":

                        b.board[1] = b.board[1].replace(".", h);
                        b.printBoard();
                        break;
                    case "a3":

                        b.board[2] = b.board[2].replace(".", h);
                        b.printBoard();
                        break;
                    case "b1":

                        b.board[3] = b.board[3].replace(".", h);
                        b.printBoard();
                        break;
                    case "b2":

                        b.board[4] = b.board[4].replace(".", h);
                        b.printBoard();
                        break;
                    case "b3":

                        b.board[5] = b.board[5].replace(".", h);
                        b.printBoard();
                        break;
                    case "c1":

                        b.board[6] = b.board[6].replace(".", h);
                        b.printBoard();
                        break;
                    case "c2":

                        b.board[7] = b.board[7].replace(".", h);
                        b.printBoard();
                        break;
                    case "c3":

                        b.board[8] = b.board[8].replace(".", h);
                        b.printBoard();
                        break;} b.checkWin();
            } else {
                System.out.println("Player2 it's your turn, where do you want to set your O");
                String choice = sc.nextLine();

                String h= "O";
            switch (choice) {
                case "a1":

                    b.board[0] = b.board[0].replace(".", h);
                    b.printBoard();
                    break;
                case "a2":

                    b.board[1] = b.board[1].replace(".", h);
                    b.printBoard();
                    break;
                case "a3":

                    b.board[2] = b.board[2].replace(".", h);
                    b.printBoard();
                    break;
                case "b1":

                    b.board[3] = b.board[3].replace(".", h);
                    b.printBoard();
                    break;
                case "b2":

                    b.board[4] = b.board[4].replace(".", h);
                    b.printBoard();
                    break;
                case "b3":

                    b.board[5] = b.board[5].replace(".", h);
                    b.printBoard();
                    break;
                case "c1":

                    b.board[6] = b.board[6].replace(".", h);
                    b.printBoard();
                    break;
                case "c2":

                    b.board[7] = b.board[7].replace(".", h);
                    b.printBoard();
                    break;
                case "c3":

                    b.board[8] = b.board[8].replace(".", h);
                    b.printBoard();
                    break;} b.checkWin();
            }                        

}}}