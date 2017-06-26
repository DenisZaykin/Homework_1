package org.zaykin.figure.pattern;

import org.zaykin.figure.exception.ParametersFormatException;

/**
 * Created by DHM on 6/5/2017.
 */
public interface FigureObservable {

    void register(FigureObserver o);
    void unregister(FigureObserver o);
    void notifyObservers() throws ParametersFormatException;

}
