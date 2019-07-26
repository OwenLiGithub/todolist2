export BUILD_ID=dontKillMe

pid=$(lsof -t -i:8080)
if [ -z "$pid" ]
then
      echo "\$pid is NULL"
else
      echo "\$pid is NOT NULL"
      kill -9 $pid
fi
cp -f build/libs/todolist-0.0.1-SNAPSHOT.jar /var/lib/jenkins/todolist-0.0.1-SNAPSHOT.jar
JENKINS_NODE_COOKIE=donotKillMe nohup java -jar /var/lib/jenkins/todolist-0.0.1-SNAPSHOT.jar &
