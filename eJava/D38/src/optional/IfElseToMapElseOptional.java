package optional;

import java.util.Optional;

class CntryInfo {
    String phone;   // null 일 수 있음
    String adrs;    // null 일 수 있음

    public CntryInfo(String ph, String ad) {
        phone = ph;
        adrs = ad;
    }
    public String getPhone() { return phone; }
    public String getAdrs() { return adrs; }
}

class IfElseToMapElseOptional {
    public static void main(String[] args) {

        Optional<CntryInfo> ci = Optional.of(
                                   new CntryInfo(null, "Republic of Korea")
                                );
        
        String phone = ci.map(c -> c.getPhone())
                         .orElse("There is no phone number.");

        String addr = ci.map(c -> c.getAdrs())
                        .orElse("There is no address.");
          
        System.out.println(phone);
        System.out.println(addr);
    }
}