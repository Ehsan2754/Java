/**********************************************************************************************
 *
 *   Ehsan Shaghaei
 *
 *  Group 03
 *
 *  Snakes V 1.04.01
 *
 *  ITP1 - Task 6 Assignment
 *
 *  14 - October - 2019
 *
 *  e.shaghaei@innopolis.university
 *
 *  EhsanShaghaei.Ahuratus.ir
 *
 *	https://github.com/Ehsan2754/Java/tree/master/ITP1/src/ir/ahuratus/Task6
 *
 */
package ir.ahuratus.Task10;

import java.io.*;
import java.util.ArrayList;
import java.util.Random;


public class Snakes {
    static int[][] maze = new int[8][8];
    static Snake snake0 = new Snake(5, 5);
    static Snake snake1 = new Snake(2, 2);
    static final String logFile = "E:\\FrontEnd_BackEnd\\Java\\ITP1\\src\\ir\\ahuratus\\Task6\\log.txt";
    static Apple ap = new Apple(new Position(-1, -1));
    static Bot   Ehsan = new Bot_E_Shaghaei();

    public static void main(String[] args) {


/*****************************************
 * Continues the game unless one of at least one of snakes are dead
 */

        while (snake1.alive && snake0.alive) {

/*************************
 * Apple appears unless it's eatten!
 */
            int ap_row, ap_column;
            while (!ap.exists) {

                ap_row = (int) (Math.random() * 8);
                ap_column = (int) (Math.random() * 8);

                boolean tof = true;

                for (int i = 0; i < snake0.positions.size(); i++) {
                    if (snake0.positions.get(i).row == ap_row && snake0.positions.get(i).column == ap_column) {
                        tof = false;
                        break;
                    }
                }
                for (int i = 0; i < snake1.positions.size(); i++) {
                    if (snake0.positions.get(i).row == ap_row && snake0.positions.get(i).column == ap_column) {
                        tof = false;
                        break;
                    }
                }

                if (tof) {
                    ap = new Apple(new Position(ap_row, ap_column));
                    ap.exists = true;
                }
            }
/**********************************
 * Screen Shown
 */

            showMaze();

/*******************************
 * Stop Condition checked
 */
            if (!motionCheck(snake1)) {
                snake1.alive = false;
                showMaze();
                System.out.println("0-1");
                appendMazeToFile(logFile, "0-1");
                return;
            }
            if (!motionCheck(snake0)) {
                snake0.alive = false;
                showMaze();
                System.out.println("1-0");
                appendMazeToFile(logFile, "1-0");
                return;
            }

            if (snake0.getHead().compareTo(snake1.getHead()) == 0) {
                showMaze();
                System.out.println("0-0");
                appendMazeToFile(logFile, "0-0");
                return;
            }

            for (int i = 1; i < snake0.positions.size(); i++) {
                if (snake1.getHead().row == snake0.positions.get(i).row &&
                        snake1.getHead().column == snake0.positions.get(i).column) {
                    showMaze();
                    System.out.println("1-0");
                    appendMazeToFile(logFile, "1-0");
                    return;
                }
            }

            for (int i = 1; i < snake1.positions.size(); i++) {
                if (snake0.getHead().row == snake1.positions.get(i).row &&
                        snake0.getHead().column == snake1.positions.get(i).column) {
                    showMaze();
                    System.out.println("0-1");
                    appendMazeToFile(logFile, "0-1");
                    return;
                }
            }


            try {
                // Thread.sleep(3);
                Thread.sleep(0);
            } catch (Exception e) {
                System.out.println("ERR : " + e.toString());
                appendMazeToFile(logFile, "ERR\n");

            }
        }

    }

    /*******************************************************************************
     * @param snake
     * @return Boolean Value if @param snake has valid move to determine the end of game
     * TRUE : No valid motion for the snake
     * False : There exists valid motions for  @param snake
     *******************************************************************************/

