package org.example.Stratagies.Bot;

import org.example.Model.Board;
import org.example.Model.Move;

public interface BotPlayingStratagies {
    public Move suggestMove(Board board);
}
