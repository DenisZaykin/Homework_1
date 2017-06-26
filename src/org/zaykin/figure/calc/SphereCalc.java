package org.zaykin.figure.calc;

import org.zaykin.figure.entity.Sphere;
import org.zaykin.figure.enumeration.CoordinatePlane;
import org.zaykin.figure.exception.ParametersFormatException;

/**
 * Created by DHM on 6/2/2017.
 */
public class SphereCalc {

    private SphereCalc() {
    }

    public static double square(Sphere sphere) {

        float r = sphere.getRadius();

        return 4*Math.PI*Math.pow(r,2);
    }

    public static double volume(Sphere sphere) {
        float r = sphere.getRadius();

        return 4*Math.PI*Math.pow(r,3)/3.0;
    }

    private static float height(Sphere sphere, CoordinatePlane plane) throws ParametersFormatException {
        float coord=0;

        switch (plane) {
            case XY:
                coord = sphere.getCenter().getZ();
                break;
            case XZ:
                coord = sphere.getCenter().getY();
                break;
            case YZ:
                coord = sphere.getCenter().getX();
                break;
            default:
                throw new ParametersFormatException(String.format("Wrong coordinate plane. Expected XY or XZ or YZ; got %s",plane.toString()));
        }

        coord=Math.abs(coord);

        float r=sphere.getRadius();

        return coord>r ? 0 : r-coord;

    }

    private static double segmentVolume(Sphere sphere, float height){
        float r = sphere.getRadius();
        return Math.PI*Math.pow(height,2)*(3*r-height)/3.0;

    }

    public static double segmentComparison (Sphere sphere, CoordinatePlane plane) throws ParametersFormatException {

        float r = sphere.getRadius();
        float segmentHeight = height(sphere, plane);
        return segmentVolume(sphere, segmentHeight)/segmentVolume(sphere, 2*r - segmentHeight);

    }


}
