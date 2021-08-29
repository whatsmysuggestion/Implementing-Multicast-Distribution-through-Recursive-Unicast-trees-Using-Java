/****************************************************************/
/*                      LEFT	                            */
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
import javax.swing.table.*;
/**
 * Summary description for LEFT
 *
 */
public class LEFTDESIGN extends JFrame
{
	// Variables declaration
	Socket echoSocket = null;
	DataInputStream dis=null;
	DataOutputStream dop=null;
	DataInputStream dis1=null;
	DataOutputStream dop1=null;
	Connection con;
	Statement  st;
	ResultSet  rs;
	int	left_to_right=0;
	int	left_to_root=0;
	int right_to_root=0;
	int indirect_path=0;
	String hostname;
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
	private JList jList1; 
 	private JScrollPane jScrollPane2;
	String right="right";
	String righthost="";
	String display;
	Vector v=new Vector();
	String ip;
	String server;
	// End of variables declaration


	public LEFTDESIGN()
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
		jButton1 = new JButton();
		jButton2 = new JButton();
		jTextArea1 = new JTextArea();
		jScrollPane1 = new JScrollPane();
		jButton3 = new JButton();
		jButton4 = new JButton();
		jList1 = new JList(v); 
 	jScrollPane2 = new JScrollPane(); 
		contentPane = (JPanel)this.getContentPane();
		
		jScrollPane1.setViewportView(jTextArea1);

