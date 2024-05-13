package br.com.ramir.producer.messaging;

import org.springframework.amqp.rabbit.annotation.EnableRabbit;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@EnableRabbit
@SpringBootApplication
public class ProducerSystemMessagingApplication {

	public static void main(String[] args) {
		SpringApplication.run(ProducerSystemMessagingApplication.class, args);
	}
}
