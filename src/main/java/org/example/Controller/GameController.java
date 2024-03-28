package org.example.Controller;

import org.example.Model.Game;
import org.example.Model.GameState;
import org.example.Model.Player;
import org.example.Service.BoardService;
import org.example.Service.GameService;
import org.example.Stratagies.WiningStratagies.ColumnWiningStratagies;
import org.example.Stratagies.WiningStratagies.RowWiningStratagy;

import java.util.List;

public class GameController {
    public static Game createGame(int dimension, List<Player> playerList) {
        return Game.getBuilder().setPlayers(playerList)
                .addWinningStrategy(new ColumnWiningStratagies())
                .addWinningStrategy(new RowWiningStratagy())
                .setDimension(dimension)
                .build();
    }

    public void undo() {
    }

    public void displayBoard(Game game) {
        BoardService.display(game.getBoard());
    }

    public GameState getGameStatus(Game game) {
        return game.getGameState();
    }

    public void executeNextMove(Game game) {
        GameService gameService = new GameService(game);
        gameService.executeNextMove();
    }

    public String getWinner(Game game) {
        return game.getWinner().getPlayerName();
    }
}
