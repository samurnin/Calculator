package com.samurnin.calculator;

import com.samurnin.calculator.wsdl.Multiply;
import com.samurnin.calculator.wsdl.MultiplyResponse;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.ws.client.core.support.WebServiceGatewaySupport;
import org.springframework.ws.soap.client.core.SoapActionCallback;

public class SquareCalculator extends WebServiceGatewaySupport implements SquareCalculatorFacade {

    private static final Logger log = LoggerFactory.getLogger(SquareCalculator.class);

    @Override
    public int square(int a) {
        log.info("Requesting square operation for " + a);
        return multiply(a, a);
    }

    private int multiply(int intA, int intB) {
        Multiply request = new Multiply();
        request.setIntA(intA);
        request.setIntB(intB);

        log.info("Requesting multiply operation for " + intA + " and " + intB);

        MultiplyResponse response = (MultiplyResponse) getWebServiceTemplate().marshalSendAndReceive(
                "http://www.dneonline.com/calculator.asmx",
                request, new SoapActionCallback("http://tempuri.org/Multiply"));
        return response.getMultiplyResult();
    }
}
