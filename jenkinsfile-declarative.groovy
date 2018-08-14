pipeline {
  agent any
  tools {
    maven 'Maven 3.5.3'
  }
  stages {
    stage('Preparation') {
      steps {
        git branch: 'master', credentialsId: '8a2c5006-46dc-4a63-8559-d12dcaeb1528', url: 'https://github.com/Gmugra/net.cactusthorn.utils.git'
      }
    }
    stage('Checkstyle') {
      parallel {
        stage('Checkstyle Unix') {
          when {
            expression { isUnix() }
          }
          steps {
            sh "mvn -batch-mode checkstyle:check"
          }
        }
        stage('Checkstyle Windows') {
          when {
            expression { !isUnix() }
          }
          steps {
            bat "mvn -batch-mode checkstyle:check"
          }
        }
      }
    }
    stage('Build') {
      parallel {
        stage('Build Unix') {
          when {
            expression { isUnix() }
          }
          steps {
            sh "mvn -batch-mode clean package"
          }
        }
        stage('Build Windows') {
          when {
            expression { !isUnix() }
          }
          steps {
            bat "mvn -batch-mode clean package"
          }
        }
      }
    }
  }
  post { 
    always { 
      junit '**/target/surefire-reports/TEST-*.xml'
      archiveArtifacts artifacts: 'target/*.jar', fingerprint: true
    }
  }
}