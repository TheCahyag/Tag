package com.servegame.bl4de.common;

import com.servegame.bl4de.common.model.Player;
import com.servegame.bl4de.common.model.World;

import java.time.LocalDateTime;
import java.util.List;

public abstract class AbstractMiniGame {

    // State

    /** List of {@link Player}s who are in the mini game **/
    private List<Player> activePlayers;

    /** The {@link Player} who is currently tagged **/
    private Player it;

    /** The time the mini game started **/
    private LocalDateTime startTime;

    /** The time the mini game ended **/
    private LocalDateTime endTime;

    /** The {@link World} that the mini game is taking place **/
    private World location;

    private AbstractTimer timer;

    // Constructors

    public AbstractMiniGame(List<Player> activePlayers, World location, AbstractTimer timer){
        this.activePlayers = activePlayers;
        this.location = location;
    }

    // Mini game actions

    /**
     * Start the mini game
     */
    public void start() {
        this.preStart();
        this.startTime = LocalDateTime.now();

        this.postStart();
    }

    /**
     * Stop the mini game
     */
    public void stop() {
        this.preStop();
        this.endTime = LocalDateTime.now();

        this.postStop();
    }

    public void playerTagged(Player tagged) {
        this.it = tagged;
        this.newTaggedPlayer(tagged);
    }



    // Mini game lifecycle

    protected abstract void preStart();

    protected abstract void postStart();

    protected abstract void newTaggedPlayer(Player player);

    protected abstract void preStop();

    protected abstract void postStop();
}
