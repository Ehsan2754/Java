package ir.ahuratus.Task5;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;
import java.util.ArrayList;
import java.util.Scanner;

public class Snakes {

	static int[][] maze = new int[6][6];
	static Snake snake0 = new Snake(0, 2);
	static Snake snake1 = new Snake(5, 3);
	static final String logFile = "snakes/output.txt";

	public static void main(String[] args) {
		// TODO Implement the stop criteria
		while (snake0.alive && snake1.alive) {
			showMaze();
			appendMazeToFile(logFile);
			Scanner scanner = new Scanner(System.in);
			String inputString = scanner.nextLine();
			String[] moves = inputString.split(" ");
			// TODO I need to check if moves[] has two positions
			// System.out.println(moves[0]); // snake 0
			boolean validMove0 = validateMove(moves[0], snake0);

			if (validMove0) {
				if (moves[0].equalsIgnoreCase("N"))
					snake0.head.row--;
				if (moves[0].equalsIgnoreCase("S"))
					snake0.head.row++;
				if (moves[0].equalsIgnoreCase("W"))
					snake0.head.column--;
				if (moves[0].equalsIgnoreCase("E"))
					snake0.head.column++;
			}
			else {
				snake0.alive = false;
			}
			// System.out.println(moves[1]); // snake 1
			boolean validMove1 = validateMove(moves[0], snake1);
			// TODO update the position of the head of the snake 1

			// TODO Print and log the moves and an indicator if each was legal
			/**
			 * For the future: when a snake takes an apple, the position of the apple
			 * becomes the new head position.
			 */
		}
		// TODO Print and log the result of the game (1-0, 0-0, 0-1)
	}

	private static boolean validateMove(String move, Snake snake) {
		assert move.equalsIgnoreCase("N") || move.equalsIgnoreCase("S") || move.equalsIgnoreCase("W")
				|| move.equalsIgnoreCase("E") : "The input (move) should be in {N, S, W, E}.";
		// TODO Add here rules about going off the board and colliding to another snake.
		if (move.equalsIgnoreCase("N") && snake.head.row == 0)
			return false;
		if (move.equalsIgnoreCase("S") && snake.head.row == 5)
			return false;
		if (move.equalsIgnoreCase("W") && snake.head.column == 0)
			return false;
		if (move.equalsIgnoreCase("E") && snake.head.column == 5)
			return false;
		return true;
	}

	private static void showMaze() {
		for (int r = 0; r < maze.length; r++) {
			for (int c = 0; c < maze[r].length; c++) {
				if (snake0.head.row == r && snake0.head.column == c)
					System.out.print("0");
				else if (snake1.head.row == r && snake1.head.column == c)
					System.out.print("1");
				else
					System.out.print(".");
			}
			System.out.println();
		}
	}

	private static void appendTextToFile(String file, String text) {
		// TODO To be implemented
	}

	private static void appendMazeToFile(String file) {
		try (FileWriter fw = new FileWriter(file, true);
				BufferedWriter bw = new BufferedWriter(fw);
				PrintWriter out = new PrintWriter(bw)) {
			for (int r = 0; r < maze.length; r++) {
				for (int c = 0; c < maze[r].length; c++) {
					Files.write(Paths.get(logFile), ".".getBytes(), StandardOpenOption.APPEND);
				}
				Files.write(Paths.get(logFile), "\n".getBytes(), StandardOpenOption.APPEND);
			}
		} catch (IOException e) {
			// TODO Exception handling left as an exercise
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

class Snake {
	boolean alive = true;
	ArrayList<Position> positions;
	Position head;

	/**
	 * Constructor
	 * 
	 * @param row    Row of the head
	 * @param column Column of the head
	 */
	public Snake(int row, int column) {
		alive = true;
		head = new Position(row, column);
	}

	public Position getHead() {
		return head;
	}
}