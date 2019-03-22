import java.util.List;
import com.mongodb.MongoClient;
import com.mongodb.client.MongoDatabase;

public class MongoConnection {
	public static void main(String args[])
	{
		//Connecting With Server Please add the external jar file first
				MongoClient mongoClient = new MongoClient( "localhost" , 27017 );
				System.out.println("server connection successfully done");
				
				//Connecting with database
				MongoDatabase dbs = mongoClient.getDatabase("M");
		        System.out.println("Connect to database successfully");
		        System.out.println("Database Name \n"+dbs.getName());
		   
		      
		
		
	}

}