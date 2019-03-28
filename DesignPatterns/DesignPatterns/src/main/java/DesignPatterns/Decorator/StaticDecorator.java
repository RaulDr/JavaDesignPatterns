package DesignPatterns.Decorator;

import java.util.function.Supplier;



public class StaticDecorator {
    interface Shape {
        String info();
    }

    class Circle implements DesignPatterns.Decorator.Shape {
        private float radius;

        Circle() {
        }

        public Circle(float radius) {
            this.radius = radius;
        }

        void resize(float factor) {
            radius *= factor;
        }

        @Override
        public String info() {
            return "A circle of radius " + radius;
        }
    }

    class Square implements DesignPatterns.Decorator.Shape {
        private float side;

        public Square() {
        }

        public Square(float side) {
            this.side = side;
        }

        @Override
        public String info() {
            return "A square with side " + side;
        }
    }

// we are NOT altering the base class of these objects
// cannot make ColoredSquare, ColoredCircle

    class ColoredShape<T extends DesignPatterns.Decorator.Shape> implements DesignPatterns.Decorator.Shape {
        private DesignPatterns.Decorator.Shape shape;
        private String color;

        public ColoredShape(Supplier<? extends T> ctor, String color) {
            shape = ctor.get();
            this.color = color;
        }

        @Override
        public String info() {
            return shape + " has the color " + color;
        }
    }

    class TransparentShape<T extends DesignPatterns.Decorator.Shape> implements DesignPatterns.Decorator.Shape {
        private DesignPatterns.Decorator.Shape shape;
        private int transparency;

        public TransparentShape(Supplier<? extends T> ctor, int transparency) {
            shape = ctor.get();
            this.transparency = transparency;
        }

        @Override
        public String info() {
            return shape + " has " + transparency + "% transparency";
        }
    }

    class StaticDecoratorDemo {
//        public static void main(String[] args) {
//            DesignPatterns.Decorator.Circle circle = new DesignPatterns.Decorator.Circle(10);
//            System.out.println(circle.info());
//
//            DesignPatterns.Decorator.ColoredShape<DesignPatterns.Decorator.Square> blueSquare = new DesignPatterns.Decorator.ColoredShape<>(() -> new DesignPatterns.Decorator.Square(20), "blue");
//            System.out.println(blueSquare.info());
//
//            // ugly!
//            DesignPatterns.Decorator.TransparentShape<DesignPatterns.Decorator.ColoredShape<DesignPatterns.Decorator.Circle>> myCircle =
//                    new DesignPatterns.Decorator.TransparentShape<>(() ->
//                            new DesignPatterns.Decorator.ColoredShape<>(() -> new DesignPatterns.Decorator.Circle(5), "green"), 50
//                    );
//            System.out.println(myCircle.info());
//            // cannot call myCircle.resize()
//        }
    }
}
