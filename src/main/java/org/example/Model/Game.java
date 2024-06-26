package org.example.Model;

import org.example.Stratagies.WiningStratagies.WiningStratagies;

import java.util.ArrayList;
import java.util.List;
public class Game {
    Board board;
    List<Player> players;
    List<Move> moves;
    int currentPlayerIndex;
    GameState gameState;
    Player winner;
    List<WiningStratagies> winningStrategies;

    private Game(int dimension, List<Player> players, List<WiningStratagies> winningStrategies) {
        this.players = players;
        this.winningStrategies = winningStrategies;
        this.board = new Board(dimension);
        this.moves = new ArrayList<>();
        this.currentPlayerIndex = 0;
        this.gameState = GameState.INPROGRESS;
    }

    public static Builder getBuilder() {
        return new Builder();
    }

    public static class Builder {
        List<Player> players;
        List<WiningStratagies> winningStrategies;
        int dimension;

        private Builder() {
            this.players = new ArrayList<>();
            this.winningStrategies = new ArrayList<>();
            this.dimension = 0;
        }

        public Builder setPlayers(List<Player> players) {
            this.players = players;
            return this;
        }
        public Builder setWinningStrategies(List<WiningStratagies> winningStrategies) {
            this.winningStrategies = winningStrategies;
            return this;
        }
        public Builder setDimension(int dimension) {
            this.dimension = dimension;
            return this;
        }

        public Builder addPlayer(Player player) {
            this.players.add(player);
            return this;
        }

        public Builder addWinningStrategy(WiningStratagies winningStrategy) {
            this.winningStrategies.add(winningStrategy);
            return this;
        }

        public Game build() {

            // TODO: validations here.
            // TODO: Add excepions here.

            return new Game(dimension, players, winningStrategies);

        }

    }

    public Board getBoard() {
        return board;
    }

    public GameState getGameState() {
        return gameState;
    }

    public Player getCurrentPlayer() {
        return players.get(currentPlayerIndex);
    }

    public void addMove(Move move) {
        moves.add(move);
    }

    public List<WiningStratagies> getWinningStrategies() {
        return winningStrategies;
    }

    public void setWinner(Player winner) {
        this.winner = winner;
    }

    public void setGameState(GameState gameState) {
        this.gameState = gameState;
    }

    public void nextPlayerTurn() {
        currentPlayerIndex = (currentPlayerIndex + 1) % players.size();
    }

    public void updateBoard(Move move) {
        // Update the board with the move taken.
        int row = move.getCell().getRow();
        int col = move.getCell().getColumn();

        // Updating the cell in the board with the move that player took.
        this.board.getBoard().get(row).set(col, move.getCell());
    }

    public Player getWinner() {
        return winner;
    }
}
