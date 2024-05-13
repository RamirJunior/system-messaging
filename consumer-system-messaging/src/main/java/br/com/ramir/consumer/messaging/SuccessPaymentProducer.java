package br.com.ramir.consumer.messaging;

import org.springframework.amqp.core.AmqpTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class SuccessPaymentProducer {

    @Autowired
    private AmqpTemplate amqpTemplate;

    public void generateResponse(String message){
        amqpTemplate.convertAndSend(
                "payment-response-success-exchange",
                "payment-response-success-rout-key",
                message
        );
    }
}
