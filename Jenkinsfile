pipeline {
    agent any

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
                sh 'mvn clean package -DskipTests'
            }
        }

        stage('Build Docker Image') {
            steps {
                sh 'docker build -t $DOCKER_IMAGE .'
            }
        }

        stage('Deploy') {
            steps {
                sh 'docker-compose down || true'
                sh 'docker-compose up -d --build'
            }
        }
    }
}
