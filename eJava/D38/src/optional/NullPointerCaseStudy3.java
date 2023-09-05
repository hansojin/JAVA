package optional;

import java.util.Optional;

class Friiend {
    String name;
    Optional<Conpany> cmp;    // null 일 수 있음

    public Friiend(String n, Optional<Conpany> c) {
        name = n;
        cmp = c;
    }
    public String getName() { return name; }
    public Optional<Conpany> getCmp() { return cmp; }
}

class Conpany {
    String cName;
    Optional<Contlnfo> cInfo;    // null 일 수 있음

    public Conpany(String cn, Optional<Contlnfo> ci) {
        cName = cn;
        cInfo = ci;
    }
    public String getCName() { return cName; }
    public Optional<Contlnfo> getCInfo() { return cInfo; }

}

class Contlnfo {
    Optional<String> phone;   // null 일 수 있음
    Optional<String> adrs;    // null 일 수 있음

    public Contlnfo(Optional<String> ph, Optional<String> ad) {
        phone = ph;
        adrs = ad;
    }
    public Optional<String> getPhone() { return phone; }
    public Optional<String> getAdrs() { return adrs; }

}

class NullPointerCaseStudy3 {
    public static void showCompAddr(Optional<Friiend> f) {

        String addr = f.flatMap(Friiend::getCmp)
                .flatMap(Conpany::getCInfo)
                .flatMap(Contlnfo::getAdrs)
                .orElse("There's no address information.");

        System.out.println(addr);    	//Republic of Korea
    }

    public static void main(String[] args) {
        Optional<Contlnfo> ci = Optional.of(
                    new Contlnfo(Optional.ofNullable(null), Optional.of("Republic of Korea"))
        );
        Optional<Conpany> cp = Optional.of(new Conpany("YaHo Co., Ltd.", ci));
        Optional<Friiend> frn = Optional.of(new Friiend("LEE SU", cp));

        // 친구 정보에서 회사 주소를 출력
        showCompAddr(frn);
    }
}

