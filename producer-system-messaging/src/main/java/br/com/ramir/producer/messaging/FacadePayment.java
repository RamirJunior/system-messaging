package br.com.ramir.producer.messaging;

import com.fasterxml.jackson.core.JsonProcessingException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class FacadePayment {

    @Autowired
    private ProducerRequestPayment producer;

    public String requestPayment(Payment payment) {
        try {
            producer.integrate(payment);
        } catch (JsonProcessingException e) {
            return "Error during request payment" + e.getMessage();
        }
        return "waiting processing result...";
    }

    public void generateError(String payload) {
        System.err.println("ERROR =========> "+ payload);
    }

    public void generateSuccess(String payload) {
        System.out.println("SUCCESS =========> "+ payload);
    }
}
