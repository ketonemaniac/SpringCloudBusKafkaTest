package net.ketone.springcloudbustest;

import org.springframework.cloud.bus.event.RemoteApplicationEvent;

public class MyCustomRemoteEvent extends RemoteApplicationEvent {

    private static long serialVersionUID = 1L;
    private String message;

    public MyCustomRemoteEvent() {}

    public MyCustomRemoteEvent(Object source, String originService, String message) {
        super(source, originService);
        this.message = message;
    }

    public String getMessage() {
        return message;
    }

    public MyCustomRemoteEvent setMessage(String message) {
        this.message = message;
        return this;
    }

}
