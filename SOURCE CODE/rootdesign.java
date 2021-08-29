/****************************************************************/
/*                      rootdesign	                            */
/*                                                              */
/****************************************************************/
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.net.*;
import java.io.*;
import java.util.*;
import java.sql.*;
import javax.swing.event.*; 
/**
 * Summary description for rootdesign
 *
 */
public class rootdesign extends JFrame
{
	// Variables declaration
	public static String send_share;
	private JLabel jLabel1;
	private JLabel jLabel2;
	private JTextField jTextField1;
	private JTextField jTextField2;
	private JTextArea jTextArea1;
	private JScrollPane jScrollPane1;
	private JButton FileTransmission;
	private JButton SENDMESSAGE;
	private JButton MFTREPORT;
	private JButton CF;
	private JPanel contentPane;
	private JList jList1; 
 	private JScrollPane jScrollPane2;
 	Connection con;
	Statement  st;
	//ResultSet  rs;
 		Vector v=new Vector();
	// End of variables declaration


	public rootdesign()
	{
		super();
		try{
		
		d obj= new d();
		v=obj.nodes();
		System.out.println("Vector Elements" + v);
		}
		catch(Exception e)
			{
				System.out.println("Error in nodes calling " + e);
				e.printStackTrace();
			}
		initializeComponent();
		//
		// TODO: Add any constructor code after initializeComponent call
		//
			mains t1 = new mains();
			delay t2 = new delay();
			t1.start();
			t2.start();

		this.setVisible(true);
	}

