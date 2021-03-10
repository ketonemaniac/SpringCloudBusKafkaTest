# Kafka Cloud Bus
Based on https://www.youtube.com/watch?v=1JCGJouZD2Q

However it does not work off the shelf. Gotta apply this fix first:
https://github.com/spring-cloud/spring-cloud-bus/issues/188

Thanks, I've solved this problem by constructing the custom message using BusProperties when sending the custom message. 


