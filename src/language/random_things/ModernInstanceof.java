package language.random_things;

public class ModernInstanceof {

    public static void main(String[] args) {
         Circle circle = new Circle();
         circle.radius = 100;

         Rectangle rectangle = new Rectangle();
         rectangle.width = 100;
         rectangle.length = 100;

        System.out.println(Shape.perimeter(circle));
        System.out.println(Shape.perimeter(rectangle));

    }


}



interface Shape {

    // избегаем ненужного кастинга
    public static double perimeter(Shape s){
        if (s instanceof Circle r){
            return 2*r.radius*Math.PI;
        }
        else if (s instanceof Rectangle r){
            return r.length*r.width*2;
        }

        else {
            throw new IllegalArgumentException("Unknown shape");
        }
    }
}


class Circle implements Shape{
    double radius;
}

class Rectangle implements Shape{
    double length;
    double width;
}


