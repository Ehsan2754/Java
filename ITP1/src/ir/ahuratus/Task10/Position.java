package ir.ahuratus.Task10;

public class Position implements Comparable<Position> {
    int row;
    int column;

    public Position(int row, int column) {
        this.row = row;
        this.column = column;
    }
    public int compareTo(Position p){
        if((row==p.row)&&(column==p.column))
            return 0;
        else if((row<p.row)&&(column<p.column))
            return 1;
        else
            return -1;
    }
}