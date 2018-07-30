package com.servegame.bl4de.common;

import com.servegame.bl4de.common.model.AbstractPlayer;
import com.servegame.bl4de.common.model.AbstractWorld;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.concurrent.ConcurrentHashMap;

/**
 * File: AbstractGameManager.java
 *
 * @author Brandon Bires-Navel (brandonnavel@outlook.com)
 */
public abstract class AbstractGameManager {

    protected ConcurrentHashMap<String, AbstractMiniGame> runningGames;
    protected TagPlugin plugin;

    public AbstractGameManager(TagPlugin plugin) {
        this.plugin = plugin;
        this.runningGames = new ConcurrentHashMap<>();
    }

    public List<AbstractMiniGame> getRunningGames() {
        return new ArrayList<>(runningGames.values());
    }

    public abstract AbstractMiniGame createMiniGame(String name, AbstractWorld world);

    public void startMiniGame(AbstractMiniGame miniGame){
        if (this.runningGames.contains(miniGame)){
            miniGame.start();
        }
    }

    /**
     * Determines if the given {@link AbstractPlayer} is currently involved in a game as a non-spectator.
     * @param player given {@link AbstractPlayer}
     * @return true if the player is already in a game, false otherwise
     */
    protected boolean isPlayerCurrentlyInGame(AbstractPlayer player) {
        Collection<AbstractMiniGame> miniGames = this.runningGames.values();
        for (AbstractMiniGame miniGame :
                miniGames) {
            if (miniGame.hasPlayer(player)) {
                return true;
            }
        }
        return false;
    }
}
