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
package ir.ahuratus.Task6;

import javax.swing.*;
import java.awt.*;
import java.awt.image.ImageObserver;
import java.io.*;
import java.nio.*;
import java.nio.file.Files;
import java.nio.file.OpenOption;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;
import java.text.AttributedCharacterIterator;
import java.util.*;
import java.util.concurrent.ThreadLocalRandom;
import java.awt.*;
import javax.swing.*;
import java.applet.*;
import static ir.ahuratus.task4.CauseProblem.g;


public class Snakes {
    static int[][] maze = new int[8][8];
    static Snake snake0 = new Snake(5, 5);
    static Snake snake1 = new Snake(2, 2);
    public static final int pixelSize = 100;

    static final String logFile = "E:\\FrontEnd_BackEnd\\Java\\ITP1\\src\\ir\\ahuratus\\Task6\\log.txt";


    public static void main(String[] args) {
        // TODO Implement the stop criteria





        try {
            Gui gui = new Gui(8,8 , pixelSize);
            gui.showPixel(4,4,Color.BLUE,null);

        }
        catch (Throwable tr) {
            System.out.println("ERR : "+tr.toString());
        }








        while(snake1.alive && snake0.alive) {
            showMaze();

            
            if(!motionCheck(snake1)) {
                snake1.alive = false;
                showMaze();
                System.out.println("0-1");
                appendMazeToFile(logFile,"0-1");
                return;
            }
           
            for(int i = 0; i < snake0.positions.size(); i++) {
                if(snake1.getHead().row == snake0.positions.get(i).row && 
							snake1.getHead().column == snake0.positions.get(i).column) {
                    showMaze();
                    System.out.println("0-0");
                    appendMazeToFile(logFile,"0-0");
                    return;
                }
            }

            
            if(!motionCheck(snake0)) {
                snake0.alive = false;
                showMaze();
                System.out.println("1-0");
                appendMazeToFile(logFile,"1-0");
                return;
            }
            
            for(int i = 0; i < snake1.positions.size(); i++) {
                if(snake0.getHead().row == snake1.positions.get(i).row &&
                             snake0.getHead().column == snake1.positions.get(i).column) {
                    showMaze();

                    System.out.println("0-0");
                    appendMazeToFile(logFile,"0-0");
                    return;
                }
            }

            try {
              // Thread.sleep(3);
                Thread.sleep(3000);
            } catch (Exception e) {
                System.out.println("ERR : "+e.toString());
                appendMazeToFile(logFile,"ERR\n");

            }
        }

    }


    private static boolean motionCheck(Snake snake) {
        boolean FLG = false;


        String blocked_position = "";
        for(int i = 0; i < snake.positions.size() - 1; i++) {
            int row = snake.getHead().row;
            int column = snake.getHead().column;

            if(row == snake.positions.get(1).row - 1) blocked_position = "S";
            if(row == snake.positions.get(1).row + 1) blocked_position = "N";
            if(column == snake.positions.get(1).column - 1) blocked_position = "E";
            if(column == snake.positions.get(1).column + 1) blocked_position = "W";
        }

        String[] directions = {"N", "S", "W", "E"};
        RandomizeArray(directions);

        boolean evaluatedMove = evaluate(directions[0], snake);
        if(evaluatedMove && !blocked_position.equals(directions[0])) {
            FLG = true;
            if (snake.move == 3 ){
                snake.move = 0;
                snake.addLength(directions[0]);
            }
            else{
            snake.nextMove(directions[0]);
            snake.move++;
            }

        }

        evaluatedMove = evaluate(directions[1], snake);
        if(!FLG && evaluatedMove &&
                !blocked_position.equals(directions[1])) {
            FLG = true;
            snake.nextMove(directions[1]);
        }

        evaluatedMove = evaluate(directions[2], snake);
        if(!FLG && evaluatedMove &&
                !blocked_position.equals(directions[2])) {
            FLG = true;
            snake.nextMove(directions[2]);
        }

        evaluatedMove = evaluate(directions[3], snake);
        if(!FLG && evaluatedMove && !blocked_position.equals(directions[3])) {
            FLG = true;
            snake.nextMove(directions[3]);
        }

        if (FLG) return true;
        return false;
    }
    public static void RandomizeArray(String[] array){
        Random rgen = new Random();  // Random number generator

        for (int i=0; i<array.length; i++) {
            int randomPosition = rgen.nextInt(array.length);
            String  temp = array[i];
            array[i] = array[randomPosition];
            array[randomPosition] = temp;
        }


    }



