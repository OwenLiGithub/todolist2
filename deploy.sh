#!/bin/bash
set -e

pid=$(lsof -t -i:8080)
if [ -z "$pid" ]
then
      echo "\$pid is NULL"
else
      echo "\$pid is NOT NULL"
      kill -9 $pid
fi
cp -f build/libs/todolist-0.0.1-SNAPSHOT.jar /var/lib/jenkins/todolist-0.0.1-SNAPSHOT.jar
java -jar /var/lib/jenkins/todolist-0.0.1-SNAPSHOT.jar &
