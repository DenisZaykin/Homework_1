package org.zaykin.figure.test;

import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;
import org.zaykin.figure.calc.SphereCalc;
import org.zaykin.figure.entity.Point;
import org.zaykin.figure.entity.Sphere;

/**
 * Created by a on 26.06.2017.
 */
public class SphereCalcTest {

    private static Sphere sphere;

    @BeforeClass
    public static void createSphere() {
        sphere = new Sphere(new Point(0,0,0), 5);
    }

    @Test
    public void squareCalc() {
        Assert.assertEquals(SphereCalc.square(sphere), 314.159265, 0.000001);
    }

    @Test
    public void volumeCalc() {
        Assert.assertEquals(SphereCalc.volume(sphere), 523.598775, 0.000001);
    }

}
