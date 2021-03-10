based on https://www.baeldung.com/spring-boot-kafka-testing

You have to create the topic `embedded-test-topic` yourself. Spring-kafka does not create the topic for you.

This is the only modification I have to make:
https://stackoverflow.com/questions/60012661/spring-boot-kafka-newbie-question-on-serializing-deserializing

