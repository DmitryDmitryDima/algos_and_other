package language;

import java.util.ArrayList;
import java.util.List;

public class Inheritance {

    public static void main(String[] args) {

        List<Shape> shapes = List.of(

                new Square("Green", 100),
                new Triangle("red", 150)


        );
        shapes.forEach(Shape::introduceYourself);


    }


}



abstract class Shape {
    private final String color;

    public Shape(String color){
        this.color = color;
    }


    public void introduceYourself(){
        System.out.println("Hello, I am a Shape with color "+color);
    }
}


class Triangle extends Shape{

    private final int coordinates;
    public Triangle(String color, int coordinates){
        super(color);
        this.coordinates = coordinates;
    }

    public void introduceYourself(){
        super.introduceYourself();
        System.out.println("My specification - triangle with coordinates "+coordinates);
    }

}

class Square extends Shape {
    private final int area;

    public Square(String color, int area) {
        super(color);
        this.area = area;
    }

    @Override
    public void introduceYourself(){
        super.introduceYourself();
        System.out.println("My specification - square with area "+area);
    }
}