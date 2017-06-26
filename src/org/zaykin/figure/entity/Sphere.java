package org.zaykin.figure.entity;

import org.zaykin.figure.abstractclass.AbstractFigure;
import org.zaykin.figure.exception.ParametersFormatException;
import org.zaykin.figure.pattern.FigureObservable;
import org.zaykin.figure.pattern.FigureObserver;
import org.zaykin.figure.pattern.KeyValuePairSingleton;

import java.util.ArrayList;
import java.util.UUID;


/**
 * Created by DHM on 6/2/2017.
 */
public class Sphere extends AbstractFigure implements Cloneable, FigureObservable {

    private UUID sphereId;
    private Point center;
    private float radius;
    private KeyValuePairSingleton observerSingleton;

    public Sphere(Point center, float radius) {
        this.sphereId = UUID.randomUUID();
        this.center = center;
        this.radius = radius;
        observerSingleton = KeyValuePairSingleton.getInstance();
    }

    public UUID getSphereId () {
        return sphereId;
    }

    public Point getCenter() {
        return center;
    }

    public void setCenter(Point center) throws ParametersFormatException {
        this.center = center;
        notifyObservers();
    }

    public float getRadius() {
        return radius;
    }

    public void setRadius(float radius) throws ParametersFormatException {
        this.radius = radius;
        notifyObservers();
    }

    private ArrayList<FigureObserver> observersList = new ArrayList<>();

    @Override
    public void register(FigureObserver o) {
        observersList.add(o);
        observerSingleton.addKeyValueList(((SphereAttribute)o).getSphereId(), this.sphereId);
    }

    @Override
    public void unregister(FigureObserver o) {
        observersList.remove(o);
        observerSingleton.removeKeyValueList(((SphereAttribute)o).getSphereId());
    }

    @Override
    public void notifyObservers() throws ParametersFormatException {
        for (FigureObserver observer : observersList) {
            observer.update(this.clone());
        }
    }

    @Override
    public String getColor(){
        return "Red";
    }

    @Override
    public Sphere clone() {
        Sphere copy = null;

        try {
        copy = (Sphere)super.clone();
        copy.center = (Point)this.center.clone();
        }
        catch (CloneNotSupportedException e){
            throw new RuntimeException("Cannot copy an object", e.getCause());
        }

        return copy;

    }

    @Override
    public String toString() {

        return String.format("Object: %s \nCenter: {x:%f,y:%f,z:%f} \nRadius:%f",this.getClass().getName(), this.center.getX(), this.center.getY(), this.center.getZ(), this.radius);

    }
}
