package optional;

import java.util.Optional;

class Friennd {
    String name;
    Companny cmp;    // null 일 수 있음

    public Friennd(String n, Companny c) {
        name = n;
        cmp = c;
    }
    public String getName() { return name; }
    public Companny getCmp() { return cmp; }
}

class Companny {
    String cName;
    ContInnfo cInfo;    // null 일 수 있음

    public Companny(String cn, ContInnfo ci) {
        cName = cn;
        cInfo = ci;
    }
    public String getCName() { return cName; }
    public ContInnfo getCInfo() { return cInfo; }

}

class ContInnfo {
    String phone;   // null 일 수 있음
    String adrs;    // null 일 수 있음

    public ContInnfo(String ph, String ad) {
        phone = ph;
        adrs = ad;
    }
    public String getPhone() { return phone; }
    public String getAdrs() { return adrs; }

}

class NullPointerCaseStudy2 {
    public static void showCompAddr(Optional<Friennd> f) {
        String addr = f.map(Friennd::getCmp)
                .map(Companny::getCInfo)
                .map(ContInnfo::getAdrs)
                .orElse("There's no address information.");

        System.out.println(addr);
    }

    public static void main(String[] args) {

        ContInnfo ci = new ContInnfo("321-444-577", "Republic of Korea");
        Companny cp = new Companny("YaHo Co., Ltd.", ci);
        Friennd frn = new Friennd("LEE SU", cp);

        // 친구 정보에서 회사 주소를 출력
        showCompAddr(Optional.of(frn));	//Republic of Korea
    }
}

