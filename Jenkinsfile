pipeline {
    agent any

    stages {
        stage('Pobranie kodu') {
            steps {
                git branch: 'master', url: 'https://github.com/itdrabik/api-testing-framework.git'
            }
        }

        stage('Budowanie') {
            steps {
                sh 'mvn clean package'
            }
        }

        stage('Uruchamianie testów') {
            steps {
                sh 'mvn test'
            }
        }

        stage('Publikacja raportów') {
            steps {
                junit '**/target/surefire-reports/*.xml'
            }
        }
    }
}
