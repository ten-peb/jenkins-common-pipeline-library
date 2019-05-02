def void call(String repo,String cloneto,String branch = 'master'){
  checkout([$class: 'GitSCM',
    branches: [[name: '*/' + branch]],
    doGenerateSubmoduleConfigurations: false,
    extensions: [[$class: 'RelativeTargetDirectory',
    relativeTargetDir: cloneto ]],
    submoduleCfg: [],
    userRemoteConfigs: [[url:  repo ]]])
 }
