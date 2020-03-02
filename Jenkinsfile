#!groovy

pipeline {
    agent any

    stages {
        stage('Checkout') {
            steps {
                script {
                    sh "rm -rf build/"
                    sh "rm -rf .gradle/"
                    sh "chmod +x gradlew"
                }
            }
        }
        stage('Run API Tests') {
            steps {
                withEnv(["ENV=${params.ENVIRONMENT}"]) {
                    script {
                        sh "./gradlew build"
                    }
                }
            }
        }
    }
}
