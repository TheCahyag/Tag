package com.servegame.bl4de.common;

import com.servegame.bl4de.common.model.AbstractPlayer;
import com.servegame.bl4de.common.model.AbstractWorld;

import java.util.ArrayList;
import java.util.List;

/**
 * File: AbstractGameManager.java
 *
 * @author Brandon Bires-Navel (brandonnavel@outlook.com)
 */
public abstract class AbstractGameManager {

    protected List<AbstractMiniGame> runningGames;
    protected TagPlugin plugin;

    public AbstractGameManager(TagPlugin plugin) {
        this.plugin = plugin;
        this.runningGames = new ArrayList<>();
    }

    public List<AbstractMiniGame> getRunningGames() {
        return runningGames;
    }

    public abstract AbstractMiniGame createMiniGame(List<AbstractPlayer> players, AbstractWorld world);

    public void startMiniGame(AbstractMiniGame miniGame){
        if (this.runningGames.contains(miniGame)){
            miniGame.start();
        }
    }
}
