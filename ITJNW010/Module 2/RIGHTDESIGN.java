/****************************************************************/
/*                      RIGHT	                            */
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
 * Summary description for RIGHT
 *
 */
public class RIGHTDESIGN extends JFrame
{
	// Variables declaration
	 
	 DataOutputStream dop1;
	DataInputStream dis1;
	private JLabel jLabel1;
	private JLabel jLabel2;
	private JTextField jTextField1;
	private JTextField jTextField2;
	private JTextArea jTextArea1;
	private JScrollPane jScrollPane1;
	private JButton jButton1;
	private JButton jButton2;
	private JButton jButton3;
	private JButton jButton4;
	private JPanel contentPane;
	ServerSocket fromleft = null;
	private JList jList1; 
 	private JScrollPane jScrollPane2;
		Socket toroot =null;
		Socket toleft =null;			
		Connection con;
		Statement  st;
		ResultSet  rs;
		String locaton_from_left;
		String hostname_from_left;
		int	left_to_right=0;
		int	left_to_root=0;
		int right_to_root=0;
		int indirect_path=0;
		int flag;
		String hostname1;
		DataInputStream	dis2=null;
		DataOutputStream dop2=null;
			Vector v=new Vector();
		String display;
		String server;
	// End of variables declaration


	public RIGHTDESIGN()
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
		jButton1 = new JButton();
		jButton2 = new JButton();
		jButton3 = new JButton();
		jButton4 = new JButton();
		jTextArea1 = new JTextArea();
		jScrollPane1 = new JScrollPane();
		jList1 = new JList(v); 
 		jScrollPane2 = new JScrollPane(); 
		contentPane = (JPanel)this.getContentPane();
		//jTextArea1.setText("jTextArea1");
		jScrollPane1.setViewportView(jTextArea1);
		//
		// jLabel1
		//
		jLabel1.setForeground(new Color(51, 255, 102));
		jLabel1.setText("HOST NAME");
		//
		// jLabel2
		//
		jLabel2.setForeground(new Color(0, 255, 0));
		jLabel2.setText("SERVER NAME");
		//
		// jTextField1
		//
		jTextField1.setBackground(new Color(204, 255, 255));
		jTextField1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e)
			{
				jTextField1_actionPerformed(e);
			}

		});
		//
		// jTextField2
		//
		jTextField2.setBackground(new Color(204, 255, 255));
		jTextField2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e)
			{
				jTextField2_actionPerformed(e);
			}

		});
		//
		// jButton1
		//
		//jButton1.setBackground(new Color(145, 37, 141));
	//	jButton1.setForeground(new Color(51, 255, 255));
		jButton1.setText("REQUEST");
		jButton1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e)
			{
				jButton1_actionPerformed(e);
			}

		});
		
		
		
		//
		// jButton2
		//
	//	jButton2.setBackground(new Color(145, 37, 141));
	//	jButton2.setForeground(new Color(0, 255, 255));
		jButton2.setText("MFT REPORT");
		jButton2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e)
			{
				jButton2_actionPerformed(e);
			}

		});
		//
		// jButton3
		//
	//	jButton3.setBackground(new Color(145, 37, 141));
	//	jButton3.setForeground(new Color(51, 255, 255));
	/*	jButton3.setText("SEND MESSAGE");
		jButton3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e)
			{
				jButton3_actionPerformed(e);
			}

		});*/
		jButton4.setText("DISPLAY");
		jButton4.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e)
			{
				jButton4_actionPerformed(e);
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
		contentPane.setBackground(new Color(136, 138, 195));
		addComponent(contentPane, jLabel1, 56,83,82,30);
		addComponent(contentPane, jLabel2, 53,151,103,36);
		addComponent(contentPane, jTextField1, 207,81,103,33);
		addComponent(contentPane, jTextField2, 206,151,105,32);
		addComponent(contentPane, jScrollPane1, 429,78,225,228);
		addComponent(contentPane, jButton1, 72,315,94,46);
		addComponent(contentPane, jButton2, 166,315,105,46);
	//	addComponent(contentPane, jButton3, 271,315,124,46);
		addComponent(contentPane, jButton4, 271,315,124,46);
		addComponent(contentPane, jScrollPane2, 680,78,120,228); 
		//
		// RIGHT
		//
		this.setTitle("RIGHT - extends JFrame");
		this.setLocation(new Point(0, 0));
		this.setSize(new Dimension(820, 450));
		this.setVisible(true);
		
			try{
				
			String ip=InetAddress.getLocalHost().getHostAddress();
			System.out.println("IP ADDRESS : " + ip);
			jTextField1.setText(ip);
			
			db();
		//	System.out.println("hi");
			ResultSet rs1 = st.executeQuery("Select * from leftpath");
		//	System.out.println("hitoall");
			while(rs1.next())
			{		
			left_to_right=rs1.getInt(1);
			left_to_root=rs1.getInt(2);
			right_to_root=rs1.getInt(3); 
			System.out.println("From leftpath (Weight) " + left_to_right + " " + left_to_root +" " + right_to_root );
			break;
			} con.close();
		
			
			db();
			String root="root";
			ResultSet rs2 = st.executeQuery("Select * from iptablel where locationl='"+root+"'");
		//	int i = 0;
			
			while(rs2.next())
			{
				
				server= rs2.getString("hostnamel");              // take left host ip from db
				System.out.println("Server name " + server); 
				break;
			} con.close();
			jTextField2.setText(server);
			
			indirect_path=left_to_right + right_to_root;			
			flag=0;
			if(left_to_root>indirect_path)
			{
			flag=1;
			fromleft=new ServerSocket(1034);  // Receving from Left        1 serversocket for left
			
			
			while(true)
			{
			
			toleft=fromleft.accept();
			System.out.println("LEFT CONNECTED TO RIGHT");
			if(toleft.isConnected())
			{
			System.out.println("Listening for Left node...");
			System.out.println("Connected to Right Node");
			dis1=new DataInputStream(toleft.getInputStream());
		    dop1=new DataOutputStream(toleft.getOutputStream());	
			locaton_from_left=dis1.readUTF();
			hostname_from_left=dis1.readUTF();
			//String ack="Right Receiced the data From Left node";
			//dop1.writeUTF(ack);
			System.out.println("MAchine Location : " + locaton_from_left);
			System.out.println("Left machine Name :" + hostname_from_left);
			System.out.println("Right Receiced the Data From Left node");
		//	System.out.println("\n\n");
			// add your code here
			}
			
			}
			
			
			}
			}
			catch(Exception e)
			{
				e.printStackTrace();
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

	private void jTextField2_actionPerformed(ActionEvent e)
	{
		System.out.println("\njTextField2_actionPerformed(ActionEvent e) called.");
		// TODO: Add any handling code here

	}

	private void jButton1_actionPerformed(ActionEvent e)
	{
		

	}

	private void jButton2_actionPerformed(ActionEvent e)
	{
		
	}

	private void jButton3_actionPerformed(ActionEvent e)
	{
		System.out.println("\njButton3_actionPerformed(ActionEvent e) called.");
		// TODO: Add any handling code here

	}
	private void jButton4_actionPerformed(ActionEvent e)
	{
		System.out.println("\njdisplay_actionPerformed(ActionEvent e) called.");
		// TODO: Add any handling code here
		jTextArea1.setEditable(true);
		jTextArea1.setText(display);
		System.out.println(display);

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
		new RIGHTDESIGN();
	}
//= End of Testing =


}