	/**
	 * This method is called from within the constructor to initialize the form.
	 * WARNING: Do NOT modify this code. The content of this method is always regenerated
	 * by the Windows Form Designer. Otherwise, retrieving design might not work properly.
	 * Tip: If you must revise this method, please backup this GUI file for JFrameBuilder
	 * to retrieve your design properly in future, before revising this method.
	 */
	private void initializeComponent()
	{
		jLabel1 = new JLabel();
		jLabel2 = new JLabel();
		jTextField1 = new JTextField();
		jTextField2 = new JTextField();
		jTextArea1 = new JTextArea();
		jScrollPane1 = new JScrollPane();
		FileTransmission = new JButton();
		SENDMESSAGE = new JButton();
		MFTREPORT = new JButton();
		CF = new JButton();
		jList1 = new JList(v); 
 		jScrollPane2 = new JScrollPane(); 
		contentPane = (JPanel)this.getContentPane();

		//
		// jLabel1
		//
		jLabel1.setBackground(new Color(255, 255, 255));
		jLabel1.setForeground(new Color(51, 255, 51));
		jLabel1.setText("SERVER NAME");
		//
		// jLabel2
		//
		jLabel2.setForeground(new Color(51, 255, 0));
		jLabel2.setText("FILE LOCATION");
		//
		// jTextField1
		//
		jTextField1.setBackground(new Color(255, 255, 204));
		jTextField1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e)
			{
				jTextField1_actionPerformed(e);
			}

		});
		//
		// jTextField2
		//
		jTextField2.setBackground(new Color(255, 255, 204));
		jTextField2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e)
			{
				jTextField2_actionPerformed(e);
			}

		});
		//
		// jTextArea1
		//
	//	jTextArea1.setText("jTextArea1");
		//
		// jScrollPane1
		//
		jScrollPane1.setViewportView(jTextArea1);
		//
		// FileTransmission
		//
		//FileTransmission.setBackground(new Color(0, 255, 204));
		FileTransmission.setText("FILE TRANSMISSION");
		FileTransmission.setToolTipText("IT WILL TANSMIIT THE FILE WHICH IS ENTERED IN THE TEXT AREA");
		FileTransmission.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e)
			{
				FileTransmission_actionPerformed(e);
			}

		});
		//
		// SENDMESSAGE
		//
	//	SENDMESSAGE.setBackground(new Color(102, 255, 204));
		SENDMESSAGE.setText("SEND MESSAGE");
		SENDMESSAGE.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e)
			{
				SENDMESSAGE_actionPerformed(e);
			}

		});
		//
		// MFTREPORT
		//
	//	MFTREPORT.setBackground(new Color(51, 255, 204));
		MFTREPORT.setText("MFT REPORT");
		MFTREPORT.setToolTipText("SHOWS THE ROUTING TABLE MODIFICATION");
		MFTREPORT.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e)
			{
				MFTREPORT_actionPerformed(e);
			}

		});
		
		CF.setText("CHOOSE FILE");
		//MFTREPORT.setToolTipText("SHOWS THE ROUTING TABLE MODIFICATION");
		CF.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e)
			{
				CF_actionPerformed(e);
			}

		});
		
		jList1.addListSelectionListener(new ListSelectionListener() { 
 			public void valueChanged(ListSelectionEvent e) 
 			{ 
 				jList1_valueChanged(e); 
 			} 
  
 		}); 
 			
 			jScrollPane2.setViewportView(jList1); 
		//
		// contentPane
		//
		contentPane.setLayout(null);
		contentPane.setBackground(new Color(0, 102, 0));
		addComponent(contentPane, jLabel1, 62,81,95,29);
		addComponent(contentPane, jLabel2, 60,155,92,28);
		addComponent(contentPane, jTextField1, 210,79,117,33);
		addComponent(contentPane, jTextField2, 212,151,115,34);
		addComponent(contentPane, jScrollPane1, 399,78,225,228);
		addComponent(contentPane, CF, 54,355,140,35);
		addComponent(contentPane, FileTransmission, 194,355,150,35);
		addComponent(contentPane, SENDMESSAGE, 344,355,131,35);
		addComponent(contentPane, MFTREPORT, 475,355,130,35);
		addComponent(contentPane, jScrollPane2, 680,78,120,228); 
		//
		// rootdesign
		//
		this.setTitle("rootdesign - extends JFrame");
		this.setLocation(new Point(0, 0));
		this.setSize(new Dimension(820, 450));
		
		try{
			String ip=InetAddress.getLocalHost().getHostAddress();
			System.out.println("IP ADDRESS : " + ip);
			jTextField1.setText(ip);
		}
		
		catch(Exception e1)
      {
      	System.out.println(e1);
      }
	}

	/** Add Component Without a Layout Manager (Absolute Positioning) */
	private void addComponent(Container container,Component c,int x,int y,int width,int height)
	{
		c.setBounds(x,y,width,height);
		container.add(c);
	}

	//
	// TODO: Add any appropriate code in the following Event Handling Methods
	//
	private void jTextField1_actionPerformed(ActionEvent e)
	{
		System.out.println("\njTextField1_actionPerformed(ActionEvent e) called.");
		// TODO: Add any handling code here

	}

	private void jTextField2_actionPerformed(ActionEvent e)
	{
		System.out.println("\njTextField2_actionPerformed(ActionEvent e) called.");
		// TODO: Add any handling code here

	}
	
	
		private void jList1_valueChanged(ListSelectionEvent e) 
 	{ 
 		System.out.println("\njList1_valueChanged(ListSelectionEvent e) called."); 
 		if(!e.getValueIsAdjusting()) 
 		{ 
 			Object o = jList1.getSelectedValue(); 
 			System.out.println(">>" + ((o==null)? "null" : o.toString()) + " is selected."); 
 			// TODO: Add any handling code here for the particular object being selected 
 			 
 		} 
 	} 

	private void FileTransmission_actionPerformed(ActionEvent e)
	{
		System.out.println("\nFileTransmission_actionPerformed(ActionEvent e) called.");
		try{
		
		String send1 = jTextArea1.getText();
		System.out.println(mains.flag);
		String s1=mains.flag;
		if(s1==null)
		{
			delay.out2.writeUTF(send1);  //for  root to left (Direct path)
		System.out.println("Root sending the following data to left " + send1);
			
		}
	//	if(mains.flag.equals("right"))
		else if(s1.equals("right"))
		{
		mains.out1.writeUTF(send1);  //for root to right and left(Indirect path)
		System.out.println("Root sending the following data to right " + send1);
		
		}
		
		}
		 catch(Exception e1)
      {
      	System.out.println("fffffffffffff " + e1);
      }
		
		
		// TODO: Add any handling code here

	}

	private void SENDMESSAGE_actionPerformed(ActionEvent e)
	{
		System.out.println("\nSENDMESSAGE_actionPerformed(ActionEvent e) called.");
		try{
		
		String send2 = jTextArea1.getText();
		System.out.println(mains.flag);
		String s2=mains.flag;
		if(s2==null)
		{
		delay.out2.writeUTF(send2);  //for  root to left (Direct path)
		System.out.println("Root sending the following data to left " + send2);
			
		}
	//	if(mains.flag.equals("right"))
		else if(s2.equals("right"))
		{
		mains.out1.writeUTF(send2);  //for root to right and left(Indirect path)
		System.out.println("Root sending the following data to right " + send2);
		
		}
		
		}
		 catch(Exception e1)
      {
      	System.out.println("Error in sending message " + e1);
      }

	}

	private void MFTREPORT_actionPerformed(ActionEvent e)
	{
		System.out.println("\n MFT REPORT_actionPerformed (Action Event e) called.");
		db();
		//int i=0;
		 try{
		 
		reportroot r=new reportroot();
		ResultSet rs4= st.executeQuery("Select * from MFT");	
		String s1[]=new String[3];
		String s2;
		while(rs4.next())
		{  	
		s1[0]=rs4.getString(1);
		s1[1]=rs4.getString(2);
		s1[2]=rs4.getString(3);
		//i++;
		}
			r.jTextField1.setText(s1[0]);
			System.out.println(s1[0]);
			r.jTextField2.setText(s1[1]);
			System.out.println(s1[1]);
			r.jTextField3.setText(s1[2]);
			System.out.println(s1[2]);
			 con.close();
		
		//System.out.println("after visible");
	}
	catch(Exception e1)
			{
				System.out.println("Error in MFT " + e1);
				e1.printStackTrace();
			}
	}

	
	
	
	private void CF_actionPerformed(ActionEvent e)
	{
		System.out.println("\nfile choose_actionPerformed(ActionEvent e) called.");
		
	
		try
		{ 
		        JFileChooser jf=new JFileChooser();

				int m=jf.showOpenDialog(null);
				
				if(m==JFileChooser.APPROVE_OPTION)
			       {
				 File f1=jf.getSelectedFile();
				  String str=f1.getPath();	
				  	jTextField2.setText(str);		   
				   FileInputStream fis=new FileInputStream(str);
	               //File f=new File(str); 
                   byte b[]=new byte[fis.available()];	       
			 	   fis.read(b);			
			      String msg=new String(b);
			       jTextArea1.setText(msg);
			      
				   fis.close();
				   
			   }
			   
		}
			   catch(Exception ui)
			   	{   
    			ui.printStackTrace();
    			//System.err.println("Exiting program..." + finalsource.treceiver + " is not an active node");
                }
			   	
			}
		//
	// TODO: Add any method code to meet your needs in the following area
	//



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


























 

//============================= Testing ================================//
//=                                                                    =//
//= The following main method is just for testing this class you built.=//
//= After testing,you may simply delete it.                            =//
//======================================================================//
	public static void main(String[] args)
	{
		JFrame.setDefaultLookAndFeelDecorated(true);
		JDialog.setDefaultLookAndFeelDecorated(true);
		try
		{
			UIManager.setLookAndFeel("javax.swing.plaf.metal.MetalLookAndFeel");
			

		}
		catch (Exception ex)
		{
			System.out.println("Failed loading L&F: ");
			System.out.println(ex);
		}
		new rootdesign();
	}
//= End of Testing =


}
