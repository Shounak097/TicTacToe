package org.example.Stratagies.Bot;

import org.example.Model.Board;
import org.example.Model.CellStatus;
import org.example.Model.Move;

public class EasyBotPlayingStragies implements BotPlayingStratagies{

    @Override
    public Move suggestMove(Board board) {
        for (int i = 0; i < board.getDimention(); i++) {
            for (int j = 0; j < board.getDimention(); j++) {
                if (board.getBoard().get(i).get(j).getCellStatus().equals(CellStatus.EMPTY)) {
                    return new Move(board.getBoard().get(i).get(j));
                }
            }
        }
        return null;
    }
}
