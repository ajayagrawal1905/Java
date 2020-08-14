package jdbcDemo;
import java.sql.*;
import java.lang.*;
import java.util.*;

public class jdbcDemo {
	   // JDBC driver name and database URL
	   static final String JDBC_DRIVER = "com.mysql.jdbc.Driver";  
	   static final String DB_URL = "jdbc:mysql://localhost/Mydb";
	   static final Scanner scan = new Scanner(System.in);

	   //  Database credentials
	   static final String USER = "root";
	   static final String PASS = "";

	public static void main(String[] args) {
		   Connection conn = null;
		   Statement stmt = null;
		   int N = scan.nextInt();
		   switch(N) {
		   
				   case 1:
					   try{
						      //STEP 2: Register JDBC driver
						      Class.forName("com.mysql.jdbc.Driver");
		
						      //STEP 3: Open a connection
						      System.out.println("Connecting to a selected database...");
						      conn = DriverManager.getConnection(DB_URL, USER, PASS);
						      System.out.println("Connected database successfully...");
						      
						      //STEP 4: Execute a query
						      System.out.println("Creating statement...");
						      stmt = conn.createStatement();
		
						      String sql = "SELECT id, fname, lname, age FROM test";
						      ResultSet rs = stmt.executeQuery(sql);
						      //STEP 5: Extract data from result set
						      while(rs.next()){
						         //Retrieve by column name
						         int id  = rs.getInt("id");
						         int age = rs.getInt("age");
						         String first = rs.getString("fname");
						         String last = rs.getString("lname");
		
						         //Display values
						         System.out.print("ID: " + id+"\n");
						         System.out.print("Age: " + age+"\n");
						         System.out.print("First: " + first+"\n");
						         System.out.println("Last: " + last+"\n");
						      }
						      rs.close();
						   }catch(SQLException se){
						      //Handle errors for JDBC
						      se.printStackTrace();
						   }catch(Exception e){
						      //Handle errors for Class.forName
						      e.printStackTrace();
						   }finally{
						      //finally block used to close resources
						      try{
						         if(stmt!=null)
						            conn.close();
						      }catch(SQLException se){
						      }// do nothing
						      try{
						         if(conn!=null)
						            conn.close();
						      }catch(SQLException se){
						         se.printStackTrace();
						      }//end finally try
						   }//end try
						   System.out.println("Goodbye!");
						   break;
						   
				   case 2:
					   try{
						      //STEP 2: Register JDBC driver
						      Class.forName("com.mysql.jdbc.Driver");

						      //STEP 3: Open a connection
						      System.out.println("Connecting to a selected database...");
						      conn = DriverManager.getConnection(DB_URL, USER, PASS);
						      System.out.println("Connected database successfully...");
						      
						      //STEP 4: Execute a query
						      System.out.println("Inserting records into the table...");
						      stmt = conn.createStatement();
						      
						      int age = scan.nextInt();
						      String fname = scan.next();
						      String lname = scan.next();
						      
						      String sql = "insert into test"
												+ " (age,fname,lname)" + " values (?, ?, ?)";
						      Statement myStmt = stmt.executeUpdate(sql);
						       
						      myStmt.setString(1, age);
						  	  myStmt.setString(2, fname);
						  	  
						  	  myStmt.setString(3, lname);

						  	  myStmt.executeUpdate();

						      
						      /*String sql = "INSERT INTO test " +
						                   "VALUES ("+" "+","+age+","+","+fname+","+lname+" "+")";
						      stmt.executeUpdate(sql);
						      
						      // set param values
	myStmt.setString(1, lastName);
	myStmt.setString(2, firstName);
	myStmt.setString(3, email);

	// 3. Execute SQL query
	myStmt.executeUpdate();
						      
						       "insert into test"
											+ " (age,fname,lname)" + " values (?, ?, ?)";
			
						      sql = "INSERT INTO test " +
						                   "VALUES (101, 25, 'Mahnaz', 'Fatma')";
						      stmt.executeUpdate(sql);
						      sql = "INSERT INTO test " +
						                   "VALUES (102, 30, 'Zaid', 'Khan')";
						      stmt.executeUpdate(sql);
						      sql = "INSERT INTO test " +
						                   "VALUES(103, 28, 'Sumit', 'Mittal')";
						      stmt.executeUpdate(sql);*/
						      System.out.println("Inserted records into the table...");

						   }catch(SQLException se){
						      //Handle errors for JDBC
						      se.printStackTrace();
						   }catch(Exception e){
						      //Handle errors for Class.forName
						      e.printStackTrace();
						   }finally{
						      //finally block used to close resources
						      try{
						         if(stmt!=null)
						            conn.close();
						      }catch(SQLException se){
						      }// do nothing
						      try{
						         if(conn!=null)
						            conn.close();
						      }catch(SQLException se){
						         se.printStackTrace();
						      }//end finally try
						   }//end try
						   System.out.println("Goodbye!");
					   break;
				   case 3:
					   break;
				   case 4:
					   break;
		   
		   }
		   
	}

}
