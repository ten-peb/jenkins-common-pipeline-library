def void call(){
  String[]  body = [
  "Dear sir or madam",
  "  ",
  "I regret to inform you of the failure of one of your builds failing."
  "pipeline: ${currentBuild.fullDisplayName}",
  " "
  "So sorry it didn't work out.",
  " ",
  "Your faithful servant",
  "- Jenkins"
  ]
  
  String subject = "FAILURE: ${currentBuild.fullDisplayName}"
  
  for(String send2:devopsTeam()){
    mail(to: send2,subject: subject,body: body.join("\n"))
  }

}