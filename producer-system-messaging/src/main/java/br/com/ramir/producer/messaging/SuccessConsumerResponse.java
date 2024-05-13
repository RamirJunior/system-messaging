package br.com.ramir.producer.messaging;

import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.messaging.Message;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;

@Component
public class SuccessConsumerResponse {

    @Autowired
    private FacadePayment facadePayment;

    @RabbitListener(queues = {"payment-response-success-queue"})
    public void receptSuccess(@Payload Message message){
        System.out.println("Message "+ message + " - " + LocalDateTime.now());
        String payload = String.valueOf(message.getPayload());

        facadePayment.generateSuccess(payload);
    }
}
