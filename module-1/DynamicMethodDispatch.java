class Shape {
    void draw() {
        System.out.println("Drawing a shape");
    }
}

class Circle extends Shape {
    @Override
    void draw() {
        System.out.println("Drawing a circle");
    }
}

class Rectangle extends Shape {
    @Override
    void draw() {
        System.out.println("Drawing a rectangle");
    }
}

public class DynamicMethodDispatch {
    public static void main(String[] args) {
        Shape shape = new Circle();
        shape.draw();

        shape = new Rectangle();
        shape.draw();
    }
}
