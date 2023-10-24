
public class RabinKarpomSearch {
	String txt,pat;
	int txtH,patH;
	int fcFactor = 1;
	int LP = 15231243;
	public RabinKarpomSearch(String txt, String pat) {
		if(pat.length()>txt.length())
			throw new IllegalArgumentException();
		this.txt = txt;
		this.pat = pat;
		this.txtH = computeHash(txt, pat.length());
		this.patH = computeHash(pat, pat.length());
		for (int i = 0; i < pat.length()-1; i++) {
			fcFactor = (fcFactor*31)%LP;
		}
	}
	private int computeHash(String str, int len) {
		int hash = 0;
		for (int i = 0; i < len; i++) {
			hash = ((hash*31)%LP + str.charAt(i))%LP;
		}
		return hash;
	}
	
	private void updateHash(int pos) {
		txtH = (LP + txtH - (txt.charAt(pos)*fcFactor)%LP)%LP;
		txtH = ((txtH*31)%LP + txt.charAt(pos+pat.length()))%LP;
	}
	public int search() {
		int lastA = txt.length()-pat.length();
		for (int i = 0; i <= lastA; i++) {
			if(patH==txtH) {
				boolean match = true;
				int j = 0;
				while(j<pat.length() && match) {
					if(pat.charAt(j) != txt.charAt(i+j))
						match = false;
					else
						j++;
				}
				if(match)
					return i;
			}
			if(i<lastA)
				updateHash(i);
		}
		return -1;
	}
}

