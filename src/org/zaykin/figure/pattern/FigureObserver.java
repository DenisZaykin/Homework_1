package org.zaykin.figure.pattern;

import org.zaykin.figure.abstractclass.AbstractFigure;
import org.zaykin.figure.exception.ParametersFormatException;

/**
 * Created by DHM on 6/5/2017.
 */
public interface FigureObserver {
    void update(AbstractFigure figure) throws ParametersFormatException;
}
