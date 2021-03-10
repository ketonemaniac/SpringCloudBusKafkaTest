package net.ketone.kafka.scs;

import lombok.Data;
import org.springframework.cloud.stream.annotation.EnableBinding;
import org.springframework.cloud.stream.messaging.Source;

@Data
@EnableBinding(Source.class)
public class Producer {

    public Producer(final Source source) {
        super();
        this.mySource = source;
    }

    private Source mySource;

}
