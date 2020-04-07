package com.samurnin.calculator;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.HashMap;
import java.util.Map;

public class CachedSquareCalculator extends SquareCalculatorDecorator {

    private static final Logger log = LoggerFactory.getLogger(CachedSquareCalculator.class);
    private Map<Integer, Integer> cache;

    public CachedSquareCalculator(SquareCalculatorFacade squareCalculator) {
        super(squareCalculator);
        cache = new HashMap<>();
    }

    @Override
    public int square(int a) {
        log.info("Checking cache first...");
        return cache.computeIfAbsent(a, k -> decoratedSquareCalculator.square(a));
    }
}
