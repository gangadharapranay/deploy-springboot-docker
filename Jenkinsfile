pipeline {
    agent {
        docker {
            image 'maven:3.9.6-eclipse-temurin-21'
        }
    }

    environment {
        DOCKER_IMAGE = "springboot-app"
    }

    stages {
        stage('Clone') {
            steps {
                git branch: 'main', url: 'https://github.com/gangadharapranay/deploy-springboot-docker.git'
            }
        }

        stage('Build') {
            steps {
                sh 'mvn clean install -DskipTests -Dmaven.repo.local=./.m2'
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
