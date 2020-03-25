package com.samurnin.calculator;

import com.samurnin.calculator.wsdl.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.ws.client.core.support.WebServiceGatewaySupport;
import org.springframework.ws.soap.client.core.SoapActionCallback;

public class CalculatorClient extends WebServiceGatewaySupport {

    private static final Logger log = LoggerFactory.getLogger(CalculatorClient.class);

    public AddResponse add(int intA, int intB) {
        Add request = new Add();
        request.setIntA(intA);
        request.setIntB(intB);

        log.info("Requesting add operation for " + intA + " and " + intB);

        return (AddResponse) getWebServiceTemplate().marshalSendAndReceive(
                "http://www.dneonline.com/calculator.asmx",
                request, new SoapActionCallback("http://tempuri.org/Add"));
    }

    public SubtractResponse subtract(int intA, int intB) {
        Subtract request = new Subtract();
        request.setIntA(intA);
        request.setIntB(intB);

        return (SubtractResponse) getWebServiceTemplate().marshalSendAndReceive(
                "http://www.dneonline.com/calculator.asmx",
                request, new SoapActionCallback("http://tempuri.org/Subtract"));
    }

    public MultiplyResponse multiply(int intA, int intB) {
        Multiply request = new Multiply();
        request.setIntA(intA);
        request.setIntB(intB);

        return (MultiplyResponse) getWebServiceTemplate().marshalSendAndReceive(
                "http://www.dneonline.com/calculator.asmx",
                request, new SoapActionCallback("http://tempuri.org/Multiply"));
    }

    public DivideResponse divide(int intA, int intB) {
        Divide request = new Divide();
        request.setIntA(intA);
        request.setIntB(intB);

        return (DivideResponse) getWebServiceTemplate().marshalSendAndReceive(
                "http://www.dneonline.com/calculator.asmx",
                request, new SoapActionCallback("http://tempuri.org/Divide"));
    }
}
