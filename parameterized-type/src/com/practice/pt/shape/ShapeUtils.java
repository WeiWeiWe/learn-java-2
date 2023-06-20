package com.practice.pt.shape;

import java.util.ArrayList;
import java.util.List;

public class ShapeUtils {
    public void drawAll(List<? extends Shape> shapeList) {
        for (Shape shape : shapeList) {
            shape.draw();
        }
    }

    public void doSth(List<? super Rectangle> shapeList) {
        System.out.println("");
    }

    public static void main(String[] args) {
        ShapeUtils utils = new ShapeUtils();
        List<Circle> circleList = new ArrayList();
        utils.drawAll(circleList);
        List<Rectangle> shapeList = new ArrayList();
        utils.doSth(shapeList);
    }
}
