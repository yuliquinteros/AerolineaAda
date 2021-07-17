package com.ada.aerolineaf.aerolineaV1.service.impl;

import com.ada.aerolineaf.aerolineaV1.service.ICalculator;

public class CalculatorImpl implements ICalculator {

    @Override
    public int suma(int a, int b) {
        int c = 0;
        try {
            c = a + b;
        } catch (NullPointerException e) {
            System.out.println("es nulo");
        }

        return a + b;
    }

    @Override
    public int resta(int a, int b) {
        return a - b;
    }

    @Override
    public int multiplicacion(int a, int b) {
        return a * b;
    }

    @Override
    public int division(int a, int b) {
        return  a / b;
    }
}
