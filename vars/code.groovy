def call(String repoUrl, String branch = "main") {
    echo "Cloning repository: ${repoUrl}, branch: ${branch}"
    checkout([
        $class: 'GitSCM',
        branches: [[name: branch]],
        doGenerateSubmoduleConfigurations: false,
        extensions: [],
        userRemoteConfigs: [[url: repoUrl]]
    ])
}
