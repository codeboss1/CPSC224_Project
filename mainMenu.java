package gameHub;

import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;

public abstract class mainMenu extends JFrame implements ActionListener{
	static JPanel panel = new JPanel();
	static JFrame frame = new JFrame("Game Hub");
	static JLabel label = new JLabel("GAME HUB");
	static JButton tictactoeButton  = new JButton();
	static JButton wordSearchButton = new JButton();
	static JButton ISpyButton = new JButton();
	static JButton highScoresButton = new JButton();
	static JButton userbutton = new JButton();
	
	public static void main(String s[]) {
		//layout
		panel.setLayout(new FlowLayout());
		panel.setBackground(new Color(186, 165, 232));
		
		createButton();
		addButton();
		setFrame();
		
		tictactoeButton.addActionListener(new ActionListener(){
		    @Override
		    public void actionPerformed(ActionEvent ev) {
		    	new MainFrame(1);                
		    }
		});
		wordSearchButton.addActionListener(new ActionListener(){
		    @Override
		    public void actionPerformed(ActionEvent ev) {
		    	wordsearch w1 = new wordsearch();
				w1.createBoard();                   
		    }
		});
		
		
	}
	

	private static void createButton() {
		//create button to change user
		userbutton.setText("Change User");
		userbutton.setBackground(new Color(131, 250, 20));
				
		//create button for tic tac toe
		tictactoeButton.setText("Tic-Tac-Toe");
		tictactoeButton.setBackground(new Color(131, 250, 20));
		
		//create button for word search
		wordSearchButton.setText("Word Search");
		wordSearchButton.setBackground(new Color(131, 250, 20));
		
		//create button for eye spy
		ISpyButton.setText("Eye Spy");
		ISpyButton.setBackground(new Color(131, 250, 20));
		
		//create button for high scores
		highScoresButton.setText("High Scores");
		highScoresButton.setBackground(new Color(131, 250, 20));
	}
	private static void addButton(){
		//add all buttons to panel
		panel.add(label);
		panel.add(tictactoeButton);	
		panel.add(wordSearchButton);
		panel.add(ISpyButton);
		panel.add(highScoresButton);
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
