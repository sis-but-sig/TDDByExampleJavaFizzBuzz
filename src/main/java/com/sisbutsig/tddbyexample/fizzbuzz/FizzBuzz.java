package com.sisbutsig.tddbyexample.fizzbuzz;

import java.util.stream.IntStream;

public class FizzBuzz {
  private int i;
  private boolean isPrintNum = true;

  private FizzBuzz(int i) {
    this.i = i;
  }

  private FizzBuzz printIfNeeded(boolean printCondition, String value) {
    if (printCondition) {
      System.out.print(value);
      isPrintNum = false;
    }
    return this;
  }

  private FizzBuzz printFizzIfNeeded() {
    return printIfNeeded(i % 3 == 0, "Fizz");
  }

  private FizzBuzz printBuzzIfNeeded() {
    return printIfNeeded(i % 5 == 0, "Buzz");
  }

  private FizzBuzz printNumIfNeeded() {
    return printIfNeeded(isPrintNum, String.valueOf(i));
  }

  private void printNewLine() {
    System.out.println();
  }

  public static void printTo(int n) {
    IntStream.rangeClosed(1, n)
             .mapToObj(FizzBuzz::new)
             .map(FizzBuzz::printFizzIfNeeded)
             .map(FizzBuzz::printBuzzIfNeeded)
             .map(FizzBuzz::printNumIfNeeded)
             .forEach(FizzBuzz::printNewLine);
  }
}
