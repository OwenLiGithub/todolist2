pipeline {
    agent none

    stages {
        stage('Test') {
            agent {
                label 'master'
            }
            steps {
                sh '''
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
                    echo deploy dev
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
