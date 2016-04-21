package gameHub;
/*@author: Ryan Cook
 *@version 1.0
 *@since   4/19/16
 *Class: CPSC 224-02
 *Description: This is the display for tic-tac-toe
 */


import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JFrame;
import javax.swing.JPanel;


public class MainFrame extends JFrame implements ActionListener{
	
	private JPanel p1 = new JPanel();
	private JPanel grid = new JPanel();
	private XOButton buttons[] = new XOButton[9];
	private Controller g1 = new Controller();

	
	
	public MainFrame(int x) {

		super("TicTacToe");
		setSize(800,800);
		setResizable(false);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		g1.SetComputer(x);
		p1.setLayout(new BorderLayout(0,0));
		setContentPane(p1);
		
		
		

		grid.setLayout(new GridLayout(3,3));
		p1.add(grid, BorderLayout.CENTER);

		for(int i = 0 ; i < 9 ; i++)
		{
			buttons[i] = new XOButton();
			grid.add(buttons[i]);
			buttons[i].setEnabled(true);
			buttons[i].addActionListener(this);
			buttons[i].setBackground(new Color(0,0,0));
		}
		add(grid);
		setVisible(true);
		
	}
	

	
	public void actionPerformed(ActionEvent e)
	{
		
		loop:
		for (int i = 0 ; i < 9 ; i++)
		{
			if(buttons[i] == e.getSource())
			{
				int x = i/3;
				int y = i - (3*x);
				if(!g1.humanMove(x, y))
					return;
				buttons[i].setPicture('x');
				if(g1.isDraw() || g1.hasWon())
				{
					winner();
					break loop;
				}
				int comp = g1.computerMove();
				buttons[comp].setPicture('o');
				if(g1.isDraw() || g1.hasWon())
				{
					winner();
					break loop;
				}		
			}
		
		}
	}
	
	public void winner()
	{
		if(g1.getWinner() == 'X')
		{
			g1.setGames(1);
		}
		else if(g1.getWinner() == 'O')
		{
			g1.setGames(2);
		}
		else if(g1.isDraw())
		{
			g1.setGames(3);
		}
		for(int i = 0 ; i < 9 ; i++)
			buttons[i].setEnabled(false);
	}
	
	
	
	public static void main(String[] args)
	{
		new MainFrame(1);	
		

	}
}
