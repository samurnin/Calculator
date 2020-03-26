package com.samurnin.calculator;

public abstract class SquareCalculatorDecorator implements SquareCalculatorFacade {

    protected SquareCalculatorFacade decoratedSquareCalculator;

    public SquareCalculatorDecorator(SquareCalculatorFacade decoratedSquareCalculator) {
        this.decoratedSquareCalculator = decoratedSquareCalculator;
    }
}
