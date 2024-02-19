package com.company.inventory.inventory.junit;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNotEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class firtsTest {

  @Test
  public void assertEqualsTest(){
        assertEquals(1, 1);
  }
  
  @Test
  public void assertNotEqualsTest(){
        assertNotEquals(2, 1);
  }

  @Test
  public void assertTrueFalseTest(){

    boolean isEqual = ( 4 == 4 );
    boolean isDifferent = ( 4 == 3 );

        assertTrue(isEqual);
        assertFalse(isDifferent);
  }

  @Test
  @DisplayName("Compara que dos arreglo sean iguales")
  public void assertArrayEqualsTest(){
    String[] array1 = {"a", "b", "c", "d"}; 
    String[] array2 = {"a", "b", "c", "d"}; 

    assertArrayEquals(array1, array2);
  }
    
}