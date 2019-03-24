
import java.io.*;
import java.util.Arrays;
/**
 * @author Subbiksa Shanmugha Sundaram
 *
 */
public class dbquery {

    private int pagesize, pageNumber, matching;
    private String scan , fileHeap; 
    private byte [] scanB;
    InputStream input;
    ByteArrayInputStream byteInput;
    byte [] bufferB;
    
    //constructor for the class dbquery
    public dbquery(String[] args){
    	 
        this.scan = args[0];
        
        try{
            
            this.pagesize = Integer.parseInt(args[1]);
            this.fileHeap = "heap." + Integer.toString(this.pagesize);
            this.input = new FileInputStream(fileHeap);
            this.bufferB = new byte [pagesize];
            this.scanB = this.scan.getBytes();

       } catch (Exception e){
            System.err.println(e.getMessage());
        }
    }   
    
    private void searchHeap(){

        String text;
        byte[] matchingB, scanBuffer;
        String matchText;
        int textFind, startDel, endDel;
        this.matching = 0;
        

        try{
            System.out.println(this.fileHeap);
            
            if(input.read(bufferB) != -1){ //in.read(buf) returns -1 if it hits the EOF. 
                //search in buf
                textFind = position(bufferB, scanB, 0);
                
                while(textFind != -1){
                    startDel = startDelim(textFind, bufferB);
                    endDel = endDelim(textFind, bufferB);
                    if ((startDel - endDel) < 1)
                    { 
                        break;
                    }
                    matchingB = Arrays.copyOfRange(bufferB, endDel + 1, startDel); 
                    matchText = new String(matchingB);
                    String [] values = matchText.split("#");
                    System.out.format("%-90s", values[0]);
                    for (int i = 1; i < values.length; i++){
                        System.out.print(values[i] + "\t");
                    } 
                    System.out.println();
                    this.matching = matching + 1;
                    textFind = position(bufferB, scanB, textFind + 1); 
                    //keep searching from next byte
                }      
                //keep count of number of pages
                this.pageNumber = pageNumber + 1;
            }
        } catch (Exception e){
            System.err.println(e.getMessage());
        }
    }
	private int endDelim(int textFind, byte[] bufferB2) {
		
		return 0;
	}

	private int startDelim(int textFind, byte[] bufferB2) {
		// TODO Auto-generated method stub
		return 0;
	}

	private int position(byte[] bufferB2, byte[] scanB2, int i) {
		// TODO Auto-generated method stub
		return 0;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
