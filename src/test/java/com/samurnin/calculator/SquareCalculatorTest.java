package com.samurnin.calculator;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringRunner;

import static org.assertj.core.api.Assertions.assertThat;

@RunWith(SpringRunner.class)
@ContextConfiguration(classes = {CalculatorConfiguration.class})
public class SquareCalculatorTest {

    @Autowired
    private SquareCalculatorFacade calculator;

    @Test
    public void when_2_then_4() {
        assertThat(calculator.square(2)).isEqualTo(4);
    }

    @Test
    public void when_3_then_9() {
        assertThat(calculator.square(3)).isEqualTo(9);
    }
}