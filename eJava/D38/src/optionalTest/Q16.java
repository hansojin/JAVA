package optionalTest;

import java.util.Optional;

class Contlnfo {
    String phone;   // null 일 수 있음
    String adrs;    // null 일 수 있음

    public Contlnfo(String ph, String ad) {
        phone = ph;
        adrs = ad;
    }

    public String getPhone() { return phone; }
    public String getAdrs() { return adrs; }

}

public class Q16 {
	public static void main(String[] args) {
        Optional<Contlnfo> ci = Optional.of(new Contlnfo(null, "Republic of Korea")) ;
        
        String phone = ci.map(s->s.getPhone()).orElse("No data");
        String addr =ci.map(s->s.getAdrs()).orElse("No data");

        System.out.println(phone);
        System.out.println(addr);
    }
}
