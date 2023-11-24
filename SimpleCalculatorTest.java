/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/UnitTests/JUnit5TestClass.java to edit this template
 */
package com.mycompany.mavenproject2;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
//import org.junit.Test;
//import static org.junit.Assert.assertEquals;
import static org.junit.jupiter.api.Assertions.*;

/**
 *
 * @author Arkstar
 */
public class SimpleCalculatorTest extends SimpleCalculator {
    
    public SimpleCalculatorTest() {
    }
    
    @BeforeAll
    public static void setUpClass() {
    }
    
    @AfterAll
    public static void tearDownClass() {
    }
    
    @BeforeEach
    public void setUp() {
    }
    
    @AfterEach
    public void tearDown() {
    }

    /**
     * Test of main method, of class SimpleCalculator.
     */
   
    

    @Test
    public void testAddition() {
        double result = calculate(5.0, 3.0, "+");
        assertEquals(8.0, result, 0.0001);
    }

    @Test
    public void testSubtraction() {
        double result = calculate(5.0, 3.0, "-");
        assertEquals(2.0, result, 0.0001);
    }

    @Test
    public void testMultiplication() {
        double result = calculate(5.0, 3.0, "*");
        assertEquals(15.0, result, 0.0001);
    }

    @Test
    public void testDivision() {
        double result = calculate(6.0, 2.0, "/");
        assertEquals(3.0, result, 0.0001);
    }

    @Test
    public void testDivisionByZero() {
        double result = calculate(6.0, 0.0, "/");
        assertEquals(Double.NaN, result, 0.0001);
    }

    @Test
    public void testInvalidOperator() {
        double result = calculate(5.0, 3.0, "%");
        assertEquals(Double.NaN, result, 0.0001);
    }
    
    @Test
    public void testZeroDivisionResult() {
        double result = calculate(0.0, 5.0, "/");
        assertEquals(0.0, result, 0.0001);
    }
}

