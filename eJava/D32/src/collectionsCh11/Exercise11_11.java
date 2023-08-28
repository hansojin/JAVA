package collectionsCh11;

import java.util.*;

class SuttdaCard {
	int num;
	boolean isKwang;
	SuttdaCard() {
		this(1, true);
	}
	SuttdaCard(int num, boolean isKwang) {
		this.num = num;
		this.isKwang = isKwang;
	}
	public boolean equals(Object obj) {
		if(obj instanceof SuttdaCard) {
			SuttdaCard c = (SuttdaCard)obj;
			return num==c.num && isKwang==c.isKwang;
		} else {
			return false;
		}
	}
	public String toString() {
		return num + ( isKwang ? "K":"");
	}
	public int hashCode() {
		return Objects.hash(num,isKwang);
	}
	
}

class Exercise11_11 {
	public static void main(String[] args) {
		SuttdaCard c1 = new SuttdaCard(3,true);
		SuttdaCard c2 = new SuttdaCard(3,true);
		SuttdaCard c3 = new SuttdaCard(1,true);
		HashSet set = new HashSet();
		set.add(c1);
		set.add(c2);
		set.add(c3);
		System.out.println(set);
	}
}