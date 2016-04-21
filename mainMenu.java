package gameHub;
/*@author: Kevin Do
 *@version 1.0
 *@since   4/21/16
 *Class: CPSC 224-02
 *Description: Main Menu for GameHub
 */
import java.awt.Color;
import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.FlowLayout;
import java.awt.Font;
import java.io.IOException;
import javax.swing.*;

public abstract class mainMenu extends JFrame implements ActionListener{
	
	static JPanel panel = new JPanel();					//new panel
	static JFrame frame = new JFrame("Game Hub");		//title
	static JLabel label = new JLabel("GAME HUB");		//title
	static JButton tictactoeButton  = new JButton();	//tic-tac-toe button
	static JButton wordSearchButton = new JButton();	//word search button
	static JButton ISpyButton = new JButton();			//ispy button
	static JButton highScoresButton = new JButton();	//high score button
	static JButton userbutton = new JButton(); 			//user button
	
	//main function
	public static void main(String s[]) {
		createButton();
		addButton();
		setFrame();
		buttonlistener();	
	}
	
	//determines what runs when a button is pressed
	private static void buttonlistener(){
		tictactoeButton.addActionListener(new ActionListener(){
		    @Override
		    public void actionPerformed(ActionEvent ev) {
		    	new MainFrame(3);                
		    }
		});
		wordSearchButton.addActionListener(new ActionListener(){
		    @Override
		    public void actionPerformed(ActionEvent ev) {
		    	wordsearch w1 = new wordsearch();
				w1.createBoard("tester");                   
		    }
		});
		ISpyButton.addActionListener(new ActionListener(){
		    @Override
		    public void actionPerformed(ActionEvent ev) {
		    	try {
					ISpy_Main.main(null);
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}                  
		    }
		});
		
		highScoresButton.addActionListener(new ActionListener(){
		    @Override
		    public void actionPerformed(ActionEvent ev) {
		    	Highscores.main(null);
		    }
		});
		
		userbutton.addActionListener(new ActionListener(){
		    @Override
		    public void actionPerformed(ActionEvent ev) {
		    	Users use = new Users();
		    	use.setUser();
		    }
		});
	}

	//create the buttons
	private static void createButton() {
		//create button to change user
		userbutton.setText("Change User");
		userbutton.setBackground(new Color(131, 250, 20));
		userbutton.setPreferredSize(new Dimension(175, 50));
		userbutton.setFont(new Font("Arial", Font.PLAIN, 20));

				
		//create button for tic tac toe
		tictactoeButton.setText("Tic-Tac-Toe");
		tictactoeButton.setBackground(new Color(131, 250, 20));
		tictactoeButton.setPreferredSize(new Dimension(175, 50));
		tictactoeButton.setFont(new Font("Arial", Font.PLAIN, 20));
		
		//create button for word search
		wordSearchButton.setText("Word Search");
		wordSearchButton.setBackground(new Color(131, 250, 20));
		wordSearchButton.setPreferredSize(new Dimension(175, 50));
		wordSearchButton.setFont(new Font("Arial", Font.PLAIN, 20));
		
		//create button for eye spy
		ISpyButton.setText("Eye Spy");
		ISpyButton.setBackground(new Color(131, 250, 20));
		ISpyButton.setPreferredSize(new Dimension(175, 50));
		ISpyButton.setFont(new Font("Arial", Font.PLAIN, 20));
		
		//create button for high scores
		highScoresButton.setText("High Scores");
		highScoresButton.setBackground(new Color(131, 250, 20));
		highScoresButton.setPreferredSize(new Dimension(175, 50));
		highScoresButton.setFont(new Font("Arial", Font.PLAIN, 20));
	}
	
	//add buttons to panel
	private static void addButton(){
		//add all buttons to panel
		panel.add(label);
		panel.add(tictactoeButton);	
		panel.add(wordSearchButton);
		panel.add(ISpyButton);
		panel.add(highScoresButton);
		panel.add(userbutton);
	}
	
	//set layout, font and size of title, set location 
	private static void setFrame(){
		label.setFont(new Font("Arial", Font.PLAIN, 50));
		//layout
		panel.setLayout(new FlowLayout());
		panel.setBackground(new Color(186, 165, 232));frame.add(panel);
		//set frame
		frame.setSize(375, 450);
		frame.setLocation(400,200);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setVisible(true);

		}
}
