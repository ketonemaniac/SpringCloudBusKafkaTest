package net.ketone.kafka.scb.model;

import lombok.Data;
import org.springframework.cloud.bus.event.RemoteApplicationEvent;

@Data
public class MyCustomRemoteEvent extends RemoteApplicationEvent {

    private String message;

    public MyCustomRemoteEvent() {}

    public MyCustomRemoteEvent(Object source, String originService, String message) {
        super(source, originService);
        this.message = message;
    }

}
