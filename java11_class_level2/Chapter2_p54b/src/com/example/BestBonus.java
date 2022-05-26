package com.example;

public class BestBonus {
  public double calcBonus(Employee e){
      return e.getSalary()*e.getBonusPercent();
  }
}
