package gameHub;
import java.awt.Color;
import java.awt.FlowLayout;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;

import javax.swing.DefaultListModel;
import javax.swing.JFrame;
import javax.swing.JList;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

public class Highscores {

	static ArrayList<Integer> al = new ArrayList();
	static ArrayList<String> alnames = new ArrayList();
	static ArrayList<String> alresult = new ArrayList();
	private static String name;
	
	static JFrame frame = new JFrame("Highscores");
	static JPanel panel = new JPanel();

	public static void main(String s[]) {
		getScores();
		panel.setLayout(new FlowLayout());
		panel.setBackground(new Color(186, 165, 232));
		
		DefaultListModel listModel = new DefaultListModel();
		for (Object item : alresult) {
			item.toString();
			listModel.addElement(item);
		}
		JList list = new JList(listModel);

		list.setBounds(10, 10, 260, 270);
		panel.setBounds(10, 10, 260, 270);
		panel.add(list);
		frame.add(panel);
		frame.setBounds(0,0,300,300);
		frame.setVisible(true);
	}
	
	
	public Highscores() {

	}

	public static void getScores() {
		BufferedReader br = null;

		try {
			String sCurrentLine;

			br = new BufferedReader(new FileReader("D:/workspace/gameHub/highscores.txt"));

			while ((sCurrentLine = br.readLine()) != null) {
				
				String[] str_array = sCurrentLine.split(",");
				int str1 = 	Integer.parseInt(str_array[0]);
				String str2 = str_array[1];
				al.add(str1);
				alnames.add(str2);
			}

		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			try {
				if (br != null)
					br.close();
			} catch (IOException ex) {
				ex.printStackTrace();
			}
		}
		
		for(int i = 0; i < al.size()-1; i++){
			for(int j = 0; j < al.size()-1; j++){
				int temp = al.get(j);
				String temp2 = alnames.get(j);
				if (temp < al.get(j+1)){
					al.set(j, al.get(j+1));
					alnames.set(j, alnames.get(j+1));
					al.set(j+1, temp);
					alnames.set(j+1, temp2);
				}
			}
		}
		
		
		System.out.println(al);
		System.out.println(alnames);
		System.out.println(al.size());
		
		for(int i = 0; i < al.size()-1; i++){
			String temps = al.get(i).toString() + " - " + alnames.get(i);
			alresult.add(temps);
		}
		System.out.println(alresult);
	}
}
