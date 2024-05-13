package br.com.ramir.consumer.messaging;

import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.messaging.Message;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.stereotype.Component;

import java.util.Random;

@Component
public class ConsumerRequestPayment {

    @Autowired
    private ErrorPaymentProducer errorProducer;

    @Autowired
    private SuccessPaymentProducer successProducer;

    @RabbitListener(queues = {"payment-request-queue"})
    public void receptMessage(@Payload Message message) {
        System.out.println(message);
        if (new Random().nextBoolean()){
            successProducer.generateResponse("Payment successfuly: " + message);
        } else {
            errorProducer.generateResponse("Payment failed: " + message);
        }
    }

}
