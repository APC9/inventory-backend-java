package com.company.inventory.inventory.junit;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class CalculatorTest {
    
  Calculator calculator;

  @BeforeAll
  public static void first(){
    System.out.println("First");
  }

  @AfterAll
  public static void lasted(){
    System.out.println("lasted");
  }

  @AfterEach
  public void lasteForEachTest(){
    System.out.println("ultimo por cada prueba");
  }

  @BeforeEach
  public void firstForEachTest(){
    System.out.println("primero por cada prueba");
    calculator = new Calculator();
  }

  @Test
  public void sumarTest(){
    assertEquals(2, calculator.sumar(1, 1));
    assertFalse(calculator.sumar(2, 2) == 5);
  }

  @Test
  @DisplayName("El metodo sumar debe devolver las sumar de 2 numero float")
  public void restarTest(){
    assertEquals(2, calculator.restar(4, 2));
    assertFalse(calculator.restar(4, 2) == 5);
  }

  @Test
  @Disabled("Este metodo deshabilita la prueba unitaria")
  public void multiplicarTest(){
    assertEquals(8, calculator.multiplicar(4, 2));
  }

  @Test
  public void dividirTest(){
    assertEquals(2, calculator.dividir(4, 2));
  }


}