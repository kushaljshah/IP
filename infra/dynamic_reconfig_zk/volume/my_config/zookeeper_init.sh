#!/bin/bash

cd /kafka_2.13-2.6.0/
rm config/zookeeper.properties
cp /my_config/zookeeper.properties config/
bin/zookeeper-server-start.sh -daemon config/zookeeper.properties
