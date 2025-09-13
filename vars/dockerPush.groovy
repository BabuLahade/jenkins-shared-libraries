def call(String imageName, String tag = "latest", String credentialsId) {
    echo "Pushing Docker image ${imageName}:${tag} to Docker Hub"
    withCredentials([usernamePassword(credentialsId: credentialsId, usernameVariable: 'DOCKERHUB_USER', passwordVariable: 'DOCKERHUB_PASS')]) {
        sh 'echo $DOCKERHUB_PASS | docker login -u $DOCKERHUB_USER --password-stdin'
        sh "docker image tag ${imageName}:${tag} $DOCKERHUB_USER/${imageName}:${tag}"
        sh "docker push $DOCKERHUB_USER/${imageName}:${tag}"
        sh 'docker logout'
    }
}
