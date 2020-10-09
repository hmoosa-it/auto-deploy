#!/usr/bin/env groovy
def call(String GIT_SOURCE_URL, String GIT_SOURCE_BRANCH, String GIT_CRED, String WORKSPACE_CHECKOUT_DIR) {

    echo "checkout $GIT_SOURCE_URL"
    checkout([
            $class: 'GitSCM',
            branches: [[name: "${GIT_SOURCE_BRANCH}"]],
            extensions: [[$class: 'RelativeTargetDirectory', relativeTargetDir: "${WORKSPACE_CHECKOUT_DIR}"]],
            userRemoteConfigs: [[ credentialsId: "${GIT_CRED}",
                                  url: "${GIT_SOURCE_URL}"]]])

    return this
}
