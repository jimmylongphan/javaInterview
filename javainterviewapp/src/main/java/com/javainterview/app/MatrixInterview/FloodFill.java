package com.javainterview.app.MatrixInterview;

import java.awt.*;

/**
 * Created on 2/22/2016.
 */
public class FloodFill {

    int dimensions[][] = {{0,-1}, {0,1}, {-1,0}, {1,0}};

    public void floodFill(Color[][] image, int x, int y, Color newColor) {
        // out of boundary
        if (x < 0 || x > image.length-1 || y < 0 || y > image[0].length-1) {
            return;
        }

        // color already matches
        if (image[x][y] == newColor) {
            return;
        }

        // set the new color
        image[x][y] = newColor;

        // go through all adjacent nodes and recursively call floodFill
        for (int dimension[] : dimensions) {
            floodFill(image, x + dimension[0], y + dimension[1], newColor);
        }

    }


}
