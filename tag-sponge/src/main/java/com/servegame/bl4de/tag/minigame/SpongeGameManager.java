package com.servegame.bl4de.tag.minigame;

import com.servegame.bl4de.common.AbstractGameManager;
import com.servegame.bl4de.common.AbstractMiniGame;
import com.servegame.bl4de.common.TagPlugin;
import com.servegame.bl4de.common.model.AbstractPlayer;
import com.servegame.bl4de.common.model.AbstractWorld;

import java.util.List;

/**
 * File: SpongeGameManager.java
 *
 * @author Brandon Bires-Navel (brandonnavel@outlook.com)
 */
public class SpongeGameManager extends AbstractGameManager {

    public SpongeGameManager(TagPlugin plugin){
        super(plugin);
    }

    @Override
    public AbstractMiniGame createMiniGame(List<AbstractPlayer> players, AbstractWorld world) {
        SpongeMiniGame miniGame = new SpongeMiniGame(players, world, null);
        this.runningGames.add(miniGame);
        System.out.println("A game has been created in sponge");
        return miniGame;
    }
}
