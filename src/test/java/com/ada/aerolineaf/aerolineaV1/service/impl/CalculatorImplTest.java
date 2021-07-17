package com.ada.aerolineaf.aerolineaV1.service.impl;

import com.ada.aerolineaf.aerolineaV1.service.ICalculator;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import java.nio.channels.ScatteringByteChannel;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

@SpringBootTest
public class CalculatorImplTest {

    ICalculator calculator = new CalculatorImpl();

    @Test
    void sumarTest() {
        int a = 3;
        int b = 6;

        int c = calculator.suma(a, b);

        assertTrue(c > 0);
        assertEquals(c, 9);
        assertEquals(c, a + b);

    }

    @Test
    void sumarUnNumYCeroTest() {
        int a = 3;
        int b = 0;

        int c = calculator.suma(a, b);

        assertTrue(c > 0);
        assertEquals(c, 3);
        assertEquals(c, a + b);
        assertEquals(c, a);

    }

    @Test
    void sumarCeroYCeroTest() {
        int a = 0;
        int b = 0;

        int c = calculator.suma(a, b);

        assertTrue(c == 0);
        assertEquals(c, 0);
        assertEquals(c, a + b);
        assertEquals(c, a);

    }
    @Test
    void restarTest() {
        int a = 7;
        int b = 2;

        int c = calculator.resta(a, b);

        assertTrue(c > 0);
        assertEquals(c, 5);
        assertEquals(c, a - b);
    }

    @Test
    void restarDosNegativosTest() {
        int a = -7;
        int b = -2;

        int c = calculator.resta(a, b);

        assertTrue(c < 0);
        assertEquals(c, -5);
        assertEquals(c, a - b);
    }

    @Test
    void restaPrimeroMenorQueElSegundoTest() {
        int a = 1;
        int b = 5;

        int c = calculator.resta(a, b);

        assertTrue(c < 0);
        assertEquals(-4, c);
        assertEquals(c, a - b);
    }

    @Test
    void restaPrimeroPositivoSegNegTest() {
        int a = 1;
        int b = -5;

        int c = calculator.resta(a, b);

        assertTrue(c > 0);
        assertEquals(6, c);
        assertEquals(c, a - b);
    }

    @Test
    void restaPrimeroNegSegPosTest() {
        int a = -1;
        int b = 5;

        int c = calculator.resta(a, b);

        assertTrue(c < 0);
        assertEquals(-6, c);
        assertEquals(c, a - b);
    }

    @Test
    void restaNumMenosCeroTest() {
        int a = 4;
        int b = 0;

        int c = calculator.resta(a, b);

        assertTrue(c > 0);
        assertEquals(4, c);
        assertEquals(c, a - b);
        assertEquals(c, a);
    }

    @Test
    void restaCeroMenosCeroTest() {
        int a = 0;
        int b = 0;

        int c = calculator.resta(a, b);

        assertTrue(c == 0);
        assertEquals(0, c);
        assertEquals(c, a - b);
        assertEquals(c, a, b);
    }
    
    // multiplicar:
    // 2pos
    // 2 neg
    // 1 pos x 1 neg}
    // mult x 0
    // mult x 1
    @Test
    void MultiplicacionTest() {
        int a = 3;
        int b = 4;

        int c = calculator.multiplicacion(a, b);

        assertTrue(c > 0);
        assertEquals(12, c);
        assertEquals(c, a * b);
    }

    @Test
    void multiplicacionDosNegTest() {
        int a = -3;
        int b = -4;

        int c = calculator.multiplicacion(a, b);

        assertTrue(c > 0);
        assertEquals(12, c);
        assertEquals(c, a * b);
    }

    @Test
    void multiplicacionPosXNegTest() {
        int a = -6;
        int b = 2;

        int c = calculator.multiplicacion(a, b);

        assertTrue(c < 0);
        assertEquals(-12, c);
        assertEquals(c, a * b);
    }

    @Test
    void multiplicacionPorCeroTest() {
        int a = 5;
        int b = 0;

        int c = calculator.multiplicacion(a, b);

        assertTrue(c == 0);
        assertEquals(0, c);
        assertEquals(c, a * b);
        assertEquals(c, b);
    }
    @Test
    void multiplicacionPorUnoTest() {
        int a = 5;
        int b = 1;

        int c = calculator.multiplicacion(a, b);

        assertTrue(c > 0);
        assertEquals(5, c);
        assertEquals(c, a * b);
        assertEquals(c, a);
    }

    // División normal
    // dividir x 1
    // dividir 2 negativos
    // dividir por el mismo número
    // dividir por 0
    @Test
    void divisionTest() {
        int a = 15;
        int b = 3;

        int c = calculator.division(a, b);

        assertTrue(c > 0);
        assertEquals(5, c);
        assertEquals(c, a / b);
    }
    @Test
    void divisionPorUnoTest() {
        int a = 15;
        int b = 1;

        int c = calculator.division(a, b);

        assertTrue(c > 0);
        assertEquals(15, c);
        assertEquals(c, a / b);
        assertEquals(c, a);
    }
    @Test
    void divisionDosNegTest() {
        int a = -15;
        int b = -3;

        int c = calculator.division(a, b);

        assertTrue(c > 0);
        assertEquals(5, c);
        assertEquals(c, a / b);
    }

    @Test
    void divisionMismoNumTest() {
        int a = 3;
        int b = 3;

        int c = calculator.division(a, b);

        assertTrue(c > 0);
        assertEquals(1, c);
        assertEquals(c, a / b);
    }
    @Test
    void divisionPorCeroTest() {

            int a = -15;
            int b = 0;

        try {
            int c = calculator.division(a, b);
        } catch (ArithmeticException e) {
            assertEquals(e.getMessage(), "/ by zero");
        }
    }


}
