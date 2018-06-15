package com.servegame.bl4de.common.model.location;

/**
 * File: Vector3D.java
 *
 * @author Brandon Bires-Navel (brandonnavel@outlook.com)
 */
public class Vector3D {

    /** TODO **/
    private final double x;

    /** TODO **/
    private final double y;

    /** TODO **/
    private final double z;

    /**
     * TODO
     * @param x TODO
     * @param y TODO
     * @param z TODO
     */
    public Vector3D(double x, double y, double z) {
        this.x = x;
        this.y = y;
        this.z = z;
    }

    /* Getters (no setters) */

    /**
     * TODO
     * @return TODO
     */
    public double getX() {
        return x;
    }

    /**
     * TODO
     * @return TODO
     */
    public double getY() {
        return y;
    }

    /**
     * TODO
     * @return TODO
     */
    public double getZ() {
        return z;
    }
}
