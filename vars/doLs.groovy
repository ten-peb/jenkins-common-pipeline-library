/*
 * Returns an array of String to represent the contents of PWD
 */

def String[] call() {
    def String[] retval = sh (script: "ls", 
        returnStdout: true).trim().split("\\r?\\n")


    return retval
}