		//
		// jLabel1
		//
		jLabel1.setBackground(new Color(0, 255, 51));
		jLabel1.setForeground(new Color(102, 255, 255));
		jLabel1.setText("HOST NAME");
		//
		// jLabel2
		//
		jLabel2.setBackground(new Color(102, 255, 255));
		jLabel2.setForeground(new Color(102, 255, 255));
		jLabel2.setText("SERVER NAME");
		//
		// jTextField1
		//
		jTextField1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e)
			{
				jTextField1_actionPerformed(e);
			}

		});
		
		//jTextArea1.setEnabled(false);
		//
		// jTextField2
		//
		jTextField2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e)
			{
				jTextField2_actionPerformed(e);
			}

		});
		//
		// jButton1
		//
		//jButton1.setBackground(new Color(223, 255, 224));
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
		//jButton2.setBackground(new Color(223, 255, 224));
		jButton2.setText("MFT TABLE");
		jButton2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e)
			{
				jButton2_actionPerformed(e);
			}

		});
		//
		// jButton3
		//
		//jButton3.setBackground(new Color(223, 255, 224));
		/*jButton3.setText("SEND MESSAGE");
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
		contentPane.setBackground(new Color(102, 102, 0));
		addComponent(contentPane, jLabel1, 68,67,93,30);
		addComponent(contentPane, jLabel2, 67,127,95,28);
		addComponent(contentPane, jTextField1, 206,69,101,31);
		addComponent(contentPane, jTextField2, 206,131,103,30);
		addComponent(contentPane, jScrollPane1, 429,78,225,228);
		addComponent(contentPane, jButton1, 47,317,101,47);
		addComponent(contentPane, jButton2, 148,317,99,47);
	//	addComponent(contentPane, jButton3, 247,317,144,47);
		addComponent(contentPane, jButton4, 247,317,144,47);
		addComponent(contentPane, jScrollPane2, 680,78,120,228); 
		//
		// LEFT
		//
		this.setTitle("LEFT - extends JFrame");
		this.setLocation(new Point(21, 8));
		this.setSize(new Dimension(820, 450));
		
		
		try{
		
			
			db();
			
			String ip=InetAddress.getLocalHost().getHostAddress();
			System.out.println("IP ADDRESS : " + ip);
			jTextField1.setText(ip);
			ResultSet rs = st.executeQuery("Select * from iptablel where locationl='"+right+"'");
		//	int i = 0;
			
			while(rs.next())
			{
				
				righthost= rs.getString("hostnamel");              // take left host ip from db
				System.out.println("From iptablel  " + righthost); 
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
			db();
	
			ResultSet rs1 = st.executeQuery("Select * from leftpath");
	
			while(rs1.next())
			{
		
			left_to_right=rs1.getInt(1);
			left_to_root=rs1.getInt(2);
			right_to_root=rs1.getInt(3);
 
			System.out.println("From leftpath  " + left_to_right + " " + left_to_root +" " + right_to_root );
			break;
			} con.close();
	
			indirect_path=left_to_right+right_to_root;
	}
			catch(Exception e)
			{
				System.out.println("Error in Left " + e);
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

	private void jButton1_actionPerformed(ActionEvent e)
	{
		System.out.println("\njRequest_actionPerformed(ActionEvent e) called.");
		
		EventQueue.invokeLater(new Runnable() {
			
                public void run() {
		// TODO: Add any handling code here
		try{
		
		if(left_to_root>indirect_path)
			{			
			System.out.println("Shortest path is left->right->Root");
			echoSocket = new Socket(righthost,1034);   //socket for left to right comm       1 Socket  1034
			System.out.println("Path Established From Left to Root via Right");
			dis = new DataInputStream(echoSocket.getInputStream());
			dop = new DataOutputStream(echoSocket.getOutputStream());
			String s=InetAddress.getLocalHost().toString();
			StringTokenizer st=new StringTokenizer(s,"/");
    		while(st.hasMoreTokens()) {
     		 hostname = st.nextToken();
      		System.out.println("Address of local host is : " + hostname);
			break;
			}
			dop.writeUTF("left");
			dop.writeUTF(hostname);
		//	String ack=dis.readUTF();
			//System.out.println("Acknoledgement : " + ack);
			System.out.println("Waiting for Acknoledgement...... ");
			String data_from_right = dis.readUTF();   // from right
			display=data_from_right;
			System.out.println("From Root  " + data_from_right);
			JOptionPane.showMessageDialog(null,"File or Message Received From Left","Group Notifier",JOptionPane.OK_OPTION);
			//System.out.println();
			//jTextArea1.setText(data_from_right);
			
			}
			else
			{
			db();
			String root="root";
			ResultSet rs3 = st.executeQuery("Select * from iptablel where locationl='"+root+"'");	
			String roothost="";
			while(rs3.next())
			{
				//i = 1;
			//	String ss=rs.getString(1);
				roothost= rs3.getString("hostnamel");              // take left host ip from db
				System.out.println("From iptablel  " + roothost); 
			//	break;
			} con.close();
			System.out.println("Shortest path is left->Root");
			echoSocket = new Socket(roothost,1033);   // left to root comm                  2 Socket  1033
			System.out.println("Path established From Left to Root");
			dis = new DataInputStream(echoSocket.getInputStream());
			dop = new DataOutputStream(echoSocket.getOutputStream());
			String s=InetAddress.getLocalHost().toString();
			StringTokenizer st=new StringTokenizer(s,"/");
    		while(st.hasMoreTokens()) {
     		 hostname = st.nextToken();
      		System.out.println("Address of local host is : " + hostname);
			break;
			}
			dop.writeUTF("left");
			dop.writeUTF(hostname);
			System.out.println("Waiting for Acknoledgement...... ");
			String data_from_root=dis.readUTF();
			display=data_from_root;
			System.out.println("From Root  " + data_from_root);
			JOptionPane.showMessageDialog(null,"File or Message Received From Root","Group Notifier",JOptionPane.OK_OPTION);
			
			}
		
		}
			catch(Exception e1)
			{
				System.out.println("Error in Left " + e1);
				e1.printStackTrace();
			}
                }

	}
	);
	}

	private void jButton2_actionPerformed(ActionEvent e)
	{  
		
		
	 db();
		int i=0;
		 try{
		 
		report r=new report();
		ResultSet rs4= st.executeQuery("Select * from iptablel");	
		String s1[]=new String[3];
		String s2;
		while(rs4.next())
		{  	
		s1[i]=rs4.getString(2);
		i++;
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
	private void jButton3_actionPerformed(ActionEvent e)
	{
		System.out.println("\nj Button3_actionPerformed(ActionEvent e) called.");
		// TODO: Add any handling code here

	}
	
	private void jButton4_actionPerformed(ActionEvent e)
	{
		System.out.println("\nj DISPALY_actionPerformed(ActionEvent e) called.");
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
		new LEFTDESIGN();
	}
//= End of Testing =


}
