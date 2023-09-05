package optional;

class Friend {
    String name;
    Company cmp;    // null 일 수 있음

    public Friend(String n, Company c) {
        name = n;
        cmp = c;
    }

    public String getName() { return name; }
    public Company getCmp() { return cmp; }
}

class Company {
    String cName;
    ContInfo cInfo;    // null 일 수 있음

    public Company(String cn, ContInfo ci) {
        cName = cn;
        cInfo = ci;
    }

    public String getCName() { return cName; }
    public ContInfo getCInfo() { return cInfo; }

}

class ContInfo {
    String phone;   // null 일 수 있음
    String adrs;    // null 일 수 있음

    public ContInfo(String ph, String ad) {
        phone = ph;
        adrs = ad;
    }

    public String getPhone() { return phone; }
    public String getAdrs() { return adrs; }

}

class NullPointerCaseStudy {
    public static void showCompAddr(Friend f) {
        String addr = null;
    
        if(f != null) {
            Company com = f.getCmp();
            
            if(com != null) {
                ContInfo info = com.getCInfo();
                
                if(info != null)
                    addr = info.getAdrs();   
            }
        }
        
        if(addr != null)
            System.out.println(addr);
        else
            System.out.println("There's no address information.");
    }

    public static void main(String[] args) {

        ContInfo ci = new ContInfo("321-444-577", "Republic of Korea");
        Company cp = new Company("YaHo Co., Ltd.", ci);
        Friend frn = new Friend("LEE SU", cp);

        // 친구 정보에서 회사 주소를 출력
        showCompAddr(frn);		//Republic of Korea
    }
}


/*
코드를 작성하고 실행하다 보면 NullPointerException 예외를 접할 수 있다. 따라서 이에 대한 처리를 고려하고
코드를 작성해야 하는데, 이는 어렵지는 않지만 매우 번거로운 일이다. 그래서 이러한 일을 단순히 처리할 수 있도록 자바 8에서 "Optional 클래스"가 소개되었다.

예제에서 정의한 클래스의 멤버 중 일부에는 다음과 같이 null이 저장될 수 있다.

class ContInfo {
    String phone;   // 전화번호 정보가 없을 수 있다.
    String adrs;    // 주소 정보가 없을 수 있다.
}

실제로 친구가 휴직 상태이거나 회사에 재직 중임에도 불구하고 개인에게 할당된 업무용 전화번호가
없다면 해당 멤버는 null 일 수 있다. 그러나 이로 인해 친구가 재직 중인 회사의 주소를 출력하는 일이
다음과 같이 복잡해졌다.

    public static void showCompAddr(Friend f) {
        String addr = null;
    
        if(f != null) {	// 인자로 저달된 것이 null 일 수도 있으니
            Company com = f.getCmp();
            
            if(com != null) {	// 회사 정보가 없을 수도 있으니
                ContInfo info = com.getCInfo();
                
                if(info != null)	// 회사의 연락처 정보가 없을 수도 있으니
                    addr = info.getAdrs();   
            }
        }
        
        if(addr != null)	// 위의 코드에서 주소 정보를 얻지 못했을 수 있으니
            System.out.println(addr);
        else
            System.out.println("There's no address information.");
    }
    
이상한 코드 같지만 실제 개발  과정에서 이러한 코드는 의외로 자주 등장한다. 그리고 이는 어려운 코드는 아니지만
작성하기 번거롭고 보기에도 혼란스럽다. 하지만 NullPointerException 예외가 발생하는 것을 막으려면
이 방법이 가장 무난하다. 그런데 반갑게도 이러한 상황을 개선할 수 있도록 자바 8에서 Optional 클래스가 소개되었다.

Optional 클래스를 공부한다는 것은 Optional 클래스를 공부하면 세련된 코드를 즐겁게 작성할 수 있다. 
그러나 늘 그렇듯 세련된 코드를 작성하려면 그만큼 더 알아야 한다.
*/
