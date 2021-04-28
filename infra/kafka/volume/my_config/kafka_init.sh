cd /kafka/
rm config/server.properties
cp /data/kafka/my_server.properties config/server.properties
bin/kafka-server-start.sh -daemon config/server.properties
