package net.ketone.kafka.scs;

import lombok.Data;

@Data
public class ChatMessage {

    private String contents;

    private Long time;

}
