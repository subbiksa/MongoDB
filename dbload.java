/**
 * 
 */

/**
 * @author subbiksa shanmugha Sundaram
 * dated 23/03/2019
 */
import java.io.*;
import java.lang.*;
import java.util.*;

public class dbload {
    //gets the dataOut to write to an output stream-output file
	private int pageNumber, recordNumber, pagesize;
    private String datafile;
    private String fileOutput;
    DataOutputStream dataOut;
    ByteArrayOutputStream ByteOut;
    
    //constructor
 public dbload(String[] args){
        //initially the page and the record numbers are considered to be zero
        this.pageNumber = 0;
        this.recordNumber = 0;
        // In order to obtain the outputfile name as heap.pagesize(converted binary data is stored here) 
        try{
            this.fileOutput = "heap." + Integer.toString(this.pagesize);
            this.dataOut = new DataOutputStream(new FileOutputStream(this.fileOutput));
            this.ByteOut = new ByteArrayOutputStream(this.pagesize);
        } catch (Exception e){
            System.err.println(e.getMessage());
        }
    }   
    
    
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
