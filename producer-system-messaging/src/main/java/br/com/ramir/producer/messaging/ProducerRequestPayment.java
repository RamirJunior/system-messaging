package br.com.ramir.producer.messaging;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.amqp.core.AmqpTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class ProducerRequestPayment {

    @Autowired
    private AmqpTemplate amqpTemplate;

    private final ObjectMapper objectMapper = new ObjectMapper();

    public void integrate(Payment payment) throws JsonProcessingException {
        amqpTemplate.convertAndSend(
                "payment-request-exchange",
                "payment-request-rout-key",
                objectMapper.writeValueAsString(payment)
        );
    }
}
