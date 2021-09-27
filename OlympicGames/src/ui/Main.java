package ui;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

import model.Table;

public class Main {
	
	public static Table tb;
	
	public Main() {
		tb = new Table();
	}
	
	public static void main(String [] args) throws IOException {
		Main m = new Main();
		m.menu();
	}

	private void menu() throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String n = br.readLine();
		int num = Integer.parseInt(n);
		for(int i=0; i<num; i++) {	
			String line = br.readLine();
			String parts[] = line.split(";");
			int part1 = Integer.parseInt(parts[1]);
			int part2 = Integer.parseInt(parts[2]);
			int part3 = Integer.parseInt(parts[3]);
			int part4 = Integer.parseInt(parts[4]);
			int part5 = Integer.parseInt(parts[5]);
			int part6 = Integer.parseInt(parts[6]);
			tb.addCountry(parts[0], part1, part2, part3, part4, part5, part6);
		}
		System.out.print(tb.mSort(tb.getCts()));
		System.out.println("----------");
		System.out.print(tb.fSort(tb.getCts()));
		System.out.println("----------");
		System.out.print(tb.bubbleSort(tb.getCts()));
		System.out.println("----------");
		System.out.print(tb.insertionSort(tb.getCts()));
		br.close();
	}
}	
	


