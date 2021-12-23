//pipeline {
//    agent any
//
//    stages {
//        stage("github clone") {
//             steps {
//                    git branch: 'master', credentialsId: '9d7ec4ae-eaac-47ac-82dd-f8bf482019c9', url: 'https://github.com/team-don/NFT_ranking'
//             }
//        }
//    }
//
//	stages {
//		stage("jar 패키징") {
//			steps {
//				ssh {
//					'./gradlew bootJar'
//				}
//			}
//		}
//	}
//
//	stages {
//		stage("aws 우분투로 파일 보내기") {
//			steps {
//				ssh {
//					'scp -i ~/.ssh/nftranking.pem build/libs/nft-1.jar ubuntu@3.35.135.61:~/'
//				}
//			}
//		}
//	}
//}