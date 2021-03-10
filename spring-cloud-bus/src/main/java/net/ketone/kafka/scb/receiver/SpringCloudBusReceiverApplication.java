package net.ketone.kafka.scb.receiver;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.bus.jackson.RemoteApplicationEventScan;

/**
 * VM options -Dspring.profiles.active=recv to avoid port collision
 */
@SpringBootApplication
@RemoteApplicationEventScan(basePackages = {"net.ketone.kafka.scb.model"})
public class SpringCloudBusReceiverApplication {

	public static void main(String[] args) {
		SpringApplication.run(SpringCloudBusReceiverApplication.class, args);
	}

}
