import com.tenna.ci.structs.aws.S3Directory
import com.tenna.ci.structs.aws.S3DirEntry
import java.util.ArrayList

def S3Directory call(String bucket) {
    def String[] buffer = sh (script: "aws s3 ls "+bucket, 
        returnStdout: true).split("\\n")
 
    def S3Directory retval = new S3Directory()
    retval.parse(buffer)

    return retval
}