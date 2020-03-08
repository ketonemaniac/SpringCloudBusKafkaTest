package net.ketone.springcloudbustest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.bus.BusProperties;
import org.springframework.context.ApplicationContext;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class CloudRestController {

    @Autowired
    private ApplicationContext context;

    @Autowired
    private BusProperties busProperties;

    @PutMapping(value="/publish")
    public String publishMessage() {
        final String uniqueId = context.getId();
        final MyCustomRemoteEvent event = new MyCustomRemoteEvent(this, busProperties.getId(), "Hello World!");
        context.publishEvent(event);
        return "Event Published.";
    }

}
