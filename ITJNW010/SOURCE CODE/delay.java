import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.net.*;
import java.io.*;
import java.util.*;
import java.sql.*;




class delay extends Thread      //this is to left(direct path but it is very large in number)
{
	//public static ServerSocket serverSocket2;
	public static String location;
	public static DataOutputStream out2=null;
	public static DataInputStream in2=null;
	public static ServerSocket serverSocket2;
	public void run()
	{	
	Connection con;
	Statement  st;
	ResultSet  rs;
	
	java.util.Timer myTimer;
		
//	public delay()
	//	{
			
		try{	
	myTimer = new java.util.Timer();
	System.out.println("ROOT to Left Communication");
	Class.forName("sun.jdbc.odbc.JdbcOdbcDriver");
			con = DriverManager.getConnection("jdbc:odbc:projectup");
			st = con.createStatement();
			 
		
	/*	catch(Exception e1)
		{
		System.out.println("Error in delay Constructor" + e1);
		e1.printStackTrace();
		}*/
	//	call();
	
	//public void run()
	//{
	//	pyblic void call()
	//	{
		
	//	try{	
			//Thread.sleep(100);
		serverSocket2 = new ServerSocket(1033);      //this is to left(direct path but it is very large in number)
		Socket left=null;
		while(true)
		{
		
		left=serverSocket2.accept();
		if(left.isConnected())
		{	
	//	Thread.sleep(100);	
		System.out.println("Connected From Left Node");				
		out2=new DataOutputStream(left.getOutputStream());
		in2=new DataInputStream(left.getInputStream());	
		String location=delay.in2.readUTF();
	//	Thread.sleep();
    	String ipaddress=delay.in2.readUTF();
    	String root=InetAddress.getLocalHost().toString();
			
			
		PreparedStatement ps = con.prepareStatement("insert into MFT values(?,?,?)");
    	ps.setString(1,location);
		ps.setString(2,ipaddress);
		ps.setString(3,root);
		ps.executeUpdate();
		System.out.println("1 Row Created through delay class");
		con.close();    	
		task2 myTask2 = new task2();
		myTimer.schedule(myTask2, 300);
		}	
		
	}
	}
	catch(Exception e)
	{
		System.out.println("Error in delay class" + e);
		e.printStackTrace();
	}

yield();
}
}