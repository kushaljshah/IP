#!/bin/bash

cd /kafka/
rm config/zookeeper.properties
cp /my_config/zookeeper.properties config/
bin/zookeeper-server-start.sh -daemon config/zookeeper.properties
