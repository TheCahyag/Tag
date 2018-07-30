package com.servegame.bl4de.common;

import java.time.Duration;
import java.time.LocalDateTime;
import java.util.Timer;

public abstract class AbstractTimer extends Timer {

    /** The time the mini game started **/
    private LocalDateTime startTime;

    /** The time the mini game ended **/
    private LocalDateTime endTime;

    /** TODO **/
    private Status status;

    /**
     * TODO
     */
    private static enum Status {
        /** TODO **/
        CREATED,

        /** TODO **/
        STARTED,

        /** Paused functionality isn't implemented yet TODO **/
        PAUSED,

        /** TODO **/
        STOPPED
    }

    /**
     * Set the initial status to {@link Status#CREATED}
     */
    public AbstractTimer() {
        this.status = Status.CREATED;
    }

    /**
     * Start the timer by setting the start time.
     */
    public void startTimer(){
        if (this.status == Status.STARTED || this.status == Status.STOPPED){
            throw new RuntimeException("Can not start timer when it is already stopped/started");
        }
        this.status = Status.STARTED;
        this.startTime = LocalDateTime.now();
    }

    /**
     * Stop the timer by setting the stop time. If the timer was never started in
     * the first place the start time will be set to the stop time, making the
     * duration of length zero.
     */
    public void stopTimer(){
        if (this.status == Status.STOPPED){
            throw new RuntimeException("Can not stop timer when it is already stopped/started");
        }
        this.status = Status.STOPPED;

        this.endTime = LocalDateTime.now();

        // If the timer was never started set the start and end time to now, effectively a duration of 0
        if (this.startTime == null){
            this.startTime = this.endTime;
        }
    }

    /**
     * Get the duration in seconds between the start time and the end time.
     * @return Duration in seconds between the start time and the end time
     *         Duration in seconds between the start time and now if the timer was never stopped
     *         0 if the start time is null (the timer was never started)
     */
    public Duration getDuration(){
        if (this.startTime == null){
            return Duration.ofSeconds(0);
        }
        if (this.status != Status.STOPPED){
            return Duration.between(LocalDateTime.now(), this.startTime);
        }
        return Duration.between(this.endTime, this.startTime);
    }


    /**
     * Return duration in seconds
     * @return number of seconds between the start time and stop time as determined by {@link #getDuration()}
     */
    public Long getDurationInSeconds(){
        return this.getDuration().getSeconds();
    }

    /**
     * The in-game representation that the duration will take on.
     */
    public abstract Object durationToText();
}
