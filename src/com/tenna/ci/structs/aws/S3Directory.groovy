/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.tenna.ci.structs.aws
import java.util.ArrayList
import java.text.DateFormat
import java.text.SimpleDateFormat

/**
 *
 * @author peter
 */
class S3Directory {
	
    
    def ArrayList<S3DirEntry> dir

    S3Directory() {
        dir = new ArrayList<S3DirEntry>()
    }


    
    def void parse(String[] lines){
        def String[] buffer
        def Integer  tsize
        def String   tname
        
        for(String line:lines){
        def S3DirEntry entry
        if ( line != null ){
            buffer=line.split()
            
            def String tdate = buffer[0]+' '+buffer[1]
            def String dpat = "yyyy-MM-dd HH:mm:ss"
            def DateFormat df = new SimpleDateFormat(dpat);
            def Date result =  df.parse(tdate);
        
            tsize = new Integer(buffer[2])
            tname = buffer[3]
            System.out.println('again, buffer[3]=' + buffer[3])
            entry = new S3DirEntry(result,tsize,buffer[3])
            dir.add(entry)
        
        }
    }
}

}