package org.zaykin.figure.entity;

import org.zaykin.figure.abstractclass.AbstractFigure;
import org.zaykin.figure.calc.SphereCalc;
import org.zaykin.figure.pattern.FigureObserver;

import java.util.UUID;

/**
 * Created by DHM on 6/5/2017.
 */
public class SphereAttribute implements FigureObserver {

    private UUID sphereId;
    private double square;
    private double volume;

    public SphereAttribute(Sphere sphere) {
        this.sphereId = UUID.randomUUID();
        update(sphere);

    }

    public UUID getSphereId() {
        return sphereId;
    }

    public double getSquare() {
        return square;
    }

    public double getVolume() {
        return volume;
    }

    @Override
    public void update(AbstractFigure figure) {
            square = SphereCalc.square((Sphere)figure);
            volume = SphereCalc.volume((Sphere)figure);
    }

}
