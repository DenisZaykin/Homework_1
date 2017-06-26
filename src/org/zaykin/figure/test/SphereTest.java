package org.zaykin.figure.test;

import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;
import org.zaykin.figure.abstractclass.AbstractFigure;
import org.zaykin.figure.pattern.FigureFactory;
import org.zaykin.figure.entity.Sphere;
import org.zaykin.figure.entity.SphereAttribute;
import org.zaykin.figure.file.FileOperation;
import org.zaykin.figure.parser.DataParser;
import org.zaykin.figure.validator.SphereValidator;
import org.zaykin.figure.entity.Point;

import java.util.ArrayList;

/**
 * Created by DHM on 6/2/2017.
 */
public class SphereTest {

    private static final String FILE_NAME = "data\\sphere.txt";
    private static final String DELIMITER = ";";
    private static final int X=0;
    private static final int Y=1;
    private static final int Z=2;
    private static final int R=3;
    private static ArrayList<Sphere> spheres = new ArrayList<>();
    private static ArrayList<SphereAttribute> sphereAttriburess = new ArrayList<>();

    @BeforeClass
    public static void createSpheres() throws Exception {

        ArrayList<String> linesFromFile = FileOperation.readDataFromFile(FILE_NAME);

        for (int lineNumber=0; lineNumber<linesFromFile.size(); lineNumber++) {
            int arrayIndex = 0;
            String[] parsedLine = DataParser.parseLine(linesFromFile.get(lineNumber), DELIMITER, lineNumber+1);
            if (SphereValidator.isValid(parsedLine)) {
                AbstractFigure tempAbstractFigure = FigureFactory.makeFigure("Sphere", new Point(Float.parseFloat(parsedLine[X]),Float.parseFloat(parsedLine[Y]),Float.parseFloat(parsedLine[Z])),Float.parseFloat(parsedLine[R]));
                if (tempAbstractFigure instanceof Sphere) {
                    spheres.add((Sphere)tempAbstractFigure);
                    sphereAttriburess.add(new SphereAttribute((Sphere)tempAbstractFigure));
                    spheres.get(arrayIndex).register(sphereAttriburess.get(arrayIndex));
                    arrayIndex++;
                }
            }
        }
    }

    @Test
    public void isNotEmpty(){
        Assert.assertTrue(!spheres.isEmpty());
    }

    @Test
    public void isSphere(){
             Assert.assertTrue(spheres.get(0) instanceof Sphere);
    }

    @Test
    public void isInTouchWithPlane(){

                float r = spheres.get(0).getRadius();
                float x = Math.abs(spheres.get(0).getCenter().getX());
                float y = Math.abs(spheres.get(0).getCenter().getY());
                float z = Math.abs(spheres.get(0).getCenter().getZ());

                Assert.assertEquals(0, (r - x) * (r - y) * (r - z), 0.000001);

    }

}
