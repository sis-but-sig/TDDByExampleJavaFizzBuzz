package com.sisbutsig.tddbyexample.fizzbuzz;

import static org.hamcrest.Matchers.is;
import static org.junit.Assert.assertThat;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.io.PrintWriter;
import java.io.StringWriter;
import java.util.stream.Stream;

import org.junit.Test;

public class GivenAFizzBuzz {
  @Test
  public void printToShouldPrintNums() {
    validatePrintTo(2, "1", "2");
  }

  @Test
  public void printToShouldPrintNumsAndFizz() {
    validatePrintTo(3, "1", "2", "Fizz");
  }

  @Test
  public void printToShouldPrintNumsFizzAndBuzz() {
    validatePrintTo(5, "1", "2", "Fizz", "4", "Buzz");
  }

  @Test
  public void printToShouldPrintNumsFizzBuzzAndFizzBuzz() {
    validatePrintTo(15, "1", "2", "Fizz", "4", "Buzz", "Fizz", "7", "8", "Fizz",
        "Buzz", "11", "Fizz", "13", "14", "FizzBuzz");
  }

  private void validatePrintTo(int num, String... expectedValues) {
    ByteArrayOutputStream bos = new ByteArrayOutputStream();
    try (PrintStream printStream = new PrintStream(bos)) {
      System.setOut(printStream);

      FizzBuzz.printTo(num);
    }

    StringWriter strWriter = new StringWriter();
    try (PrintWriter printWriter = new PrintWriter(strWriter)) {
      Stream.of(expectedValues)
            .forEach(printWriter::println);
    }
    assertThat(bos.toString(), is(strWriter.toString()));
  }
}
