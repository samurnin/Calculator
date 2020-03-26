package com.samurnin.calculator;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.oxm.jaxb.Jaxb2Marshaller;

@Configuration
public class SquareCalculatorConfiguration {

    @Bean
    public Jaxb2Marshaller marshaller() {
        final Jaxb2Marshaller marshaller = new Jaxb2Marshaller();
        marshaller.setContextPath("com.samurnin.calculator.wsdl");
        return marshaller;
    }

    @Bean
    public SquareCalculatorFacade calculator(Jaxb2Marshaller marshaller) {
        final SquareCalculator calculator = new SquareCalculator();
        calculator.setDefaultUri("http://www.dneonline.com/calculator.asmx");
        calculator.setMarshaller(marshaller);
        calculator.setUnmarshaller(marshaller);
        return calculator;
    }
}