    private static boolean evaluate (String move, Snake snake) {
        assert move.equalsIgnoreCase("N") || move.equalsIgnoreCase("S") || move.equalsIgnoreCase("W") || move.equalsIgnoreCase("E") : "The input (move) should be in {N, S, W, E}.";

        if (move.equalsIgnoreCase("N") && snake.getHead().row == 0) {
            return false;
        } else if (move.equalsIgnoreCase("S") && snake.getHead().row == 7) {
            return false;
        } else if (move.equalsIgnoreCase("W") && snake.getHead().column == 0) {
            return false;
        } else {
            return !move.equalsIgnoreCase("E") || snake.getHead().column != 7;
        }
    }


    private static void showMaze() {
        System.out.println();
        appendMazeToFile(logFile,"\n");
        for(int r = 0; r < maze.length; ++r) {
            for(int c = 0; c < maze[r].length; ++c) {
                char output = ' ';
                if(snake1.getHead().row == r && snake1.getHead().column == c) output = 'X';

                for(int i = 1; i < snake1.positions.size(); i++) {
                    if(snake1.positions.get(i).row == r && snake1.positions.get(i).column == c) output = '0';
                }

                if(snake0.getHead().row == r && snake0.getHead().column == c) output = 'Y';
                for(int i = 1; i < snake0.positions.size(); i++) {
                    if(snake0.positions.get(i).row == r && snake0.positions.get(i).column == c) output = '1';
                }

                if(output != '0' && output != '1' && output != 'X' && output != 'Y') output = '.';

                System.out.print(output);
                appendMazeToFile(logFile,String.valueOf(output));
            }
            System.out.println();
            appendMazeToFile(logFile,"\n");
        }

    }



    private static void appendMazeToFile(String filePath,String data) {
        try {


            File file = new File(filePath);
            if (!file.exists())
                    file.createNewFile();
            FileWriter fr = new FileWriter(file, true);
            BufferedWriter br = new BufferedWriter(fr);
            PrintWriter pr = new PrintWriter(br);
            pr.print(data);
            pr.close();
            br.close();
            fr.close();

        } catch (Exception ex) {
            System.out.println("File ERR!"+ex.toString());
        }

    }
}

class Snake {
    boolean alive = true;
    public int move ;
    ArrayList<Position> positions = new ArrayList<>();

    public Snake(int row, int column) {
        this.move = 0;
        this.alive = true;
        positions.add(new Position(row, column));
        positions.add(new Position(row, column + 1));
        positions.add(new Position(row, column + 2));
    }

    public Position getHead() {
        return new Position(this.positions.get(0).row, this.positions.get(0).column);
    }

    public void nextMove(String direction) {
        switch (direction) {
            case "W":
                this.positions.add(0, new Position(this.getHead().row, --this.getHead().column));
                break;

            case "N":
                this.positions.add(0, new Position(--this.getHead().row, this.getHead().column));
                break;

            case "S":
                this.positions.add(0, new Position(++this.getHead().row, this.getHead().column));
                break;

            case "E":
                this.positions.add(0, new Position(this.getHead().row, ++this.getHead().column));
                break;
        }

        this.positions.remove(this.positions.size() - 1);
    }
    public void addLength(String direction) {
        switch (direction) {
            case "W":
                this.positions.add(0, new Position(this.getHead().row, --this.getHead().column));
                break;

            case "N":
                this.positions.add(0, new Position(--this.getHead().row, this.getHead().column));
                break;

            case "S":
                this.positions.add(0, new Position(++this.getHead().row, this.getHead().column));
                break;

            case "E":
                this.positions.add(0, new Position(this.getHead().row, ++this.getHead().column));
                break;
        }


    }
}

class Position {
    int row;
    int column;

    public Position(int row, int column) {
        this.row = row;
        this.column = column;
    }
}
class Gui extends JFrame{
    //private Graphics g;
    public static  int pixelSize = 25;

    public Gui(int Row, int Colomn , int pixelSize){
        setTitle("Snakes by Ehsan Shaghaei");
        setBackground(Color.GREEN);
        setSize(Colomn*pixelSize,Row*pixelSize);
        setVisible(true);

        setDefaultCloseOperation(EXIT_ON_CLOSE);
        this.pixelSize = pixelSize;
    }
    public void showPixel(int x,int y,Color color,Graphics g)throws Exception , IOException,Throwable{

        assert 0<x && x<7 && y<7 && y>0 : "Invalid Pixel";
        setTitle("Snakes by Ehsan Shaghaei");
        setBackground(Color.GREEN);
        setSize(8*pixelSize,8*pixelSize);
        setVisible(true);

        setDefaultCloseOperation(EXIT_ON_CLOSE);
        this.pixelSize = pixelSize;
        g.setColor(color);
        g.fillRect(x*pixelSize,y*pixelSize,pixelSize,pixelSize);
    }

}