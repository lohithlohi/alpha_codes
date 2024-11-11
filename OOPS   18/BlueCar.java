


public class BlueCar extends Car {
    {
        System.out.print("4");
    }

    public BlueCar() {
        super("blue");
        System.out.print("5");
    }

    public static void main(String[] gears) {
        new BlueCar();
    }
}

abstract class Car {
    static {
        System.out.print("1");
    }

    public Car(String name) {
        super();
        System.out.print("2");
    }

    {
        System.out.print("3");
    }
}



// output: 13245

// The output of the given code when executed will be:
// 13245

// The code defines a Java class hierarchy consisting of
// an abstract class "Car" and a subclass "BlueCar" that
// extends "Car". When an instance of BlueCar is created 
// using the constructor, it first calls the constructor
// of the superclass "Car" with the argument "blue", which
// prints "2", then prints "5" and the initialization block
// of BlueCar, which prints "4" and an email address.
// Finally, the static initializer block of Car prints "1",
// and the instance initializer block of Car prints "3".
// When the "main" method is called, it creates a new instance
// of BlueCar, triggering the output described above.