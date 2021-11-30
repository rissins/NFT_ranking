pipeline {
    agent any

    stages {
        stage("github clone") {
             steps {
                    git branch: 'master', credentialsId: '9d7ec4ae-eaac-47ac-82dd-f8bf482019c9', url: 'https://github.com/team-don/NFT_ranking'
             }
        }
    }
}