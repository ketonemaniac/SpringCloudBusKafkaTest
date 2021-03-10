package net.ketone.kafka.scs;

import lombok.extern.slf4j.Slf4j;
import org.springframework.cloud.stream.annotation.EnableBinding;
import org.springframework.cloud.stream.annotation.StreamListener;
import org.springframework.cloud.stream.messaging.Sink;
import org.springframework.messaging.handler.annotation.Payload;

import java.time.Instant;
import java.time.ZoneId;
import java.time.format.DateTimeFormatter;
import java.time.format.FormatStyle;

@Slf4j
@EnableBinding(Sink.class)
public class Consumer {

    @StreamListener(target = Sink.INPUT)
    public void consume(String message) {

        log.info("recieved a string message : " + message);
    }

    @StreamListener(target = Sink.INPUT, condition = "headers['type']=='chat'")
    public void handle(@Payload ChatMessage message) {

        final DateTimeFormatter df = DateTimeFormatter.ofLocalizedTime(FormatStyle.MEDIUM)
                .withZone(ZoneId.systemDefault());
        final String time = df.format(Instant.ofEpochMilli(message.getTime()));
        log.info("recieved a complex message : [{}]: {}", time, message.getContents());
    }
}
