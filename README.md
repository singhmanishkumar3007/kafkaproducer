# kafkaproducer




Assuming that you have jdk 8 installed already let us start with installing and configuring zookeeper on Windows. Download zookeeper from https://zookeeper.apache.org/releases.html. I have downloaded zookeeper version 3.4.10 as in the kafka lib directory, the existing version of zookeeper is 3.4.10.Once downloaded, follow following steps:

Extract it and in my case I have extracted kafka and zookeeper in following directory:
D:\softwares\kafka_2.12-1.0.1 --kafka location D:\softwares\kafka-new\zookeeper-3.4.10 --zookeeper location

Once this is extracted, let us add zookeeper in the environment variables.For this go to Control Panel\All Control Panel Items\System and click on the Advanced System Settings and then Environment Variables and then edit the system variables as below:
zookeeper-windows-config

Also, edit the PATH variable and add new entry as %ZOOKEEPER_HOME%\bin\ for zookeeper.

Rename file D:\softwares\kafka-new\zookeeper-3.4.10\zookeeper-3.4.10\conf\zoo_sample.cfg to zoo.cfg

Now, in the command prompt, enter the command zkserver and the zookeeper is up and running on http://localhost:2181

zookeeper-console

Kafka Setup On windows -

Head over to http://kafka.apache.org/downloads.html and download Scala 2.12. This version has scala and zookepper already included in it.Follow below steps to set up kafka.

Unzip the downloaded binary. In my case it is - D:\softwares\kafka_2.12-1.0.1

Go to folder D:\softwares\kafka_2.12-1.0.1\config and edit server.properties

log.dirs=.\logs

Now open a new terminal at D:\softwares\kafka_2.12-1.0.1.

Execute .\bin\windows\kafka-server-start.bat .\config\server.properties to start Kafka. Since, we have not made any changes in the default configuration, Kafka should be up and running on http://localhost:9092

running-kafka-console

Let us create a topic with a name manish-test

cd D:\softwares\kafka_2.12-1.0.1\bin\windows

kafka-topics.bat --create --zookeeper localhost:2181 --replication-factor 1 --partitions 1 --topic manish-test

Above command will create a topic named manish-test with single partition and hence with a replication-factor of 1. This will be a single node - single broker kafka cluster.

Command to check messages in kakfa topic-

bin/kafka-console-consumer.sh --bootstrap-server localhost:9092 --topic manish-test --from-beginning

