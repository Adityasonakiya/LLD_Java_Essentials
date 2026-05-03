class Car {
  // Attributes :
  String manufacturer;
  String model;
  int year;

  // Constructor :
  public Car(String manufacturer, String model, int year) {
    this.manufacturer = manufacturer;
    this.model = model;
    this.year = year;
  }

  // Methods :
  public void startEngine() {
    System.out.println("The " + year + " " + manufacturer + " " + model + "'s engine has started.");
  }

  public void displayInfo() {
    System.out.println("Car Info: " + manufacturer + " " + model + " (" + year + ")");
  }
}

abstract class Animal {
  // Abstract method for unique behaviors
  abstract void makeSound();

  // Concrete method for shared behaviors
  void sleep() {
    System.out.println("Sleeping...");
  }
}

interface IAnimal {
  void makeSound();

  void sleep();
}

// Specific implementation for Dog
class Dog extends Animal implements IAnimal {
  @Override
  public void makeSound() {
    System.out.println("Bark");
  }

  @Override
  public void sleep() {
    System.out.println("Sleeping...");
  }
}

public class JavaBasics {
  public static void main(String[] args) {
    // Creating objects
    Car car1 = new Car("Toyota", "Corolla", 2021);
    Car car2 = new Car("Honda", "Civic", 2022);

    // Using objects
    car1.startEngine(); // Output: The 2021 Toyota Corolla's engine has started.ĺ
    car2.startEngine(); // Output: The 2022 Honda Civic's engine has started.
    car1.displayInfo(); // Output: Car Info: Toyota Corolla (2021)
    car2.displayInfo(); // Output: Car Info: Honda Civic (2022)
  }
}