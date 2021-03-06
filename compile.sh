#! /bin/sh


# cd src
# javac -d bin -sourcepath . -cp "lib/mysql-connector-java-5.1.23-bin.jar" */*.java
# javac -d bin -sourcepath . -bootclasspath lib/mysql-connector-java-5.1.23-bin.jar */*.java

# java -cp ../lib/mysql-connector-java-5.1.23-bin.jar:. server.InterfaceServer
# java -cp ../lib/mysql-connector-java-5.1.23-bin.jar:. client.InterfaceClient

rm *.jar
rm */*.class

# javac -cp .:lib/mysql-connector-java-5.1.45-bin.jar */*.java
javac */*.java
# rm */*.class
jar cfm InterfaceServer.jar Manifest_server.txt */*
jar cfm InterfaceClient.jar Manifest_client.txt */*
# jar cvfe InterfaceServer.jar server.InterfaceServer */*

rm */*.class
