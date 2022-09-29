pipeline {
    agent any
    
    
    environment{
    
    DOCKER_IMG_NAME = 'user-service'
    DOCKER_TMP_CONTAINER_NAME = 'tmp-user-service-container'
    }

    stages {
        stage('clean') {
            steps {
               sh 'mvn clean'

            }
        }
        
         stage('compile') {
            steps {
               
                sh 'mvn compile'

            }
        }
        
         stage('test') {
            steps {
               
                sh 'mvn test'

            }
        }
        
         stage('build') {
            steps {
               
                sh 'mvn package -DskipTests=true'

            }
        }
        
        stage('dockerize') {
            steps {
               
                sh "docker build -t ${DOCKER_IMG_NAME}:latest -t ${DOCKER_IMG_NAME}:${env.BUILD_ID}"

            }
        }
        
        stage('integration tests') {
            steps {
               
                sh 'docker run -dp 7070:8080 --rm --name ${DOCKER_TMP_CONTAINER_NAME} ${DOCKER_IMG_NAME}:latest'
                
                sleep 30
                
                sh 'curl -i http://localhost:7070/api/users'
                

            }
        }
               
    }
    
    post {
            always {
               
                sh 'docker stop ${DOCKER_TMP_CONTAINER_NAME}'
                
                sh "docker rmi ${DOCKER_IMG_NAME}:latest ${DOCKER_IMAGE_NAME}:${env.BUILD_ID}"

            }
        }
}
