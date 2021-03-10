package net.ketone.kafka.springkafka;

import lombok.Data;
import lombok.extern.slf4j.Slf4j;
import org.apache.kafka.clients.consumer.ConsumerRecord;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Component;

import java.util.concurrent.CountDownLatch;

@Slf4j
@Component
@Data
public class KafkaConsumer {

    private CountDownLatch latch = new CountDownLatch(1);

    private String payload = null;

    @KafkaListener(topics = "${test.topic}", groupId = "spring-kafka-consumer")
    public void receive(ConsumerRecord<?, ?> consumerRecord) {
        log.info("received payload='{}'", consumerRecord.toString());
        setPayload(consumerRecord.toString());
        latch.countDown();
    }

}