# Jenkins Common Pipeline Library

## global "vars"

I am baffled by Jenkins' terminology of a "vars" directory when in fact
it is a handy place to put shared code for all others to use.  Several
of these exist in this library

### Callable routines

#### doLs

Runs the Unix/Linux "ls" command and caputures the results in an array of
String and returns the array to the calling environment.

#### isOlderThan

##### Parameters

* Integer ndays    ---  how many days is your threshold
* Date    date     ---  what date are you comparing

'''
     Boolean expired = isOlderThan(15,'15-September-2019')
'''

Returns true if 15-September-2019 was more than 15 days ago.

#### s3Ls

##### Parameters

