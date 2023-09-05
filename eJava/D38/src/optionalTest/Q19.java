package optionalTest;

import java.util.Optional;

class ContIInfo {
    Optional<String> phone;   // null 일 수 있음
    Optional<String> adrs;    // null 일 수 있음

    public ContIInfo(Optional<String> ph, Optional<String> ad) {
        phone = ph;
        adrs = ad;
    }
    public Optional<String> getPhone() { return phone; }
    public Optional<String> getAdrs() { return adrs; }
}

public class Q19 {
	public static void main(String[] args) {
        Optional<ContIInfo> ci = Optional.of(
            new ContIInfo(Optional.ofNullable(null), Optional.of("Republic of Korea"))
        );
        
        String phone = ci.flatMap(s->s.getPhone()).orElse("No data");

        String addr = ci.flatMap(s->s.getAdrs()).orElse("No data");
          
        System.out.println(phone);
        System.out.println(addr);
    }
}
