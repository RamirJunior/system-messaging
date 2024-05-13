package br.com.ramir.consumer.messaging;

import org.springframework.amqp.rabbit.annotation.EnableRabbit;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@EnableRabbit
@SpringBootApplication
public class ConsumerSystemMessagingApplication {

	public static void main(String[] args) {
		SpringApplication.run(ConsumerSystemMessagingApplication.class, args);
	}

}
