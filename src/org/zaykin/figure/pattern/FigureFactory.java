package org.zaykin.figure.pattern;

import org.zaykin.figure.abstractclass.AbstractFigure;
import org.zaykin.figure.entity.Point;
import org.zaykin.figure.entity.Sphere;
import org.zaykin.figure.exception.ParametersFormatException;

/**
 * Created by DHM on 6/9/2017.
 */
public class FigureFactory {

    public static AbstractFigure makeFigure(String figureType, Point center, float r) throws ParametersFormatException{

        AbstractFigure abstractFigure = null;

        switch (figureType) {
            case "Sphere":
                abstractFigure = new Sphere(center, r);
                break;
            default:
                throw new ParametersFormatException(String.format("Wrong object type has been passed to the factory method: %s", figureType));
        }

        return abstractFigure;

    }
}
