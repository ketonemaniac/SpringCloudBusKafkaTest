package net.ketone.kafka.scf;

import lombok.extern.slf4j.Slf4j;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import reactor.core.publisher.Flux;

import java.time.Duration;
import java.util.Random;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Supplier;

@Slf4j
@Configuration
public class ApplicationConfiguration {

    // Publishes a random integer to the "ints" channel (as defined
    // in the application.yml file) every second.
    static class Source {

        @Bean
        public Supplier<Integer> send() {
            return () -> 1;
        }

        @Bean
        public Supplier<Flux<Integer>> sendFlux() {
            return () -> Flux.interval(Duration.ofSeconds(5))
                    .map(Long::intValue);
        }
    }

    @Bean
    public Consumer<String> receive() {
        return payload -> {
            log.info(payload);
        };
    }

    // Subscribes to the "ints" channel, calculating an
    // accumulated total, and publishing both to the "total" channel
    static class Accumulator {

        private AtomicInteger count = new AtomicInteger(0);

        @Bean
        public Function<Integer, String> accumulate() {
            return payload -> "Current value: " + payload + ", Total: " + this.count.addAndGet(payload);
        }

    }
}
