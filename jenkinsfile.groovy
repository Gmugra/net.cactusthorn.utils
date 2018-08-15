node {
  timeout(time: 3, unit: 'HOURS') {
    def mvnHome
    stage('Preparation') {
      // Get some code from a GitHub repository
      //git https://github.com/Gmugra/net.cactusthorn.utils.git
      //git branch: 'master', credentialsId: '8a2c5006-46dc-4a63-8559-d12dcaeb1528', url: 'https://github.com/Gmugra/net.cactusthorn.utils.git'
      git branch: 'master', url: 'https://github.com/Gmugra/net.cactusthorn.utils.git'

      mvnHome = tool 'Maven 3.5.3'
    }
    stage('Checkstyle') {
      if (isUnix()) {
         sh "'${mvnHome}/bin/mvn' -batch-mode -U -e checkstyle:check"
      } else {
         bat(/"${mvnHome}\bin\mvn" -batch-mode -U -e checkstyle:check/)
      }
    }
    stage('Build') {
      if (isUnix()) {
         sh "'${mvnHome}/bin/mvn' -batch-mode -U -e checkstyle:check"
      } else {
         //bat(/"${mvnHome}\bin\mvn" -Dmaven.test.failure.ignore clean package/)
         bat(/"${mvnHome}\bin\mvn" -batch-mode -U -e clean package/)
      }
    }
    stage('Results') {
        junit '**/target/surefire-reports/TEST-*.xml'
        archiveArtifacts artifacts: 'target/*.jar', fingerprint: true
    }
  }
}