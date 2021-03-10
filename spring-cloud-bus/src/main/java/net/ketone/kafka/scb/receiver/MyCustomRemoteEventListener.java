package net.ketone.kafka.scb.receiver;

import lombok.extern.slf4j.Slf4j;
import net.ketone.kafka.scb.model.MyCustomRemoteEvent;
import org.springframework.context.ApplicationListener;
import org.springframework.stereotype.Component;

import java.util.concurrent.atomic.AtomicInteger;

/**
 * This takes the receiving event
 */
@Slf4j
@Component
public class MyCustomRemoteEventListener implements ApplicationListener<MyCustomRemoteEvent>{

    private AtomicInteger count = new AtomicInteger();

    @Override
    public void onApplicationEvent(MyCustomRemoteEvent myCustomRemoteEvent) {
        log.info("Received Message: {} {}", myCustomRemoteEvent.getMessage(), count.incrementAndGet());
    }
}
