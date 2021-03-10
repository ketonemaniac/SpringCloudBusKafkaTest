
# Kafka Bundle Docker Image
I used this one
https://docs.confluent.io/current/quickstart/ce-docker-quickstart.html

`git clone https://github.com/confluentinc/examples`

The following differs from original documentation (`PRIMARY KEY` keyword is not supported, use `key=` instead):

`CREATE TABLE users (userid BIGINT, registertime BIGINT, gender VARCHAR, regionid VARCHAR) WITH
     (KAFKA_TOPIC='users', VALUE_FORMAT='AVRO', key='userid');`

# Run
Start
`docker-compose up`

Stop
`docker-compose down`

Status
`docker-compose ps`

cleaning images (you have to download them again when doing `docker-compose up`)
`docker-compose down -v --rmi all --remove-orphans`
or
`docker system prune`


## Components
- zookeeper stores the configs
- broker is the Kafka instance
- schema-registry are schemas for connect-datagen below
- connect is a plugin to generate data with certain "quickstart" predefined formats in the schema-registry
- control-center is the UI
    * Control Center web interface is at http://localhost:9021
- ksql-server is the tool which you could create streams/tables using a SQL-like syntax
- ksql-cli is the command line interface to KSQL (this is useless because it's in docker?)
- rest-proxy exposes web endpoints to query Kafka status
    * see https://docs.confluent.io/3.0.0/kafka-rest/docs/intro.html# 
    * e.g. http://localhost:8082/topics
