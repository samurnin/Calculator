package com.samurnin.calculator;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;

import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;

@RunWith(MockitoJUnitRunner.class)
public class CachedSquareCalculatorTest {

    @Mock
    private SquareCalculator squareCalculator;

    @InjectMocks
    private CachedSquareCalculator cachedSquareCalculator;

    @Test
    public void whenResultAlreadyCached_thenDontCallWs() {
        cachedSquareCalculator.square(5);
        cachedSquareCalculator.square(5);
        verify(squareCalculator, times(1)).square(5);
    }
}