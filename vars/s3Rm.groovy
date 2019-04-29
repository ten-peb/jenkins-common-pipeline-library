def void call(String bucket,String path){
    def String script = "aws s3 rm " + bucket + "/" + path
    sh(script)
    
}