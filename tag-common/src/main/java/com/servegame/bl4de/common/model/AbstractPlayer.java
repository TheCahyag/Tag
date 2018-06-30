package com.servegame.bl4de.common.model;

import com.servegame.bl4de.common.model.location.Vector3D;


public abstract class AbstractPlayer implements Identifiable {

    /**  TODO  **/
    protected boolean isObserver;

    public AbstractPlayer() {
        this.isObserver = false;
    }

    public abstract Vector3D getPosition();

    public boolean isObserver() {
        return isObserver;
    }
}
