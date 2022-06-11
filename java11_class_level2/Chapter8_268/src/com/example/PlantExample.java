package com.example;

import java.util.List;

public class PlantExample {

    public static void main(String[] args) {

        List<Fruit> fruits = List.of(new Fruit("apple", 1), new Fruit("orange", 2), new Fruit("pear", 4));

//
// forEach method on Iterable has signature:
// default void forEach(Consumer<? super T> action)
// In this example T is Fruit
//
// Slide 27. Item type is inferred as Fruit which has describe method so this works
        fruits.forEach(a -> System.out.println(a.describe()));
// Slide 28, first code box. Item type is supertype of Fruit so does not compile
// EVEN THOUGH VALID TYPE, because supertype Plant does not have describe method.
// This example proves that declaring the type in Lambda ensures item ref is of declared type
        //fruits.forEach((Plant a) -> System.out.println(a.describe())); //error
// Slide 28, second code box.
// Shows that forEach method works as expected with a superclass of Fruit
// as it's now calling a method on Plant (actually the toString on Object)
        //fruits.forEach((Plant a) -> System.out.println(a)); 
// Slide 29, second code box
// But, as expected from signature of forEach method of Iterable, if we 
// use a subtype of Fruit in lambda, it won't compile
        //fruits.forEach((TropicalFruit a) -> System.out.println(a));  //error
    }
}

// As defined on slide 29
class TropicalFruit extends Fruit {

    public TropicalFruit(String type, int amount) {
        super(type, amount);
    }
}

// As defined on slide 26
class Fruit extends Plant {

    String fruitType = "";
    int amount = 0;

    public Fruit(String type, int amount) {
        this.amount = amount;
        this.fruitType = type;
    }

    public String describe() {
        return "Fruit description: " + this.fruitType + ":" + this.amount;
    }
}

class Plant {

}
