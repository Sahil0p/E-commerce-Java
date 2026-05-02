pipeline {
    agent any

    environment {
        // Define your Tomcat webapps directory path here
        TOMCAT_WEBAPPS_DIR = 'C:\\Program Files\\Apache Software Foundation\\Tomcat 9.0\\webapps'
    }

    stages {
        stage('Checkout') {
            steps {
                checkout scm
            }
        }

        stage('Build') {
            steps {
                // Uses Maven to build the .war file
                // If you are on Linux, change 'bat' to 'sh'
                bat 'mvn clean package'
            }
        }

        stage('Deploy to Tomcat') {
            steps {
                echo 'Deploying ecommerce-app.war to Tomcat...'
                // Copies the generated WAR file directly into the Tomcat webapps directory
                // For Linux, change to: sh "cp target/todo-app.war ${TOMCAT_WEBAPPS_DIR}/"
                bat "copy /Y target\\ecommerce-app.war \"${TOMCAT_WEBAPPS_DIR}\\ecommerce-app.war\""
            }
        }
    }
    
    post {
        success {
            echo 'Successfully built and deployed to Tomcat!'
        }
        failure {
            echo 'Pipeline failed. Check the logs.'
        }
    }
}
