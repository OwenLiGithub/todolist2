kill $(lsof -t -i:8080) || true
cp -f build/libs/todolist-0.0.1-SNAPSHOT.jar /var/lib/jenkins/todolist-0.0.1-SNAPSHOT.jar
nohup java -jar /var/lib/jenkins/todolist-0.0.1-SNAPSHOT.jar  > log.file  2>&1 &
