package org.example.Model;

import org.example.Stratagies.Bot.BotPlayingStratagies;
import org.example.Stratagies.Bot.FactoryBotPlayingStratagies;

import java.util.Scanner;

public class Bot extends Player{
    public Bot(String name, char symbol, int id,
               BotDifficultLevel botDifficultyLevel, Scanner scanner) {
        super(PlayerType.BOT, symbol, id, name ,scanner);
        this.botDifficultyLevel = botDifficultyLevel;
        this.botPlayingStrategy = FactoryBotPlayingStratagies.getPlayingStratagies(botDifficultyLevel);
    }
    BotDifficultLevel botDifficultyLevel;
    BotPlayingStratagies botPlayingStrategy;



    @Override
    public Move makeMove(Board board) {

        Move move = botPlayingStrategy.suggestMove(board);

        // NPE Check
        if (move == null) {
            return null;
        }

        System.out.printf("the bot is making a move %d %d.\n", move.getCell().getRow(), move.getCell().getColumn());

        move.getCell().setPlayer(this);
        move.getCell().setCellStatus(CellStatus.OCCUPIED);

        return move;
    }
}
