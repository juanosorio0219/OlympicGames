package model;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class Table implements Comparator<Country>{
	
	private List<Country> cts;
	
	public Table() {
		cts = new ArrayList<>();
		
	}

	public List<Country> getCts() {
		return cts;
	}
	
	public void addCountry(String n, int mg, int ms, int mb, int fg, int fs, int fb) {
		Country ct = new Country(n, mg, ms, mb, fg, fs, fb);
		cts.add(ct);
	}
	
	public String fSort(List<Country> cts) {
		for(int i=1; i<cts.size(); i++) {
			for(int j=i-1; j>-1; j--) {
				int n = cts.get(i).compareTo(cts.get(j));
				if(n>0) {
					Country temp = cts.get(i);
					cts.remove(i);
					cts.add(j, temp);
					i--;
				}
			}
		}
		return fPrint(cts);
	}
	
	public String mSort(List<Country> cts) {
		for(int i=1; i<cts.size(); i++) {
			for(int j=i-1; j>-1; j--) {
				int n = compare(cts.get(i), cts.get(j));
				if(n>0) {
					Country temp = cts.get(i);
					cts.remove(i);
					cts.add(j, temp);
					i--;
				}
			}	
		}
		return mPrint(cts);
	}
	
	@Override
	public int compare(Country ct1, Country ct2) {
		int n = ct1.getMGold() - ct2.getMGold();
		if(n==0) {
			n = ct1.getMSilver() - ct2.getMSilver();
			if(n==0) {
				n = ct1.getMBronze() - ct2.getMBronze();
				if(n==0) {
					n = ct1.getName().compareTo(ct2.getName());
				}
			}
		}
		return n;
	}
	
	public String bubbleSort(List<Country> cts) {
		for(int i=1; i<cts.size(); i++) {
			for(int j=i-1; j>=0; j--) {
				int n = sortAscendant(cts.get(i), cts.get(j));
				if(n>0) {
					Country temp = cts.get(i);
					cts.remove(i);
					cts.add(j, temp);
					i--;
				}
			}
		}
		return print(cts);
	}
	
	public String insertionSort(List<Country> cts) {
		List<Country> insert = new ArrayList<>();
		insert.add(cts.get(0));
		for(int i=1; i<cts.size(); i++) {
			for(int j=0; j<insert.size(); j++) {
				int n = sortAscendant(cts.get(i), insert.get(j));
				if(n>0) {
					insert.add(j, cts.get(i));
				}
			}
		}
		return print(cts);
	}
	
	private int sortAscendant(Country ct1, Country ct2) {
		int n = ct1.getGold() - ct2.getGold();
		if(n==0) {
			n = ct1.getSilver() - ct2.getSilver();
			if(n==0) {
				n = ct1.getBronze() - ct2.getBronze();
				if(n==0) {
					n = ct1.getName().compareTo(ct2.getName());
				}
			}
		}
		return n;
	}
	
	private String mPrint(List<Country> cts) {
		String msg = "Masculino\n";
		for(int i=0; i<cts.size(); i++) {
			msg += cts.get(i).mPrint()+"\n";
		}
		return msg;
	}
	
	private String fPrint(List<Country> cts) {
		String msg = "Femenino\n";
		for(int i=0; i<cts.size(); i++) {
			msg += cts.get(i).fPrint()+"\n";
		}
		return msg;
	}
	
	private String print(List<Country> cts) {
		String msg = "Combinado\n";
		for(int i=0; i<cts.size(); i++) {
			msg += cts.get(i).print()+"\n";
		}
		return msg;
	}
}
