package org.zaykin.figure.entity;

/**
 * Created by DHM on 6/2/2017.
 */
public class Point implements Cloneable{

    private float x;
    private float y;
    private float z;

    public Point(float x, float y, float z) {
        this.x = x;
        this.y = y;
        this.z = z;
    }

    public void setX(int x) {
        this.x = x;
    }

    public void setY(int y) {
        this.y = y;
    }

    public void setZ(int z) {
        this.z = z;
    }

    public float getX() {
        return x;
    }

    public float getY() {
        return y;
    }

    public float getZ() {
        return z;
    }

    @Override
    public Point clone() {

        try {
            return (Point)super.clone();
        }
        catch (CloneNotSupportedException e){
            throw new RuntimeException("Cannot copy an object", e.getCause());
        }

    }

}
