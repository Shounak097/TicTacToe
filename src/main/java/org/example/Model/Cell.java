package org.example.Model;

public class Cell {
    private int row;
    private int column;
    private CellStatus cellStatus;
    private Player player;


    public Cell(int row, int column){
        this.row = row;
        this.column = column;
        cellStatus = CellStatus.EMPTY;

    }
    public Cell(int row, int column, CellStatus cellStatus, Player player){
        this.row = row;
        this.column = column;
        this.cellStatus = cellStatus;
        this.player = player;
    }

    public Cell(Cell cell){
        this.row = cell.getRow();
        this.column = cell.getColumn();
        this.cellStatus = cell.getCellStatus();
        this.player = cell.getPlayer();
    }



    public CellStatus getCellStatus() {
        return cellStatus;
    }

    public void setCellStatus(CellStatus cellStatus) {
        this.cellStatus = cellStatus;
    }

    public Player getPlayer() {
        return player;
    }

    public void setPlayer(Player player) {
        this.player = player;
    }

    public int getColumn() {
        return column;
    }

    public void setColumn(int column) {
        this.column = column;
    }
    public int getRow() {
        return row;
    }

    public void setRow(int row) {
        this.row = row;
    }
}
