
pipeline {
    agent none

    stages {
        stage('Test') {
            agent {
                label 'master'
            }
            steps {
                sh '''
                    chmod +x ./gradlew
                    ./gradlew test
                '''
            }
        }
        stage('Build') {
            agent {
                label 'master'
            }
            steps {
                sh '''
                    chmod +x ./gradlew
                    ./gradlew build -x test
                '''
            }
        }
        stage('Deploy Dev') {
            agent {
                label 'master'
            }
            steps {
                sh '''
                    kill $(lsof -t -i:8080) || true
                    cp -f build/libs/todolist-0.0.1-SNAPSHOT.jar /var/lib/jenkins/todolist-0.0.1-SNAPSHOT.jar
                    nohup java -jar /var/lib/jenkins/todolist-0.0.1-SNAPSHOT.jar  > log.file  2>&1 &
                '''
            }
        }
        stage('Approve of Deploy Prod') {
          steps {
            input message: 'deploy to Prod?'
          }
        }

        stage('Deploy Prod') {
            agent {
                label 'master'
            }
            steps {
                sh '''
                    echo deploy prod
                '''
            }
        }
    }
}
