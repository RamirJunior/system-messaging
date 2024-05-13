package br.com.ramir.producer.messaging;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/payment")
public class ApiPayment {

    @Autowired
    FacadePayment facadePayment;

    @PostMapping
    public String process(@RequestBody Payment payment) {
        return facadePayment.requestPayment(payment);
    }
}
