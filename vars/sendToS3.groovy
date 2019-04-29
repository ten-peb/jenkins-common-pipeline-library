def void call(file,bucket,path="/"){
  def String cmd = "aws s3 cp " +file+" "+ bucket + '/'
  if ( path != "/" ) {
     cmd = cmd + path
  }
  sh(cmd)
}
