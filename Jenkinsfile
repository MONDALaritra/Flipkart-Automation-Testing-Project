pipeline {
    agent any  // run on any available Jenkins agent
    
    stages {
        stage('Checkout') {
            steps {
                checkout scm
            }
        }
        stage('Build & Test') {
            steps {
                echo "Running Maven clean test on Jenkins agent"
                bat 'mvn clean test'  // use 'sh' on Linux agents
            }
        }
        stage('Publish Reports') {
            steps {
                junit '**/target/surefire-reports/*.xml'
                publishHTML([
                    allowMissing: false,
                    alwaysLinkToLastBuild: true,
                    keepAll: true,
                    reportDir: 'target',
                    reportFiles: 'ExtentReport.html',
                    reportName: 'Extent Report'
                ])
            }
        }
    }
    post {
        always {
            echo 'Cleaning workspace'
            cleanWs()
        }
    }
}
