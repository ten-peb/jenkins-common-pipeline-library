# Jenkins Common Pipeline Library

## global "vars"

I am baffled by Jenkins' terminology of a "vars" directory when in fact
it is a handy place to put shared code for all others to use.  Several
of these exist in this library

### Callable routines

#### devopsTeam

##### RETURNS

Array of String of email addresses for the "DevOps Team."  Currently only returns a single address.

```
        sendEmail(devOpsTeam(),"Something went wrong",whatHappened)

```

##### RETURNS

Array of String representing the email addresses of the DevOps team. Currently consists of two members, Luke Douglas and Peter Berghold.

##### Params

NONE

#### doExecCapture

Executes a command and returns an array of strings of the output.

##### RETURNS

Array of String with results of running command passed.

##### Params

###### String command  -- command to be run

```

   def String[] scrape = doExecCapture('docker ps')

```


#### doLs

Runs the Unix/Linux "ls" command and caputures the results in an array of
String and returns the array to the calling environment.

#### isOlderThan

##### Parameters

* Integer ndays    ---  how many days is your threshold
* Date    date     ---  what date are you comparing

```
     Boolean expired = isOlderThan(15,'15-September-2019')
```

Returns true if 15-September-2019 was more than 15 days ago.

#### s3Ls

##### Parameters

* String bucket

Lists the contents of an S3 bucket and returns the contents in an array of
type com.tenna.ci.structs.aws.S3DirEntry which is documented later in this
document.

```
   my bucket_list = s3Ls('s3://mybucket/subdir')

```

#### s3Rm

Removes an entry from an S3 bucket.


##### Parameters

* String bucket  -- top of the desired bucket
* String path    -- entry withing the bucket

```

    s3Rm('s3://mybucket','somefile.txt')

```
#### sendEmail

#### sendFailureEmail



#### sendToS3

Sends a local file to the S3 bucket of choice

##### Parameters

* file    -- name (path) of the local file
* bucket  -- name of the desired bucket
* (optional paramter) path  (default="/") subpath within a bucket.

```
    # file sent to the top of a bucket
    sendToS3('mydocument.docx','s3://mydocuments')

    # file sent to a subdirectory of a bucket
    sendToS3('sql-backups.sql.gz','s3://mybackups','/weekly/')

```


## Data Structures

### Package com.tenna.ci.structs.aws

#### S3DirEntry

Contains information about a directory entry in an s3 bucket and/or subpath.

##### Members

* Integer size    -- size of the file in bytes
* Date    createDate  -- when the file was uploaded
* String  name        -- the file's name

#### S3Directory

Contains an S3 directory

##### Methods

* void parse(String[] lines)

Takes the raw output of a an 's3cmd s3 ls' command and parses it into an
ArrayList<S3DirEntry> structure.

##### Members

* ArrayList<S3DirEntry>

```

    import com.tenna.ci.structs.s3.S3Directory
    |
    hand waviumm 
    |
    S3Directory bucketList = s3Ls()


```

