pipeline {
    agent any

    tools{
        gradle 'gradle_new'
        jdk 'jdk17'
    }

    stages {

        stage('Checkout') {
            steps {
                // Check out the Git repository
                git changelog: false, poll: false, url: 'https://github.com/Danith94/gradle_project_scan.git'
            }
        }

        stage('PWD') {

            sh 'pwd'

        }

        stage('Build') {
            steps {
                 // Build your project (e.g., compile, package, etc.)
                  withGradle() {
                        sh 'gradle --version'
                        sh './gradlew clean build'
                }

            }
        }

        stage('Dependency-Check') {
            steps {
                // Invoke OWASP Dependency-Check
                // Ensure that OWASP Dependency-Check is available in the system PATH
//                 dependencyCheck additionalArguments: '--project WORKSPACE', odcInstallation: 'SCA'
//                 dependencyCheckPublisher pattern: 'dependency-check-report.xml'
                  dependencyCheck additionalArguments: '''
                              -o './'
                              -s './'
                              -f 'ALL'
                              --prettyPrint''', odcInstallation: 'test-dp'

                  dependencyCheckPublisher pattern: 'dependency-check-report.xml'
            }
        }
    }
}