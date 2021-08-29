
 /****************************************************************/ 
 /*                      report	                            */ 
 /*                                                              */ 
 /****************************************************************/ 
 import java.awt.*; 
 import java.awt.event.*; 
 import javax.swing.*; 
 /** 
  * Summary description for report 
  * 
  */ 
 public class reportroot extends JFrame 
 { 
 	// Variables declaration 
 	private JLabel jLabel1; 
 	private JLabel jLabel2; 
 	private JLabel jLabel3; 
 	private JLabel jLabel4; 
 	private JLabel jLabel5; 
 	 JTextField jTextField1; 
 	 JTextField jTextField2; 
 	 JTextField jTextField3; 
 	private JPanel contentPane; 
 	// End of variables declaration 
  
  
 	public reportroot() 
 	{ 
 		super(); 
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
 		jLabel3 = new JLabel(); 
 		jLabel4 = new JLabel(); 
 		jLabel5 = new JLabel(); 
 		jTextField1 = new JTextField(); 
 		jTextField2 = new JTextField(); 
 		jTextField3 = new JTextField(); 
 		contentPane = (JPanel)this.getContentPane(); 
  
 		// 
 		// jLabel1 
 		// 
 		
 		jLabel1.setBackground(new Color(0, 255, 51));
		jLabel1.setForeground(new Color(102, 255, 255));
 		//jLabel1.setBackground(new Color(255, 255, 255)); 
 		//jLabel1.setForeground(new Color(51, 255, 51)); 
 		jLabel1.setText("MACHINE LOCATION"); 
 		// 
 		// jLabel2 
 		// 
 		jLabel2.setForeground(new Color(102, 255, 255));
 		jLabel2.setText("DESTINATION HOST"); 
 		// 
 		// jLabel3 
 		// 
 		jLabel3.setForeground(new Color(102, 255, 255));
 		jLabel3.setText("ROOT NODE"); 
 		// 
 		// jLabel4 
 		// 
 		jLabel4.setForeground(new Color(102, 255, 255));
 		jLabel4.setText("LOCATION"); 
 		// 
 		// jLabel5 
 		// 
 		jLabel5.setForeground(new Color(102, 255, 255));
 		jLabel5.setText("NODE NAME"); 
 		// 
 		// jTextField1 
 		// 
 		jTextField1.setBackground(new Color(204, 255, 204)); 
 		jTextField1.addActionListener(new ActionListener() { 
 			public void actionPerformed(ActionEvent e) 
 			{ 
 				jTextField1_actionPerformed(e); 
 			} 
  
 		}); 
 		// 
 		// jTextField2 
 		// 
 		jTextField2.setBackground(new Color(204, 255, 204)); 
 		jTextField2.addActionListener(new ActionListener() { 
 			public void actionPerformed(ActionEvent e) 
 			{ 
 				jTextField2_actionPerformed(e); 
 			} 
  
 		}); 
 		// 
 		// jTextField3 
 		// 
 		jTextField3.setBackground(new Color(204, 255, 204)); 
 		jTextField3.addActionListener(new ActionListener() { 
 			public void actionPerformed(ActionEvent e) 
 			{ 
 				jTextField3_actionPerformed(e); 
 			} 
  
 		}); 
 		// 
 		// contentPane 
 		// 
 		contentPane.setLayout(null); 
 		contentPane.setBackground(new Color(156, 152, 144)); 
 		addComponent(contentPane, jLabel1, 68,117,130,30); 
 		addComponent(contentPane, jLabel2, 67,216,130,28); 
 		addComponent(contentPane, jLabel3, 69,317,78,18); 
 		//addComponent(contentPane, jLabel4, 70,46,60,18); 
 		//addComponent(contentPane, jLabel5, 255,40,85,26); 
 		addComponent(contentPane, jTextField1, 235,111,107,40); 
 		addComponent(contentPane, jTextField2, 233,208,109,42); 
 		addComponent(contentPane, jTextField3, 235,301,108,41); 
 		// 
 		// report 
 		// 
 		this.setTitle("report - extends JFrame"); 
 		this.setLocation(new Point(0, 0)); 
 		this.setSize(new Dimension(390, 400)); 
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
  
 	private void jTextField3_actionPerformed(ActionEvent e) 
 	{ 
 		System.out.println("\njTextField3_actionPerformed(ActionEvent e) called."); 
 		// TODO: Add any handling code here 
  
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
 		new reportroot(); 
 	} 
 //= End of Testing = 
  
  
 } 
  
 