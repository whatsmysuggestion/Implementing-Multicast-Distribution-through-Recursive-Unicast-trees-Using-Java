import java.io.*;
import java.util.*;
class d
{
	//	public static Vector v;
	public Vector nodes()
		{
		Vector v=null;

		try
		{
			String dat = "";
			String tmp = "";
			int n;
			Process p=Runtime.getRuntime().exec("net view");
			//BufferedInputStream bir = new BufferedInputStream(p.getInputStream());
			DataInputStream bir = new DataInputStream(p.getInputStream());
			tmp=bir.readLine();
			while(tmp!=null)
			{
			if(tmp.startsWith("\\"))
			{
				String t=tmp.substring((tmp.lastIndexOf("\\")+1),tmp.length()-(tmp.indexOf("\\")+1));
				dat +=t.trim()+"\n";
			}
			tmp=bir.readLine();  

			}
		/*	
			while((n=bir.read()) != -1)
		         {
        		     dat = dat+(char)n;
		             tmp = dat;
			 }
	
*/	
	System.out.println(dat);	
	FileOutputStream fos = new FileOutputStream("node.txt");
			
	fos.write(dat.getBytes());
	DataInputStream input=new DataInputStream(new FileInputStream("node.txt"));
	String s="";
	s=input.readLine();
	v=new Vector();
	while(s!=null)
	{
		v.addElement(s.trim());	
		s=input.readLine();
	}
	System.out.println(v);

			
		}
		
		catch(Exception e)
			{
			System.out.println("Error in nodes selection " + e);
			}
			return v;
		}
		
		
		
		
			
	}