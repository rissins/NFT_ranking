pipeline {
    agent any

    stages {
        stage("github clone") {
             steps {
                    git branch: 'master', credentialsId: 'e4a83cb0-ac07-4de5-b54d-238d23b8c166', url: 'https://github.com/team-don/NFT_ranking'
             }
        }
    }
}