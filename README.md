A [Giter8][g8] template for showcasing transformation on a Kafka topic with the help of Flink Streaming.

Kafka Transformation with Flink Streaming
---

### Steps to install Zookeeper and Apache Kafka:

Step 1: Download Kafka

Download Kafka from [here](https://www.apache.org/dyn/closer.cgi?path=/kafka/2.2.0/kafka-2.2.0-src.tgz)

Step 2: Extract downloaded file

```bash
tar -xzvf kafka-2.2.0.tgz
cd kafka-2.2.0
```
### Steps to start Zookeeper and Kafka server :

Start Zookeeper:

```bash
bin/zookeeper-server-start.sh config/zookeeper.properties
```

Start Kafka server:

```bash
bin/kafka-server-start.sh config/server.properties
```


---
### Clone Project

```bash
git clone git@github.com:knoldus/kafka-flink-data-pipeline.g8.git
cd kafka-flink-data-pipeline.g8
sbt clean compile
```
---

Execute the following command,

```bash
sbt "runMain com.knoldus.demo.KafkaProducer"
```
This starts producing random messages in the range 1 to 100 and push each of it into a Kafka topic queue.

---
### Transforming the incoming messages

Step 1:
Execute the following command,

```bash
sbt "runMain com.knoldus.demo.StreamDemo"
```

This begins Flink stream processing on the input kafka topic and transforms the messages by capitializing it and produces to a new output topic.


---
For any issue please raise a ticket @ [Github Issue](https://github.com/knoldus/kafka-flink-data-pipeline.g8/issues)

Template license
----------------
Written in 2019 by Himani Arora

To the extent possible under law, the author(s) have dedicated all copyright and related
and neighboring rights to this template to the public domain worldwide.
This template is distributed without any warranty. See <http://creativecommons.org/publicdomain/zero/1.0/>.

[g8]: http://www.foundweekends.org/giter8/