package com.samurnin.calculator;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringRunner;

import static org.assertj.core.api.Assertions.assertThat;

@RunWith(SpringRunner.class)
@ContextConfiguration(classes = {CalculatorClientConfiguration.class})
public class CalculatorClientTest {

    @Autowired
    private CalculatorClient calculatorClient;

    @Test
    public void when1add2_then3() {
        assertThat(calculatorClient.add(1, 2).getAddResult()).isEqualTo(3);
    }

    @Test
    public void when2multiply3_then6() {
        assertThat(calculatorClient.multiply(2, 3).getMultiplyResult()).isEqualTo(6);
    }

    @Test
    public void when5subtract1_then4() {
        assertThat(calculatorClient.subtract(5, 1).getSubtractResult()).isEqualTo(4);
    }

    @Test
    public void when6divide2_then3() {
        assertThat(calculatorClient.divide(6, 2).getDivideResult()).isEqualTo(3);
    }
}