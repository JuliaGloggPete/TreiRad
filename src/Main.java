
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        Board b = new Board();

        boolean play;

        System.out.println("Hello - how about som Tic Tac Toe - Wanna play y/n?");
        String wantToPlay = sc.nextLine();


        if (wantToPlay.equals("y")) {
            play = true;
            do {
                b.printBoard();
                playerTurn();


            } while (play == true);
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
        System.out.println("Player 1 please insert your name");
        Player p1 = new Player(sc.nextLine(), "X");
        System.out.println("Player 2 please insert your name");
        Player p2 = new Player(sc.nextLine(), "O");

        //här ska den gå sålänge inta alla är infylld

        for (int i = 0; i < 101; i++) {
            if (i == 100) {
                System.out.println("given input was not valid for to many times, we start over");
                break;
            }

            if (i % 2 == 0) {

                System.out.println(p1.getName() + " it's your turn, where do you want to set your " + p1.getSymbol() + "!");
                String choice = sc.nextLine();
                b.setBoard(choice);

                String h = "X";
                if (b.validMove(choice) == true) {
                    //choice = [0, 1, 2, 3, 4, 5, 6, 7, 8]
                    // b.board[choice] = b.board[choice].replace(".", h);
                    // b.printBoard();
                    b.board[b.setPos(choice)] = b.board[b.setPos(choice)].replace(".", h);
                    b.printBoard();

                }
                if (b.checkWin(p1.getSymbol()) == true) {
                    System.out.println(p1.getName() + " you won!\n" + p2.getName() + "Get ready for a new round");
                    break;
                } else {
                    b.checkDraw(b.board);
                    if (b.checkDraw(b.board) == true) {
                        break;

                }}} else {
                    System.out.println(p2.getName() + " it's your turn, where do you want to set your " + p2.getSymbol() + "!");
                    String choice = sc.nextLine();

                    String h = "O";
                    if (b.validMove(choice) == true) {
                        b.board[b.setPos(choice)] = b.board[b.setPos(choice)].replace(".", h);
                        b.printBoard();

                    } else {
                        System.out.println("not a valid move, now you are beeing skipped and it is Player1*s turn");
                    }
                    if (b.checkWin(p2.getSymbol()) == true) {
                        System.out.println(p2.getName() + " you won!\n" + p1.getName() + " get ready for a new round");
                        break;
                    } else {
                        b.checkDraw(b.board);
                        if (b.checkDraw(b.board) == true) {
                            break;
                        }
                    }

                }
            }


        }
    }