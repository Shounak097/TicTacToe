package org.example.Service;

import org.example.Model.*;
import org.example.Stratagies.WiningStratagies.WiningStratagies;

import java.lang.*;

public class GameService {
    Game game;
    public GameService(Game game){
        this.game = game;
    }
    public void executeNextMove(){
        Player currentPlayer = game.getCurrentPlayer();
        Move move = currentPlayer.makeMove(game.getBoard());
        if(move == null){
            game.setGameState(GameState.DRAW);
            return;
        }
        game.addMove(move);
        game.updateBoard(move);

        for(int i=0;i<game.getWinningStrategies().size();i++){
            WiningStratagies winingStratagies = game.getWinningStrategies().get(i);
            if(winingStratagies.checkWinner(game.getBoard(), move)){
                game.setGameState(GameState.WIN);
                game.setWinner(currentPlayer);
                return;
            }
        }
        game.nextPlayerTurn();
    }
}
