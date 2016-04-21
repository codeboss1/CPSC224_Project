import javax.swing.JOptionPane;

public class Users {

	private static String name;
	public Users(){
		
	}
	
	public void setUser(){
   	 name = JOptionPane.showInputDialog(null,
   			 "What is your name?", "");
   			 //JOptionPane.INFORMATION_MESSAGE;
   	 System.out.println(name + "  selected");
   	 
	}
	
	public static String getUser(){
		return name;
	}
	
}
