package gameHub;

import java.awt.Color;
import java.awt.FlowLayout;
import javax.swing.*;

public class mainMenu{
	static JPanel panel = new JPanel();
	static JFrame frame = new JFrame("Game Hub");
	static JLabel label = new JLabel("GAME HUB");
	static JButton button1  = new JButton();
	static JButton button2 = new JButton();
	static JButton button4 = new JButton();
	static JButton button3 = new JButton();
	static JButton userbutton = new JButton();
	
	public static void main(String s[]) {
		//layout
		panel.setLayout(new FlowLayout());
		panel.setBackground(new Color(186, 165, 232));
		
		createButton();
		addButton();
		setFrame();
		
		
	}

	private static void createButton() {
		//create button to change user
		userbutton.setText("Change User");
		userbutton.setBackground(new Color(131, 250, 20));
				
		//create button for tic tac toe
		button1.setLayout(null);
		button1.setText("Tic-Tac-Toe");
		button1.setBackground(new Color(131, 250, 20));
		
		//create button for word search
		button2.setText("Word Search");
		button2.setBackground(new Color(131, 250, 20));
		
		//create button for eye spy
		button3.setText("Eye Spy");
		button3.setBackground(new Color(131, 250, 20));
		
		//create button for high scores
		button4.setText("High Scores");
		button4.setBackground(new Color(131, 250, 20));
	}
	private static void addButton(){
		//add all buttons to panel
		panel.add(label);
		panel.add(button1);	
		panel.add(button2);
		panel.add(button3);
		panel.add(button4);
		panel.add(userbutton);
	}
	
	private static void setFrame(){
		//set frame
		frame.add(panel);
		frame.setSize(150, 250);
		frame.setLocation(100,95);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setVisible(true);

		}
}