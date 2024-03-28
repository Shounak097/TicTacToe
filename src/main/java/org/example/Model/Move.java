package org.example.Model;

public class Move {

    Cell cell;
    int moveNumber;


    public Move(Cell cell){
        this.cell = cell;
        moveNumber = 0;
    }
    public Move(Cell cell, int moveNumber){
        this.cell = cell;
        this.moveNumber = moveNumber;
    }


    public Cell getCell() {
        return cell;
    }

    public void setCell(Cell cell) {
        this.cell = cell;
    }

    public int getMoveNumber() {
        return moveNumber;
    }

    public void setMoveNumber(int moveNumber) {
        this.moveNumber = moveNumber;
    }
}
