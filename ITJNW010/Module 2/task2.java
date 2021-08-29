import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.net.*;
import java.io.*;
import java.util.*;
import java.sql.*;

	
public class task2 extends TimerTask {

	public void run()
		{
	
		Connection con;
		Statement  st;
		ResultSet  rs;	
  		String left="left";
  		int i=0;
  		Thread tt1; 
		
    
    	try{
    	
   	Class.forName("sun.jdbc.odbc.JdbcOdbcDriver");
	con = DriverManager.getConnection("jdbc:odbc:projectup");
	st = con.createStatement();
    System.out.println("MyTimerTask 2 called");
    
	System.out.println("Timer started for left");
    //mainServer.serverSocket1.setSoTimeout(5000);
    //System.out.println("After the timeout");
    Long start = System.currentTimeMillis();
    //work();
    //String content="Demo from task2";
      //	delay.out2.writeUTF(content);
    while(true)
    {
        Long out = System.currentTimeMillis();
        Long total=out-start;
        Thread.sleep(100);
       // System.out.println("Total time is"+total);
        if(total>60000) // customize your session time for client  Request
        {
    st.executeUpdate("delete from MFT where location='"+left+"'");
    System.out.println("Deleted");
    delay.out2.close();
    JOptionPane.showMessageDialog(null,"Communication via Left Node is discarded  ","Group Information",JOptionPane.OK_OPTION);
    //System.out.println("Finished");
    break;
        }
     
    }
    }
     catch(Exception e)
			{
				System.out.println("Error in Left " + e);
				e.printStackTrace();
			}
    }       
      
      /*public void work()
      {
      	String content="Demo from task1";
      	mainServer.out1.writeUTF(content);
      }*/
    }
  

    
