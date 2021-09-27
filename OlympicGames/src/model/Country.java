package model;

public class Country implements Comparable<Country> {
	
	private String name;
	private int mGold, mSilver, mBronze, fGold, fSilver, fBronze, gold, silver, bronze;
	
	public Country(String n, int mg, int ms, int mb, int fg, int fs, int fb) {
		name = n;
		mGold = mg;
		mSilver = ms;
		mBronze = mb;
		fGold = fg;
		fSilver = fs;
		fBronze = fb;
		gold = mg + fg;
		silver = ms + fs;
		bronze = mb + fb;
	}
	
	@Override
	public int compareTo(Country ct) {
		int n = ct.getFGold() - fGold;
		if(n==0) {
			n = ct.getFSilver() - fSilver;
			if(n==0) {
				n = ct.getFBronze() - fBronze;
				if(n==0) {
					n = name.compareTo(ct.getName());
				}
			}
		}
		return n;
	}
	
	public String mPrint() {
		return name+" "+mGold+" "+mSilver+" "+mBronze;
	}
	
	public String fPrint() {
		return name+" "+fGold+" "+fSilver+" "+fBronze;
	}
	
	public String print() {
		return name+" "+gold+" "+silver+" "+bronze;
	}

	public String getName() {
		return name;
	}

	public int getMGold() {
		return mGold;
	}

	public int getMSilver() {
		return mSilver;
	}

	public int getMBronze() {
		return mBronze;
	}

	public int getFGold() {
		return fGold;
	}

	public int getFSilver() {
		return fSilver;
	}

	public int getFBronze() {
		return fBronze;
	}

	public int getGold() {
		return gold;
	}

	public int getSilver() {
		return silver;
	}

	public int getBronze() {
		return bronze;
	}
}
