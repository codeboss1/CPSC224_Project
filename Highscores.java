import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;

import javax.swing.JOptionPane;

public class Highscores {

	static ArrayList<Integer> al = new ArrayList();
	static ArrayList<String> alnames = new ArrayList();
	
	private static String name;

	public Highscores() {

	}

	public static void getScores() {
		BufferedReader br = null;

		try {
			String sCurrentLine;

			br = new BufferedReader(new FileReader("C:/Users/soare/java/workspace/Project_all/highscores.txt"));

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
	}
}
