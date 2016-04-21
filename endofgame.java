import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowEvent;
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.nio.file.*;

import javax.swing.*;

public class endofgame{
	private int score = 0; //score that is displayed
	private String username; //username
	private Boolean play = false;//currently not used, might be used for functionality of try again
	
	public Boolean playAgain()
	{
		return play;
	}
	
	private void setScore(int a) 
	{
		score = a;
	}
	private void setUser(String a)
	{
		username = a;
	}

	
	public void endOfGameWindow(int userScore, final String name, final int game_id)
	{
		setScore(userScore);
		setUser(name);
		final JFrame thisframe = new JFrame();
		thisframe.setVisible(true);
		thisframe.setPreferredSize(new Dimension(300,300));
		thisframe.setLocation(300, 300);
		thisframe.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);

        JPanel contentPane = new JPanel();
        contentPane.setLayout(new BorderLayout(0,0));
        contentPane.setBackground(Color.YELLOW);
        JLabel words = new JLabel("Game Complete", SwingConstants.CENTER);	
		Font labelFont = words.getFont();
		words.setFont(new Font(labelFont.getName(), Font.BOLD, 37));
		
		
		
		JLabel scoreText = new JLabel("Your Score: " + score, SwingConstants.CENTER);
		Font scoreTxt = scoreText.getFont();
		scoreText.setFont(new Font(scoreTxt.getName(), Font.BOLD, 30));
		contentPane.add(scoreText, BorderLayout.CENTER);
		
		JPanel buttons = new JPanel();
		buttons.setBackground(Color.YELLOW);
		JButton submitScore = new JButton("Submit Score");
		JButton tryAgain = new JButton("Try Again");
		tryAgain.addActionListener(new ActionListener()
        {
            public void actionPerformed(ActionEvent ae)
            {
            	play = true;
            	
            	if (game_id == 1){
    		    	new MainFrame(3); 
            	}
            	
            	if (game_id == 2){
        		    	wordsearch w1 = new wordsearch();
        				w1.createBoard("tester");  
            	}
            	
            	if (game_id == 3){
            		try {
						ISpy_Main.main(null);
					} catch (IOException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
            	}
            	
            	thisframe.dispose();
            }
        });
		submitScore.addActionListener(new ActionListener()
        {
            public void actionPerformed(ActionEvent ae)
            {
            	try(FileWriter fw = new FileWriter("highscores.txt", true);
            			
            		    BufferedWriter bw = new BufferedWriter(fw);
            		    PrintWriter out = new PrintWriter(bw))
            		{
            		    out.println(score+","+username);
            		} catch (IOException e) {
            		    System.out.print(e);//exception handling left as an exercise for the reader
            		}

            }
        });
		buttons.add(submitScore);
		buttons.add(tryAgain);
		
		
		contentPane.add(words, BorderLayout.NORTH);
		contentPane.add(buttons,  BorderLayout.SOUTH);
		
		thisframe.setContentPane(contentPane);
		thisframe.pack();
		
	}
	
	
	
}
