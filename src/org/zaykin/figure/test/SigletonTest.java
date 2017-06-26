package org.zaykin.figure.test;

import org.junit.Assert;
import org.junit.Test;
import org.zaykin.figure.pattern.KeyValuePairSingleton;

/**
 * Created by a on 26.06.2017.
 */
public class SigletonTest {

    @Test
    public void isSingleton (){
        KeyValuePairSingleton singleton1 = KeyValuePairSingleton.getInstance();
        KeyValuePairSingleton singleton2 = KeyValuePairSingleton.getInstance();
        Assert.assertTrue(singleton1 == singleton2);
    }

}
