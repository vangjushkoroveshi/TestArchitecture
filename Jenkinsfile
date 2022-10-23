pipeline {
    // master executor should be set to 0
    agent any
    stages {
        stage('Build Jar') {
            steps {
                //sh
                bat "mvn clean package -DskipTests"
            }
        }
        stage('Build Image') {
            steps {
                //sh
                bat "docker build -t=adelaceri/testarchitecture ."
            }
        }
        stage('Push Image') {
            steps {
			    withCredentials([usernamePassword(credentialsId: 'dockerhub', passwordVariable: 'pass', usernameVariable: 'user')]) {
                    //sh
                    bat "echo ${user}  / ${pass}"
			        bat "docker login --username=${user} --password=${pass}"
			        bat "docker push adelaceri/testarchitecture:latest"
			    }
            }
        }
    }
}