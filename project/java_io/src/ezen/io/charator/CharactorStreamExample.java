package ezen.io.charator;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Calendar;

public class CharactorStreamExample {
	
	static String file = "src/ezen/io/bytee/BufferedInputExample.java";
	
	public static void readCharactor() throws IOException {
		BufferedReader in = new BufferedReader(new FileReader(file));
		String txt = null;
		while((txt=in.readLine()) != null) {
			System.out.println(txt);
		}
		in.close();
	}
	
	public static void writeCharactor() throws IOException {
		String newFile = "example3.txt";
		
		PrintWriter out = new PrintWriter(newFile);
		out.print(true);
		out.print('김');
		out.print("기정");
		out.print(50);
		out.print(50.56);
		out.println();
		out.printf("%1$tF %1$tT", Calendar.getInstance());
		out.close();
	}
	

	public static void main(String[] args) throws IOException {
		readCharactor();
		writeCharactor();

	}

}
