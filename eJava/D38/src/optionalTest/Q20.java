package optionalTest;

import java.util.Optional;

class Frn {
    String name;
    Optional<Cmpy> cmp;    // null 일 수 있음

    public Frn(String n, Optional<Cmpy> c) {
        name = n;
        cmp = c;
    }

    public String getName() { return name; }
    public Optional<Cmpy> getCmp() { return cmp; }
}

class Cmpy {
    String cName;
    Optional<CInfo> cInfo;    // null 일 수 있음

    public Cmpy(String cn, Optional<CInfo> ci) {
        cName = cn;
        cInfo = ci;
    }

    public String getCName() { return cName; }
    public Optional<CInfo> getCInfo() { return cInfo; }

}

class CInfo {
	Optional<String> phone;   // null 일 수 있음
	Optional<String> adrs;    // null 일 수 있음

    public CInfo(Optional<String> ph, Optional<String> ad) {
        phone = ph;
        adrs = ad;
    }

    public Optional<String> getPhone() { return phone; }
    public Optional<String> getAdrs() { return adrs; }

}

public class Q20 {
	public static void showCompAddr(Optional<Frn> f) {
        String addr = f.flatMap(Frn::getCmp).flatMap(Cmpy::getCInfo)
        		.flatMap(CInfo::getAdrs).orElse("NO DATA");
        System.out.println(addr);
    }

    public static void main(String[] args) {
    	Optional<CInfo> ci = Optional.of(new CInfo(Optional.ofNullable(null), Optional.ofNullable("Republic of Korea")));
    	Optional<Cmpy> cp = Optional.of(new Cmpy("YaHo Co., Ltd.", ci));
        Frn frn = new Frn("LEE SU", cp);

        // 친구 정보에서 회사 주소를 출력
        showCompAddr(Optional.of(frn));
    }
}
