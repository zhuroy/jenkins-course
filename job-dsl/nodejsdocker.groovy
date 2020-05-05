job('NodeJS Docker example') {
    scm {
        git('https://github.com/zhuroy/docker-demo.git') 
    }
    triggers {
        scm('H/5 * * * *')
    }
    steps {
        dockerBuildAndPublish {
            repositoryName('roynorthyork/docker-nodes-demo')
            tag('${GIT_REVISION,length=9}')
            registryCredentials('6e18bb2e-d83b-4c00-98ec-6e556fccbaa2')
            forcePull(false)
            forceTag(false)
            createFingerprints(false)
            skipDecorate()
        }
    }
}
