package org.example.Model;

import java.util.ArrayList;
import java.util.List;

public class Board {

    int dimention;
    List<List<Cell>> board = new ArrayList<>();
    public Board(int dimention){
        this.dimention = dimention;
        for(int i=0;i<dimention;i++){
            board.add(new ArrayList<>());
            for(int j=0;j<dimention;j++){
                board.get(i).add(new Cell(i,j));
            }
        }
    }

    public List<List<Cell>> getBoard() {
        return board;
    }

    public void setBoard(List<List<Cell>> board) {
        this.board = board;
    }

    public int getDimention() {
        return dimention;
    }

    public void setDimention(int dimention) {
        this.dimention = dimention;
    }
}
