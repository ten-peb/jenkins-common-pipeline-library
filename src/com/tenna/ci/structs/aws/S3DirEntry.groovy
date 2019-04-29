/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.tenna.ci.structs.aws

/**
 *
 * @author Peter L. Berghold &lt;pberghold@tenna.com&gt;
 */
class S3DirEntry {
    def Integer size
    def Date createDate
    def String name
    
    S3DirEntry(){
        
    }
    S3DirEntry(Date createdate, Integer size, String name){
        this.createDate = createdate
        this.size = size
        if (name == null ) {
            this.name = "NULL NAME PASSED"
        } else{
        this.name = name 
        }
        
    }
    def private String unitize(Integer v){
        def String retval
        def units = "Bytes"
        def double x=(double) v
        if ( x > 1024 ){
            x=x.div(1024)
            units= "Mb"
        }
        if (x > 1024) {
            x=x.div(1024)
            units="Gb"
        }
        if (x>1024){
           x=x.div(1024)
           units="Tb"
        }
        retval=String.format("%4.2f%s",x,units)
        return retval
    }
        
    def String toString(){
        def String retval
        retval = createDate.toString()
        retval = retval + " " + unitize(size)
        retval = retval + " " + name
        return  retval
    
    }
}   