package com.servegame.bl4de.common;

import com.servegame.bl4de.common.model.AbstractPlayer;
import com.servegame.bl4de.common.model.AbstractWorld;

import java.time.Duration;
import java.time.LocalDateTime;
import java.util.List;
import java.util.Random;

public abstract class AbstractMiniGame {

    // State

    /** List of {@link AbstractPlayer}s who are in the mini game **/
    private List<AbstractPlayer> activePlayers;

    /** The {@link AbstractPlayer} who is currently tagged **/
    private AbstractPlayer it;

    /** The time the mini game started **/
    private LocalDateTime startTime;

    /** The time the mini game ended **/
    private LocalDateTime endTime;

    /** The {@link AbstractWorld} that the mini game is taking place **/
    private AbstractWorld location;

    private AbstractTimer timer;

    // Constructors

    public AbstractMiniGame(List<AbstractPlayer> activePlayers, AbstractWorld location, AbstractTimer timer){
        this.preCreation();
        this.activePlayers = activePlayers;
        this.location = location;
        this.postCreation();
    }

    // Mini game actions

    /**
     * Start the mini game
     */
    public void start() {
        this.preStart();

        Random random = new Random();
        this.it = this.activePlayers.get(random.nextInt(activePlayers.size()));
        this.newTaggedPlayer(it);
        this.startTime = LocalDateTime.now();

        this.postStart();
    }

    /**
     * Stop the mini game
     */
    public void stop() {
        this.preStop();
        this.endTime = LocalDateTime.now();
        this.printStats();
        this.postStop();
    }

    public void playerTagged(AbstractPlayer tagged) {
        this.it = tagged;
        this.newTaggedPlayer(tagged);
    }

    public Duration getTotalGameTime(){
        Duration timeDiff;
        if (this.endTime == null) {
            timeDiff = Duration.between(this.startTime, LocalDateTime.now());
        } else {
            timeDiff = Duration.between(this.startTime, this.endTime);
        }
        return timeDiff;
    }

    // Mini game lifecycle

    protected abstract void preCreation();

    protected abstract void postCreation();

    protected abstract void preStart();

    protected abstract void postStart();

    protected abstract void newTaggedPlayer(AbstractPlayer player);

    protected abstract void preStop();

    protected abstract void postStop();

    protected abstract void printStats();

}
