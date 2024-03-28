package org.example.Model;

import java.util.Scanner;

public class Player {
    PlayerType playerType;
    char symbol;
    String playerName;
    int id;
    Scanner scanner;

    public Player(PlayerType playerType, char symbol, int id, String playerName, Scanner scanner){
        this.playerName = playerName;
        this.playerType = playerType;
        this.symbol = symbol;
        this.scanner = scanner;
        this.id = id;
    }

    private static boolean cellAvailable(Board board) {
        for (int i = 0; i < board.getBoard().size(); i++) {
            for (int j = 0; j < board.getBoard().size(); j++) {
                if (board.getBoard().get(i).get(j).getCellStatus().equals(CellStatus.EMPTY)) {
                    return true;
                }
            }
        }
        return false;

    }

    // TODO: Simplify the makeMove method.
    public Move makeMove(Board board) {
        if (!cellAvailable(board)) {
            return null;
        }
        System.out.println("Enter the row and column where you want to play the move.");

        int row = scanner.nextInt();
        int col = scanner.nextInt();

        // board.getBoard().get(row).get(col) --> get the cell from the board
        // Update the cell -> board ends up getting updated.

        Cell cell = new Cell(board.getBoard().get(row).get(col));

        System.out.printf("The player %s is making a move at cell: %d, %d\n",
                this.playerName, cell.getRow(), cell.getColumn());
        if (cell.getCellStatus().equals(CellStatus.OCCUPIED)) {
            throw new IllegalArgumentException("The cell is occupied.");
        }

        cell.setPlayer(this);
        cell.setCellStatus(CellStatus.OCCUPIED);
        return new Move(cell);
    }

    public PlayerType getPlayerType() {
        return playerType;
    }

    public void setPlayerType(PlayerType playerType) {
        this.playerType = playerType;
    }

    public char getSymbol() {
        return symbol;
    }

    public void setSymbol(char symbol) {
        this.symbol = symbol;
    }

    public String getPlayerName() {
        return playerName;
    }

    public void setPlayerName(String playerName) {
        this.playerName = playerName;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Scanner getScanner() {
        return scanner;
    }

    public void setScanner(Scanner scanner) {
        this.scanner = scanner;
    }



}
