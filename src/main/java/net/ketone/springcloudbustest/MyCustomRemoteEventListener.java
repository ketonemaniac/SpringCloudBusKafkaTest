package net.ketone.springcloudbustest;

import org.springframework.context.ApplicationListener;
import org.springframework.stereotype.Component;

@Component
public class MyCustomRemoteEventListener implements ApplicationListener<MyCustomRemoteEvent>{

    @Override
    public void onApplicationEvent(MyCustomRemoteEvent myCustomRemoteEvent) {
        System.out.println("Received Message:" + myCustomRemoteEvent.getMessage());
    }
}
