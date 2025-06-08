pipeline {
    agent any
    
    environment {
        IMAGE_NAME = 'login-app'
        IMAGE_TAG = 'latest'
        DOCKER_REGISTRY = 'renuka1217' // or private registry
        DOCKER_USER = 'renuka1217'
        DOCKER_PASS = 'LMC86_pnsGmk?5Q'
        REMOTE_HOST = '192.168.23.131'
        REMOTE_PATH = '/home/renuka'
    }

    stages {
        stage('Checkout') {
            steps {
                git url: 'https://github.com/renuka1217/devops_practice_june2.git', branch: 'main'
            }
        }

        stage('Build JAR') {
            steps {
                sh 'chmod +x mvnw && ./mvnw clean package -DskipTests' // or ./gradlew build
            }
        }

        stage('Build Docker Image') {
            steps {
                sh "docker build -t ${DOCKER_REGISTRY}/${IMAGE_NAME}:${IMAGE_TAG} ."
            }
        }

        stage('Push Docker Image') {
            steps {
                withCredentials([usernamePassword(credentialsId: 'dockerhubcredentials', usernameVariable: 'renuka1217', passwordVariable: 'LMC86_pnsGmk?5Q')]) {
                    sh 'echo $DOCKER_PASS | docker login -u $DOCKER_USER --password-stdin'
                    sh "docker push ${DOCKER_REGISTRY}/${IMAGE_NAME}:${IMAGE_TAG}"
                }
            }
        }
        stage('Copy Files to VM') {
            steps {
                withCredentials([usernamePassword(credentialsId: 'vm-ssh', usernameVariable: 'USER', passwordVariable: 'PASS')]) {
                    sh '''
                        sshpass -p "$PASS" scp -o StrictHostKeyChecking=no -r deploy.sh $USER@$REMOTE_HOST:/home/$USER
                        sshpass -p "$PASS" scp -o StrictHostKeyChecking=no -r docker-compose.yml $USER@$REMOTE_HOST:/home/$USER
                        sshpass -p "$PASS" scp -o StrictHostKeyChecking=no -r logapp-env.list $USER@$REMOTE_HOST:/home/$USER
                    '''
                }
            }
        }

        stage('Deploy') {
            steps {
                withCredentials([usernamePassword(credentialsId: 'vm-ssh', usernameVariable: 'USER', passwordVariable: 'PASS')]) {
                    sh '''
                        sshpass -p "$PASS" ssh -o StrictHostKeyChecking=no $USER@$REMOTE_HOST "
                            cd $REMOTE_PATH &&
                            chmod +x deploy.sh &&
                            chmod +x docker-compose.yml &&
                            chmod +x logapp-env.list &&
                            ./deploy.sh
                        "
                    '''
                }
			}
        }

      //  stage('Deploy (Optional)') {
       //     when {
        //        expression { return fileExists('docker-compose.yml') }
         //   }
          //  steps {
          //      sh 'docker-compose up -d'
         //   }
        // }
     }

    // post {
      //   always {
       //      echo 'Pipeline completed.'
       //  }
    // }
}
