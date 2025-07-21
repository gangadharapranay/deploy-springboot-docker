pipeline {
    agent {
        docker {
            image 'maven:3.9.6-eclipse-temurin-21'
            args '-v $HOME/.m2:/root/.m2 --platform linux/amd64'
        }
    }

    environment {
        DOCKER_IMAGE = "springboot-app"
    }

    stages {
        stage('Clone') {
            steps {
                git branch: 'main', url: 'https://github.com/gangadharapranay/test.git'
            }
        }

        stage('Build') {
            steps {
                sh 'mvn -Dmaven.repo.local=target/.m2 clean install -DskipTests'
            }
        }

        stage('Build Docker Image') {
            steps {
                sh "docker build -t ${DOCKER_IMAGE} ."
            }
        }

        stage('Deploy') {
            steps {
                script {
                    sh 'docker-compose down || true'
                    sh 'docker-compose up -d --build'
                }
            }
        }
    }
}
