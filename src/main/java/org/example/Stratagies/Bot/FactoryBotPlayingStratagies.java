package org.example.Stratagies.Bot;

import org.example.Model.BotDifficultLevel;

public class FactoryBotPlayingStratagies {
    public static BotPlayingStratagies getPlayingStratagies(BotDifficultLevel botDifficultLevel){
        if(botDifficultLevel.equals(BotDifficultLevel.EASY))
            return new EasyBotPlayingStragies();
        return null;
    }
}
