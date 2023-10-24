import java.util.HashMap;

public class QuickSearch {
	String pat;
	int largeShift;
	HashMap<Character, Integer> shiftMap = new HashMap<>();
	public QuickSearch(String pat) {
		this.pat = pat;
		int shift = 1;
		this.largeShift = pat.length()+1;
		for (int i = pat.length()-1; i >= 0; i--) {
			char c = pat.charAt(i);
			if(!shiftMap.containsKey(c)) {
				shiftMap.put(c, shift);
			}
			shift++;
		}
	}
	private int shift(char c) {
		Integer s = shiftMap.get(c);
		return s==null ? largeShift : s;
	}
	
	public int search(String txt) {
		if(pat.length()>txt.length())
			throw new IllegalArgumentException();
		int i = 0;
		do {
			boolean match = true;
			int j = 0;
			while(match && j<pat.length()) {
				if(pat.charAt(j) != txt.charAt(i+j))
					match = false;
				else
					j++;
			}
			if(match)
				return i;
			if(i==txt.length()-pat.length())
				return -1;
			char test = txt.charAt(i+pat.length());
			i+=shift(test);
		} while (i<=txt.length()-pat.length());
		return -1;
	}
}
















