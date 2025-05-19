@Library(value = 'jenkins-shared-library@master') _

node {
    config = cipipeline("ci.yaml")
}

pipeline {
    agent any
    stages {
        stage('Build') {
            steps {
                script {
                    echo "Building ${config.name}"
                }
            }
        }
        stage('Test') {
            steps {
                script {
                    echo "Running tests for ${config.name}"
                }
            }
        }
        stage('Deploy') {
            steps {
                script {
                    echo "Deploying ${config.name}"
                }
            }
        }
    }
}
