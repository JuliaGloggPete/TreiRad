
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        Board b = new Board();

        boolean play = false;
        System.out.println("Hello - how about som Tic Tac Toe - Wanna play y/n?");
        String wantToPlay = sc.nextLine();


        if (wantToPlay.equals("y")) {
            play = true;
            do {
                b.printBoard();
                playerTurn();




            } while (play== true);
        } else if (wantToPlay.equals("n")) {
            play = false;
            System.out.println("Ok, bye!  See you around");

        } else {
            System.out.println("Not a valid answer, here is the choices again: Want to play? Please answer with y for yes and n for no y/n");

        }









    }

    public static void playerTurn() {
        Scanner sc = new Scanner(System.in);
        Board b = new Board();

        //här ska den gå sålänge inta alla är infylld


        for (int i = 0; i < 19; i++) {

            if (i % 2 == 0) {
                System.out.println("Player1 it's your turn, where do you want to set your X");
                String choice = sc.nextLine();


                String h = "X";
                if (b.validMove(choice) == true) {
                    //   choice = [0, 1, 2, 3, 4, 5, 6, 7, 8]
                    // b.board[choice] = b.board[choice].replace(".", h);
                   // b.printBoard();
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
                            break;
                    }}
                  else {
                    System.out.println("not a valid move, now you are beeing skipped and it is player2 turn");
                }   if (b.checkWin("X") == true) {
                        System.out.println("Player 1 you won!\n Get ready for a new round");
                        break;
                    } else {b.checkDraw(b.board); if (b.checkDraw(b.board)==true) {break;
                    }}

            } else {
                System.out.println("Player2 it's your turn, where do you want to set your O");
                String choice = sc.nextLine();

                String h = "O";
                if (b.validMove(choice) == true) {
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
                            break;
                    }

                } else {
                    System.out.println("not a valid move, now you are beeing skipped and it is Player1*s turn");
                }
                if (b.checkWin("O") == true) {
                    System.out.println("Player 2 you won!\n Get ready for a new round");
                    break;
                }
                else {b.checkDraw(b.board);if (b.checkDraw(b.board)==true) {break;
                }

               }

            }
        }


    }}