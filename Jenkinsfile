pipeline {
    agent any

    environment {
        DOCKER_IMAGE = "ajay222006/business-analytics-reporting"
        DOCKER_TAG   = "latest"
    }

    stages {

        stage('Clone Repository') {
            steps {
                git branch: 'main',
                    url: 'https://github.com/Ajay222006/Business-Analytics-Reporting.git'
            }
        }

        stage('Build') {
            steps {
                bat 'mvn clean package -DskipTests'
            }
        }

        stage('Test') {
            steps {
                bat 'mvn test'
            }
            post {
                always {
                    junit 'target/surefire-reports/*.xml'
                }
            }
        }

        stage('Docker Build') {
            steps {
                bat "docker build -t ${DOCKER_IMAGE}:${DOCKER_TAG} ."
            }
        }

        stage('Docker Push') {
            steps {
                withCredentials([usernamePassword(
                    credentialsId: 'dockerhub-credentials-ID',
                    usernameVariable: 'DOCKER_USER',
                    passwordVariable: 'DOCKER_PASS'
                )]) {
                    powershell '''
                        # Create docker config directory
                        $configDir = "$env:USERPROFILE/.docker"
                        if (-not (Test-Path $configDir)) {
                            New-Item -ItemType Directory -Path $configDir -Force | Out-Null
                        }
                        
                        # Create auth token
                        $auth = [Convert]::ToBase64String([Text.Encoding]::UTF8.GetBytes("$env:DOCKER_USER" + ":" + "$env:DOCKER_PASS"))
                        
                        # Create config.json
                        $config = @{
                            auths = @{
                                "https://index.docker.io/v1/" = @{
                                    auth = $auth
                                }
                            }
                        } | ConvertTo-Json
                        
                        $config | Set-Content -Path "$configDir/config.json" -Force
                        Write-Output "Docker config created"
                    '''
                    powershell "docker push ${DOCKER_IMAGE}:${DOCKER_TAG}"
                }
            }
        }

        stage('Deploy to Kubernetes') {
            steps {
                bat 'kubectl apply -f k8s/deployment.yaml'
                bat 'kubectl apply -f k8s/service.yaml'
            }
        }

    }

    post {
        success {
            echo '✅ Pipeline completed successfully!'
        }
        failure {
            echo '❌ Pipeline failed. Check logs above.'
        }
    }
}
