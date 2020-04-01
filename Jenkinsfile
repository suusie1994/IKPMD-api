pipeline {
    agent any
    stages {
        stage('Build') {
            steps {
                sh 'echo "Hello World"'
                sh '''
                    echo "Multiline shell steps works too"
                    ls -lah
                '''
            }
        }
    }
}
pipeline {	pipeline {
    agent { docker { image 'maven:3.3.3' } }	    agent any
    stages {	    stages {
        stage('build') {	        stage('Build') {
            steps {	            steps {
                sh 'mvn --version'	                sh 'echo "Hello World"'
                sh '''
                    echo "Multiline shell steps works too"
                    ls -lah
                '''
            }	            }
        }	        }
    }
