import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.net.*;
import java.io.*;
import java.util.*;
import java.sql.*;



 class mains extends Thread{
	
	public static ServerSocket serverSocket1;
	public static DataOutputStream out1=null;
	public static DataInputStream in1=null;	
	public static String flag;
	Socket right=null;
	int port;
	int d1,d2;
	public static String location;
	Connection con;
	Statement  st;
	ResultSet  rs;
	//String rlocation;
	//String rhost;
	String llocation;
	String lipaddress;
	String rrlocation;
	String rrrequest;
	String rrhost;
	String root;
	
	
	

 public void run()
 {
 
  	try{
    serverSocket1 = new ServerSocket(1039);  //this is to right and left (indirect path but it is very less in weight)
    System.out.println("ROOT to Right Communication");
  	java.util.Timer myTimer = new java.util.Timer();
    //delay d=new delay();    
    //java.util.Timer time=new java.util.Timer();
    //time.schedule(d,2000);
    while(true)
    {
    
    right=serverSocket1.accept();
    
    System.out.println("Connected to Left and Right child Node");
    out1=new DataOutputStream(right.getOutputStream());
	in1=new DataInputStream(right.getInputStream());
      
    
    if(right.isConnected())
    {	
    	flag="right";
    	System.out.println("Connected From Right Node...");
    //	Thread.sleep();
    	
    //	mainServer.location="right";
    	String req=mains.in1.readUTF();  // ist read from right
    	if(req.equals("rightrequest"))
    	{
    		rrlocation=mains.in1.readUTF();  //2nd
    		rrhost=mains.in1.readUTF();  //3rd
    	//	Thread.sleep();
    		root=InetAddress.getLocalHost().toString();
    		System.out.println("Root received the data from Right");
    		JOptionPane.showMessageDialog(null," Right Node  Requested For Multicast Comminication ","Request From Right",JOptionPane.OK_OPTION);
    		
    	}
    	else
    	{
    	 llocation=mains.in1.readUTF();    //2  
    	 lipaddress=mains.in1.readUTF();   //3
    	 rrrequest=mains.in1.readUTF();    //4
    	 //Thread.sleep();
    	 rrlocation=mains.in1.readUTF();    //5	  
         rrhost=mains.in1.readUTF();    	//6
    	  root=InetAddress.getLocalHost().toString();
    	  System.out.println("Root received the data from Left and Right");
    	  JOptionPane.showMessageDialog(null,"Left Node Requested For Multicast Comminication ","Request From Left",JOptionPane.OK_OPTION);
    	}
    	db();
    	PreparedStatement ps = con.prepareStatement("insert into MFT values(?,?,?)");
    	ps.setString(1,rrlocation);
		ps.setString(2,rrhost);
		ps.setString(3,root);
		ps.executeUpdate();
		System.out.println("1 Row Updated through mainerver class");
		con.close();    	
    	task1 myTask1 = new task1();
    	myTimer.schedule(myTask1, 100);
    }
    }	        
    }
      catch(Exception e)
      {
      	System.out.println(e);
      }


  }
  	public void db()
	{
		try
		{
			Class.forName("sun.jdbc.odbc.JdbcOdbcDriver");
			con = DriverManager.getConnection("jdbc:odbc:projectup");
			st = con.createStatement();
		}catch(Exception ex)
		{
			System.out.println(ex);
		}

	}
}