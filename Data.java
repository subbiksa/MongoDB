import java.io.ByteArrayOutputStream;

public class Data {

   	public int byteLength;
    String DeviceID, ArrivalTime, DepartureTime, DurationSeconds, StreetMarker, Sign, Area,StreetID, StreetName, BetweenStreet1, BetweenStreet2, SideOfStreet, InViolation;
    byte [] byteDeviceID, byteArrivalTime, byteDepartureTime, byteDurationSeconds, byteStreetMarker, byteSign, byteArea, byteStreetID, byteStreetName, byteBetweenStreet1, byteBetweenStreet2, byteSideOfStreet, byteInViolation, fDel, dataDel; 
    // attributes of sample.csv 
	public Data(String[] args) {	
		this.DeviceID = args[1]; 
        this.ArrivalTime = args[2]; 
        this.DepartureTime = args[3];
        this.DurationSeconds = args[4];
        this.StreetMarker = args[5];
        this.Sign = args[6];
        this.Area = args[7];
        this.StreetID = args[8];
        this.StreetName = args[9];
        this.BetweenStreet1 = args[10];
        this.BetweenStreet2 = args[11];
        this.SideOfStreet = args[12];
        this.InViolation = args[13];
        //converts into binary
        this.byteDeviceID = DeviceID.getBytes(); 
        this.byteArrivalTime = ArrivalTime.getBytes();
        this.byteDepartureTime = DepartureTime.getBytes();
        this.byteDurationSeconds = DurationSeconds.getBytes();
        this.byteStreetMarker = StreetMarker.getBytes();
        this.byteSign = Sign.getBytes();
        this.byteArea = Area.getBytes();
        this.byteStreetID = StreetID.getBytes();
        this.byteStreetName = StreetName.getBytes();
        this.byteBetweenStreet1 = BetweenStreet1.getBytes();
        this.byteBetweenStreet2 = BetweenStreet2.getBytes();
        this.byteSideOfStreet = SideOfStreet.getBytes();
        this.byteInViolation = InViolation.getBytes();
        this.dataDel = "|".getBytes();        
        this.fDel = "#".getBytes();         
        //calculate bytelength
        this.byteLength = this.getByteArray().length;
	}

	public void print() {
		  String s = this.DeviceID + "\t" + this.ArrivalTime + "\t" + this.DepartureTime + "\t" + this.DurationSeconds + "\t" + this.StreetMarker + "\t" + this.Sign + "\t" + this.Area + "\t" + this.StreetID + "\t" + this.StreetName + "\t" + this.BetweenStreet1 + "\t" + this.BetweenStreet2 + "\t" + this.SideOfStreet + "\t" + this.InViolation ;
		  System.out.println(s);
	}

	public byte[] getByteArray() {
		 ByteArrayOutputStream Array = new ByteArrayOutputStream();
		 try{        
             Array.write(this.byteDeviceID);
             Array.write(this.fDel);
             Array.write(this.byteArrivalTime);
             Array.write(this.fDel);
             Array.write(this.byteDepartureTime);
             Array.write(this.fDel);
             Array.write(this.byteDurationSeconds);
             Array.write(this.fDel);
             Array.write(this.byteStreetMarker);
             Array.write(this.fDel);
             Array.write(this.byteSign);
             Array.write(this.fDel);
             Array.write(this.byteArea);
             Array.write(this.fDel);
             Array.write(this.byteStreetID);
             Array.write(this.fDel);
         } catch(Exception e){
             System.out.println(e.getMessage());
         }
		return Array.toByteArray();
	}

}
