package org.example.Stratagies.WiningStratagies;

import org.example.Model.*;

public class ColumnWiningStratagies implements WiningStratagies{
    @Override
    public boolean checkWinner(Board board, Move move) {
        int columnToCheck = move.getCell().getColumn();
        Player player = move.getCell().getPlayer();

        for (int i = 0; i < board.getBoard().size(); i++) {
            Cell cell = board.getBoard().get(i).get(columnToCheck);
            if (cell.getCellStatus().equals(CellStatus.EMPTY)
                    || !cell.getPlayer().equals(player)) {
                return false;
            }
        }
        return true;
    }
}
