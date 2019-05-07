def void call(String[] who,String subject,String body){
  for(String send2:who){
    mail(to: send2,subject: subject,body: body)
  }

}