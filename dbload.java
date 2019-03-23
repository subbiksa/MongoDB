/**
 * @author subbiksa Shanmugha Sundaram
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
        this.pass(args);
        try{
            this.fileOutput = "heap." + Integer.toString(this.pagesize);
            this.dataOut = new DataOutputStream(new FileOutputStream(this.fileOutput));
            this.ByteOut = new ByteArrayOutputStream(this.pagesize);
        } catch (Exception e){
            System.err.println(e.getMessage());
        }
    }   
    
  		// handling the arguments
 		public void pass(String args[]) {
 			 if (args[0].equals("-p"))
 			 {
 	            this.pagesize = Integer.parseInt(args[1]);
 	            this.datafile = args[2];
 	        } 
 			 else
 			 {
 	            this.datafile = args[0];
 	            this.pagesize = Integer.parseInt(args[2]);
 	        }
 		}
 		 //File Reader- loading the database 
 		private void readerFile(){
 	        String newLine;
 	        try{

 	            BufferedReader buff = new BufferedReader(new FileReader(this.datafile));
 	            // BufferedReader buff 
 	            buff.readLine();

 	            while((newLine = buff.readLine()) != null){
 	            	//Data being read from the file specified
 	                String[] values = newLine.split("\t");
 	                if (values.length != 9){
 	                    continue;
 	                }                
 	                //Data has values with properties
 	                Data data = new Data(values); 
 	                data.print();
 	                this.recordNumber = recordNumber + 1;
 	                //If Buffer has  space 
 	                if (this.ByteOut.size() + data.byteLength < this.pagesize){
 	                    this.ByteOut.write(data.getByteArray());
 	                }
 	                else
 	                { 
 	                	//If the buffer is full
 	                    this.pageNumber = pageNumber + 1;
 	                    this.ByteOut.writeTo(this.dataOut);
 	                    this.ByteOut.reset();
 	                    this.ByteOut.write(data.getByteArray());
 	                }
 	           }
 	        }
 	           catch (Exception e){
 	            System.err.println(e.getMessage());
 	            //error messages in the console
 	        }
 		}
	public static void main(String[] args) {
		    dbload dataBase = new dbload(args);
		    //pass the arguments to dbload
	        long startingTime = System.currentTimeMillis();
	        //conversion to milliseconds of startingTime
	        dataBase.readerFile();
	        //call to the readerFile for file reading 
	        long endingTime = System.currentTimeMillis();
	        //conversion to milliseconds of endTime
	        long duration = (endingTime - startingTime);
	        // Duration is the time taken in the difference between start and end time
	        System.out.println("**Time taken to insert the data: " + duration + " milliseconds");
	        System.out.println("**The total Number of records loaded: " + dataBase.recordNumber);
	        System.out.println("**The total Number of pages used: " + dataBase.pageNumber);
	    }  
	}


