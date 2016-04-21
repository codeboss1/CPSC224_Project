/*@author: Ryan Cook
 *@version 1.0
 *@since   4/19/16
 *Class: CPSC 224-02
 *Description: This is the button setup for tic-tac-toe
 */


import javax.swing.*;


public class XOButton extends JButton {
	ImageIcon X;
	ImageIcon O;
		
	public XOButton() 
	{
		O = new ImageIcon("C:/Users/soare/java/workspace/Project_all/src/Oimage.jpg");
		X = new ImageIcon("C:/Users/soare/java/workspace/Project_all/src/Ximage.jpg");
		
	}
	
	public void setPicture(char x)
	{
		if (x == 'x')
			setIcon(X);
		else if(x == 'o')
			setIcon(O);
		else
			setIcon(null);
	}
}

