def String[] call(String command){
    def String[] retval = sh (script: command,       
        returnStdout: true).trim().split("\\r?\\n")
    
    return retval
}
