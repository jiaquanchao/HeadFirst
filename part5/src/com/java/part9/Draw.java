package com.java.part9;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Jax on 2016/11/18.
 */
public class Draw {

    public void allDraw(List<? extends Shape> list) {
        for (Object object : list) {
            Shape shape = (Shape)object;
            shape.draw();
        }
    }

    public static void main(String[] args) {
        List<Circle> circles = new ArrayList<>();
        List<Triangle> triangles = new ArrayList<>();
        List<Shape> shapes = new ArrayList<>();

        Circle circle = new Circle();
        circles.add(0, circle);
        circles.add(1, circle);
        circles.add(2, circle);

        Triangle triangle = new Triangle();
        triangles.add(0, triangle);
        triangles.add(1, triangle);
        triangles.add(2, triangle);

        shapes.add(0, circle);
        shapes.add(1, triangle);


        System.out.println(circles.size());
        for (Circle c:
             circles) {
            c.draw();
        }

        for (Triangle t:
                triangles) {
            t.draw();
        }

        for (Shape s:
             shapes) {
            s.draw();
        }

    }

}
