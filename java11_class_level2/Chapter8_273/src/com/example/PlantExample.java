package com.example;

import java.util.List;
import java.util.function.Consumer;

public class PlantExample {
    public static void main(String[] args) {
        
        List<Fruit> fruits = List.of(new Fruit("apple", 1), new Fruit("orange", 2), new Fruit("pear", 4));
        
// Slide 32, second code box. You can't do this because Consumer.accept() returns void
        
        //fruits.forEach((a -> System.out.println(a)).andThen(a -> System.out.println("some text"))); //error
        
// Slide 33. But, if we create a Consumer called bag, the andThen method can be called
// on it to produce a new Consumer with more functionality, in this case to add plural
// where appropriate.
        
        Consumer<Fruit> bag = b -> System.out.print(b.amount + " " + b.fruitType);
        Consumer<Fruit> bagOutput = bag.andThen(a -> System.out.println(a.amount > 1?"s":""));
        fruits.forEach(bagOutput);
        
        
    }
}       

// As defined on slide 29
class TropicalFruit extends Fruit { 
        public TropicalFruit(String type, int amount) {
            super(type, amount);
    }
}


// As defined on slide 26
class Fruit extends Plant{
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