    private static boolean motionCheck(Snake snake) {


        Direction[] directions = {Direction.NORTH, Direction.SOUTH, Direction.WEST, Direction.EAST};
        RandomizeArray(directions);


        boolean evaluatedMove = evaluate(directions[0], snake);
        if (evaluatedMove) {
            snake.nextMove(directions[0]);
            return true;

        }

        evaluatedMove = evaluate(directions[1], snake);
        if (evaluatedMove) {
            snake.nextMove(directions[1]);
            return true;
        }

        evaluatedMove = evaluate(directions[2], snake);
        if (evaluatedMove) {
            snake.nextMove(directions[2]);
            return true;
        }
        evaluatedMove = evaluate(directions[3], snake);
        if (evaluatedMove) {
            snake.nextMove(directions[3]);
            return true;
        }
        return false;
    }

    /***************************************************************
     *
     * @param array
     * Reorders the directions array for a random move
     */
    public static void RandomizeArray(Direction[] array) {
        Random rgen = new Random();  // Random number generator

        for (int i = 0; i < array.length; i++) {
            int randomPosition = rgen.nextInt(array.length);
            Direction temp = array[i];
            array[i] = array[randomPosition];
            array[randomPosition] = temp;
        }


    }

    /***********************************
     *
     * @param move
     * @param snake
     * @return boolean flag if the managed direction will lead the snake in a true path
     */


    private static boolean evaluate(Direction move, Snake snake) {
        assert (move == Direction.NORTH) || (move == Direction.SOUTH) || (move == Direction.WEST) || (move == Direction.EAST) : "Invalid Direction @ evaluation level ";

        if (move == Direction.NORTH && (snake.getHead().row == 0 || snake.positions.get(1).row + 1 == snake.getHead().row)) {
            return false;
        } else if (move == Direction.SOUTH && (snake.getHead().row == 7 || snake.positions.get(1).row - 1 == snake.getHead().row)) {
            return false;
        } else if (move == Direction.WEST && (snake.getHead().column == 0 || snake.positions.get(1).column + 1 == snake.getHead().column)) {
            return false;
        } else if (move == Direction.EAST && (snake.getHead().column == 7 || snake.positions.get(1).column - 1 == snake.getHead().column)) {
            return false;
        } else {
            return true;
        }
    }

    /**********************************
     * prints the game screen on the console
     * #TO-DO : May gotta implement a GUI for this purpose
     */

    private static void showMaze() {
        System.out.println();
        appendMazeToFile(logFile, "\n");
        for (int r = 0; r < 8; r++) {
            for (int c = 0; c < 8; c++) {
                String output = "   ";
                if (c == ap.position.column && r == ap.position.row) output = " A ";
                if (snake1.getHead().row == r && snake1.getHead().column == c) output = " X ";

                for (int i = 1; i < snake1.positions.size(); i++) {
                    if (snake1.positions.get(i).row == r && snake1.positions.get(i).column == c) output = " 0 ";
                }

                if (snake0.getHead().row == r && snake0.getHead().column == c) output = " Y ";
                for (int i = 1; i < snake0.positions.size(); i++) {
                    if (snake0.positions.get(i).row == r && snake0.positions.get(i).column == c) output = " 1 ";
                }

                if (output != " A " && output != " 0 " && output != " 1 " && output != " X " && output != " Y ")
                    output = " . ";

                System.out.print(output);
                appendMazeToFile(logFile, String.valueOf(output));
            }
            System.out.println();
            appendMazeToFile(logFile, "\n");
        }

    }

    /*************
     *
     * @param filePath
     * @param data
     * methode to append a string to a file
     */

    private static void appendMazeToFile(String filePath, String data) {
//        try {
//
//
//            File file = new File(filePath);
//            if (!file.exists())
//                file.createNewFile();
//            FileWriter fr = new FileWriter(file, true);
//            BufferedWriter br = new BufferedWriter(fr);
//            PrintWriter pr = new PrintWriter(br);
//            pr.print(data);
//            pr.close();
//            br.close();
//            fr.close();
//
//        } catch (Exception ex) {
//            System.out.println("File ERR!" + ex.toString());
//        }
//
    }
}



