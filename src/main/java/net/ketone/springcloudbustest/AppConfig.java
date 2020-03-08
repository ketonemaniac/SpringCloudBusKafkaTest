package net.ketone.springcloudbustest;

import org.springframework.cloud.bus.jackson.RemoteApplicationEventScan;
import org.springframework.context.annotation.Configuration;

@Configuration
@RemoteApplicationEventScan(basePackages = {"net.ketone"})
public class AppConfig {
}
