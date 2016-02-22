package com.javainterview.app.MatrixInterview;

import junit.framework.Assert;
import org.testng.annotations.Test;

import java.awt.*;

import static org.testng.Assert.*;

/**
 * Created on 2/22/2016.
 */
public class FloodFillTest {

    @Test
    public void testFloodFill() throws Exception {
        Color[][] image = new Color[3][3];
        for ( int i=0; i < image.length; i++) {
            for ( int j=0; j < image[0].length; j++) {
                image[i][j] = Color.white;
            }
        }

        FloodFill ff = new FloodFill();
        ff.floodFill(image, 0, 0, Color.blue);

        System.out.println(image[2][2].toString());
        Assert.assertEquals(image[2][2], Color.blue);
    }
}