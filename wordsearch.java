import java.awt.Color;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;

public class wordsearch extends JFrame{

String[][] searchtable = new String[6][6];
String[] wordsList = {"Black", "Pink", "Blue", "Red", "Green", "White"};
int[] wordFound = new int[6];
private Timer gameTimer = null;
private int timePlayed = 0;

private JLabel positionLabel;
private JButton resetButton;
private static int gridSize = 6;
public static String pressed;
public int whichPressed = 0;
public static String pressed1;
public static String pressed2;
private Boolean gameDone = false;
private String username1;


	public Boolean gameFinished() 
	{
		return gameDone;
	}
	public wordsearch() {
		
		searchtable[0][0] = "K";
		searchtable[1][0] = "N";
		searchtable[2][0] = "I";
		searchtable[3][0] = "P";
		searchtable[4][0] = "O";
		searchtable[5][0] = "N";
		searchtable[0][1] = "C";
		searchtable[1][1] = "C";
		searchtable[2][1] = "N";
		searchtable[3][1] = "R";
		searchtable[4][1] = "E";
		searchtable[5][1] = "D";
		searchtable[0][2] = "T";
		searchtable[1][2] = "O";
		searchtable[2][2] = "A";
		searchtable[3][2] = "E";
		searchtable[4][2] = "U";
		searchtable[5][2] = "V";
		searchtable[0][3] = "J";
		searchtable[1][3] = "K";
		searchtable[2][3] = "R";
		searchtable[3][3] = "L";
		searchtable[4][3] = "L";
		searchtable[5][3] = "H";
		searchtable[0][4] = "Y";
		searchtable[1][4] = "G";
		searchtable[2][4] = "J";
		searchtable[3][4] = "N";
		searchtable[4][4] = "B";
		searchtable[5][4] = "Q";
		searchtable[0][5] = "E";
		searchtable[1][5] = "T";
		searchtable[2][5] = "I";
		searchtable[3][5] = "H";
		searchtable[4][5] = "W";
		searchtable[5][5] = "V";
	}

	@SuppressWarnings("null")
	public void createBoard(String username)
	{
		username1 = username;
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);

        JPanel contentPane = new JPanel();
        contentPane.setLayout(new BorderLayout(0,0));
        final JLabel words = new JLabel();
       
       


       

        JPanel buttonPanel = new JPanel();
        buttonPanel.setLayout(new GridLayout(gridSize, gridSize));
        for (int i = 0; i < gridSize; i++)
        {
            for (int j = 0; j < gridSize; j++)
            {
                JButton button = new JButton(searchtable[j][i]);
                button.setPreferredSize(new Dimension(50, 50));
                button.setActionCommand(String.valueOf(i)+String.valueOf(j));
                button.addActionListener(new ActionListener()
                {
                    public void actionPerformed(ActionEvent ae)
                    {
                        JButton but = (JButton) ae.getSource();
                        pressed = but.getActionCommand();    
                        System.out.println(pressed);
                        if(whichPressed == 0)
                        {
                        	pressed1 = pressed;
                        	whichPressed = 1;
                        }
                        else if(whichPressed == 1)
                        {
                        	pressed2 = pressed;
                        	whichPressed = 0;
                        	checkFound(pressed1,pressed2);
                        	words.setText(wordsList[0] + "   " + wordsList[1] + "   " + wordsList[2] + "   " + wordsList[3] + "   " + wordsList[4] + "   " + wordsList[5]);
                        }
                        
                    }
                });
                buttonPanel.add(button);
            }
        }
        contentPane.add(buttonPanel, BorderLayout.CENTER);

        setContentPane(contentPane);
        pack();
        setLocationByPlatform(true);
        setVisible(true);
        
        
        String tempSearch = wordsList[0] + "   " + wordsList[1] + "   " + wordsList[2] + "   " + wordsList[3] + "   " + wordsList[4] + "   " + wordsList[5];
        
        words.setText(tempSearch);
        contentPane.add(words, BorderLayout.SOUTH);
        final JLabel timerTop = new JLabel("Time:" + timePlayed, SwingConstants.RIGHT);
        contentPane.add(timerTop, BorderLayout.NORTH);
        gameTimer = new Timer(1000, new ActionListener(){
        	public void actionPerformed(ActionEvent e) {
        		timePlayed += 1;
        		timerTop.setText("Time:" + timePlayed);
        	}
        });
        
        
        
	}
	
	public void updateList(int i) {
    	if(i > 5)
    	{
    		return;
    	}
    	else {
    		wordsList[i] = "";
    		wordFound[i] = 1;
    	}
    }
	
	public void checkFound(String a, String b)
	{
		String h1 = a.substring(0,1);
		String h2 = a.substring(1,2);
		String h3 = b.substring(0,1);
		String h4 = b.substring(1,2);
		System.out.println(h1+h2+h3+h4);
		int selection = Integer.parseInt(5 + h1+h2+h3+h4);
		if(selection == 51315)
		{
			updateList(3);
		}
		else if(selection == 54400)
		{
			updateList(0);
		}
		else if(selection == 54414)
		{
			updateList(2);
		}
		else if(selection == 50300)
		{
			updateList(1);
		}
		else if(selection == 54105)
		{
			updateList(4);
		}
		else if(selection == 55450)
		{
			updateList(5);
		}
		int sum = 0;
		for(int p : wordFound)
			sum += p;
		if(sum == 6)
		{
			JOptionPane.showMessageDialog(null,"You Won!");
			gameDone = true;
			endofgame e1 = new endofgame();
			e1.endOfGameWindow(400, username1);
			this.dispose();
		}
	}
}
