package ystd;

import java.util.Optional;

class SIX {
	Optional<String> phone;   // null 일 수 있음
	Optional<String> adrs;    // null 일 수 있음

    public SIX(Optional<String> ph, Optional<String> ad) {
        phone = ph;
        adrs = ad;
    }

    public Optional<String> getPhone() { return phone; }
    public Optional<String> getAdrs() { return adrs; }

}

public class Q16 {
	 public static void main(String[] args) {
	        SIX ci = new SIX(Optional.ofNullable(null), Optional.of("Republic of Korea"));
	        
	        String phone = ci.getPhone().orElse("Empty");
	        String addr = ci.getAdrs().orElse("Empty");

	        System.out.println(phone);
	        System.out.println(addr);
	    }
}
