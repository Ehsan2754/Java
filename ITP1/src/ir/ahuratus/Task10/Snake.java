package ir.ahuratus.Task10;

import java.util.ArrayList;

public class Snake {
    boolean alive = true;
    public int move ;
    ArrayList<Position> positions = new ArrayList<>();

    /*************************************
     *
     * @param row
     * @param column
     * creates and initializes an snake with at least length 3
     */
    public Snake(int row, int column) {
        this.move = 0;
        this.alive = true;
        positions.add(new Position(row, column));
        positions.add(new Position(row, column - 1));
        positions.add(new Position(row, column - 2));
    }

    /********
     *
     * @return (s) head position
     */
    public Position getHead() {
//        return new Position(this.positions.get(0).row, this.positions.get(0).column);
        return positions.get(0);
    }

    /**************
     *
     * @param direction
     * updates and moves the snake positions accroding to @param direction
     *
     * ************/
    public void nextMove(Direction direction) {
        switch (direction) {
            case WEST:
                this.positions.add(0, new Position(this.positions.get(0).row,this.positions.get(0).column-1));
                break;

            case NORTH:
                this.positions.add(0, new Position(this.positions.get(0).row-1,this.positions.get(0).column));
                break;

            case SOUTH:
                this.positions.add(0, new Position(this.positions.get(0).row+1,this.positions.get(0).column));
                break;

            case EAST:
                this.positions.add(0, new Position(this.positions.get(0).row,this.positions.get(0).column+1));
                break;
        }

        this.positions.remove(this.positions.size() - 1);
    }

    /**********************
     *
     *
     * @param direction
     * adds one unit to the lenght of the Snake
     ********************/
    public void addLength(Direction direction) {
        switch (direction) {
            case WEST:
                this.positions.add(0, new Position(this.positions.get(0).row,this.positions.get(0).column-1));
                break;

            case NORTH:
                this.positions.add(0, new Position(this.positions.get(0).row-1,this.positions.get(0).column));
                break;

            case SOUTH:
                this.positions.add(0, new Position(this.positions.get(0).row+1,this.positions.get(0).column));
                break;

            case EAST:
                this.positions.add(0, new Position(this.positions.get(0).row,this.positions.get(0).column+1));
                break;
        }


    }
}