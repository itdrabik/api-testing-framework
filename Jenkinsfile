pipeline {
    agent any

    tools {
        maven 'Maven' // Ensure Maven is configured in Jenkins -> Global Tool Configuration
    }

    stages {
        stage('Checkout Code') {
            steps {
                git branch: 'master', url: 'https://github.com/itdrabik/api-testing-framework.git'
            }
        }

        stage('Build') {
            steps {
                bat 'mvn clean package' // Build the project using Maven
            }
        }

        stage('Run Tests') {
            steps {
                bat 'mvn test' // Execute tests using Maven
            }
        }

        stage('Publish Test Reports') {
            steps {
                junit '**/target/surefire-reports/*.xml' // Publish JUnit test results
            }
        }
    }

    post {
        always {
            echo 'Pipeline execution completed'
        }
        success {
            echo 'Build completed successfully!'
        }
        failure {
            echo 'Build failed!'
        }
    }
}
