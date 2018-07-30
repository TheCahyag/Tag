package com.servegame.bl4de.common;

import com.servegame.bl4de.common.model.AbstractPlayer;
import com.servegame.bl4de.common.model.AbstractWorld;
import com.servegame.bl4de.common.model.PostGameStats;

import java.time.Duration;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public abstract class AbstractMiniGame {

    // State

    /** TODO **/
    private String name;

    /** List of {@link AbstractPlayer}s who are in the mini game **/
    private List<AbstractPlayer> activePlayers;

    /** List of {@link AbstractPlayer}s who are watching the game but can't participate**/
    private List<AbstractPlayer> spectators;

    /** The {@link AbstractPlayer} who is currently tagged **/
    private AbstractPlayer it;

    /** The {@link AbstractWorld} that the mini game is taking place **/
    private AbstractWorld location;

    /** TODO **/
    private AbstractTimer timer;

    /** TODO **/
    private PostGameStats postGameStats;

    private Status status;

    /**
     * TODO
     */
    public static enum Status {
        /** TODO **/
        CREATED,

        /** TODO **/
        STARTED,

        /** TODO **/
        PAUSED,

        /** TODO **/
        FINISHED
    }

    // Constructors

    public AbstractMiniGame(String name, AbstractWorld location, AbstractTimer timer){
        this.preCreation();
        this.name = name;
        this.activePlayers = new ArrayList<>();
        this.spectators = new ArrayList<>();
        this.timer = timer;
        this.location = location;
        this.status = Status.CREATED;
        this.postCreation();
    }

    // Mini game actions

    /**
     * Start the mini game
     */
    public void start() {
        this.preStart();

        this.status = Status.STARTED;
        Random random = new Random();
        this.timer.startTimer();
        this.it = this.activePlayers.get(random.nextInt(activePlayers.size()));
        this.newTaggedPlayer(it);


        this.postStart();
    }

    /**
     * Stop the mini game
     */
    public void stop() {
        this.preStop();

        this.status = Status.FINISHED;
        this.timer.stopTimer();
        this.printInfo();
        this.postStop();
    }

    public void playerTagged(AbstractPlayer tagged) {
        this.it = tagged;
        this.newTaggedPlayer(tagged);
    }

    public Duration getTotalGameTime(){
        return this.timer.getDuration();
    }

    // Mini game lifecycle

    protected abstract void preCreation();

    protected abstract void postCreation();

    protected abstract void preStart();

    protected abstract void postStart();

    protected abstract void newTaggedPlayer(AbstractPlayer player);

    protected abstract void preStop();

    protected abstract void postStop();

    protected abstract void printInfo();

    // Getters and setters


    public String getName() {
        return name;
    }

    public Status getStatus() {
        return status;
    }

    /**
     * TODO
     * @param player
     * @return
     */
    public boolean hasPlayer(AbstractPlayer player){
        return this.activePlayers.contains(player);
    }
}
